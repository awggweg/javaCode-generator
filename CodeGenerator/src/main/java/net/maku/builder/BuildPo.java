package net.maku.builder;

import net.maku.bean.Constants;
import net.maku.bean.FieldInfo;
import net.maku.bean.TableInfo;
import net.maku.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.io.*;
import java.util.Arrays;

public class BuildPo {
    private static final Logger logger= LoggerFactory.getLogger(BuildPo.class);
    public static void execute(TableInfo tableInfo){
        File folder=new File(Constants.PATH_PO);
        if(!folder.exists()){//检测指向的路径是否存在
            folder.mkdirs();//不存在，则按照路径层次依次创建文件夹
        }
        File file=new File(folder,tableInfo.getBeanName()+".java");

        OutputStream out=null;
        OutputStreamWriter outW=null;
        BufferedWriter bw=null;
        try{
            out=new FileOutputStream(file);//文件输出流，将数据写入
            //指定文件file
            outW=new OutputStreamWriter(out,"utf8");
            //字符流，指定编码格式utf8
            bw=new BufferedWriter(outW);
            //缓冲流，提高写入效率
            bw.write("package "+Constants.PACKAGE_PO+";");
            bw.newLine();
            bw.newLine();
            bw.write("import java.io.Serializable;");
            bw.newLine();
            if(tableInfo.getHaveDate()||tableInfo.getHaveDateTime()){
                bw.write("import java.util.Date;");
                bw.newLine();
                bw.write(Constants.BEAN_DATE_FORMAT_CLASS+";");
                bw.newLine();
                bw.write(Constants.BEAN_DATE_UNFORMAT_CLASS+";");
                bw.newLine();

                bw.write("import "+Constants.PACKAGE_ENUMS+".DatePatternEnum;");
                bw.newLine();
                bw.write("import "+Constants.PACKAGE_UTILS+".DateUtil;");
                bw.newLine();
            }
            //序列化忽略属性
            Boolean haveIgnoreBean=false;
            for(FieldInfo field:tableInfo.getFieldList()){
                if(Arrays.stream(Constants.IGNORE_BEAN_TOJSON_FILED.split(",")).anyMatch(field.getPropertyName()::contains)){
                    haveIgnoreBean=true;
                    break;
                }
            }
            if(haveIgnoreBean){
                bw.write(Constants.IGNORE_BEAN_TOJSON_CLASS+";");
                bw.newLine();
            }
            //@Data解决get set方法
            bw.write(Constants.BEAN_DATA_CLASS+";");
            bw.newLine();

            if(tableInfo.getHaveBigDecimal()){
                bw.write("import java.math.BigDecimal;");
                bw.newLine();
            }
            bw.newLine();
            BuildComment.createClassComment(bw,tableInfo.getComment());

            //添加类级注解
            bw.write(Constants.BEAN_DATA_EXPRESSION);
            bw.newLine();
            bw.write("public class "+tableInfo.getBeanName()+" implements Serializable {");
            bw.newLine();

            for(FieldInfo field:tableInfo.getFieldList()){
                BuildComment.createFieldComment(bw,field.getComment());

                if(Arrays.stream(Constants.SQL_DATE_TIME_TYPES).anyMatch(field.getSqlType()::contains)){
                    bw.write("\t"+String.format(Constants.BEAN_DATE_FORMAT_EXPRESSION, DateUtils.YYYY_MM_DD_HH_MM_SS));
                    bw.newLine();
                    bw.write("\t"+String.format(Constants.BEAN_DATE_UNFORMAT_EXPRESSION, DateUtils.YYYY_MM_DD_HH_MM_SS));
                    bw.newLine();
                }

                if(Arrays.stream(Constants.SQL_DATE_TYPES).anyMatch(field.getSqlType()::contains)){
                    bw.write("\t"+String.format(Constants.BEAN_DATE_FORMAT_EXPRESSION, DateUtils.YYYY_MM_DD));
                    bw.newLine();
                    bw.write("\t"+String.format(Constants.BEAN_DATE_UNFORMAT_EXPRESSION, DateUtils.YYYY_MM_DD));
                    bw.newLine();
                }

                if(Arrays.stream(Constants.IGNORE_BEAN_TOJSON_FILED.split(",")).anyMatch(field.getPropertyName()::contains)){
                    bw.write("\t"+String.format(Constants.IGNORE_BEAN_TOJSON_EXPRESSIONS,DateUtils.YYYY_MM_DD));
                    bw.newLine();
                }
                bw.write("\tprivate "+field.getJavaType()+" "+field.getPropertyName()+";");
                bw.newLine();
                bw.newLine();


            }
            //重写toString方法
            StringBuffer toString=new StringBuffer();
            Integer index=0;
            for(FieldInfo field:tableInfo.getFieldList()){
                index++;

                String properName=field.getPropertyName();
                if(Arrays.stream(Constants.SQL_DATE_TIME_TYPES).anyMatch(properName::contains)){
                    properName="DateUtils.format("+properName+",DatePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())";
                }else if(Arrays.stream(Constants.SQL_DATE_TYPES).anyMatch(properName::contains)){
                    properName="DateUtils.format("+properName+",DatePatternEnum.YYYY_MM_DD.getPattern())";
                }
                toString.append(field.getComment()+":\"+("+field.getPropertyName()+"==null?\"空\" :"+properName+")");
                if(index<tableInfo.getFieldList().size()){
                    if(index<tableInfo.getFieldList().size()){
                        toString.append("+").append("\",");
                    }
                }

            }
            String toStringStr=toString.toString();
            toStringStr="\""+toStringStr;
            bw.write("\t@Override");
            bw.newLine();
            bw.write("\tpublic String toString(){");
            bw.newLine();
            bw.write("\t\treturn "+toStringStr+";");
            bw.newLine();
            bw.write("\t}");
            bw.newLine();
            bw.write("}");
            bw.flush();
            //将缓冲区数据写入文件，清空缓冲区
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    logger.error("关闭BufferedWriter失败",e);
                }
            }
            if(outW!=null){
                try {
                    outW.close();
                } catch (IOException e) {
                    logger.error("关闭OutputStreamWriter失败",e);
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("关闭OutputStream失败",e);
                }
            }
        }
    }
}
