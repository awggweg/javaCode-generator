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

public class BuildQuery {
    private static final Logger logger= LoggerFactory.getLogger(BuildPo.class);
    public static void execute(TableInfo tableInfo){
        File folder=new File(Constants.PATH_QUERY);
        if(!folder.exists()){//检测指向的路径是否存在
            folder.mkdirs();//不存在，则按照路径层次依次创建文件夹
        }
        String className=tableInfo.getBeanName()+Constants.SUFFIX_BEAN_PARAM;

        File file=new File(folder,className+".java");

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
            bw.write("package "+Constants.PACKAGE_QUERY+";");
            bw.newLine();
            bw.newLine();

            if(tableInfo.getHaveDate()||tableInfo.getHaveDateTime()){
                bw.write("import java.util.Date;");
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
            BuildComment.createClassComment(bw,tableInfo.getComment()+"查询对象");

            //添加类级注解
            bw.write(Constants.BEAN_DATA_EXPRESSION);
            bw.newLine();
            bw.write("public class "+className+" {");
            bw.newLine();

            for(FieldInfo field:tableInfo.getFieldList()){
                BuildComment.createFieldComment(bw,field.getComment());
                bw.write("\tprivate "+field.getJavaType()+" "+field.getPropertyName()+";");
                bw.newLine();
                bw.newLine();

                //对String类型的变量添加模糊搜索后缀
                if(Arrays.stream(Constants.SQL_STRING_TYPES).anyMatch(field.getSqlType()::contains)){
                    bw.write("\tprivate "+field.getJavaType()+" "+field.getPropertyName()+Constants.SUFFIX_BEAN_PARAM_FUZZY+";");
                    bw.newLine();
                    bw.newLine();
                }

                if(Arrays.stream(Constants.SQL_DATE_TYPES).anyMatch(field.getSqlType()::contains)||Arrays.stream(Constants.SQL_DATE_TIME_TYPES).anyMatch(field.getSqlType()::contains)){
                    bw.write("\tprivate String"+" "+field.getPropertyName()+Constants.SUFFIX_BEAN_PARAM_TIME_START+";");
                    bw.newLine();
                    bw.newLine();
                    bw.write("\tprivate String"+" "+field.getPropertyName()+Constants.SUFFIX_BEAN_PARAM_TIME_END+";");
                    bw.newLine();
                    bw.newLine();
                }
            }

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
