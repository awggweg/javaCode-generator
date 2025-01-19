package net.maku.builder;

import net.maku.bean.Constants;
import net.maku.bean.TableInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

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
            bw.newLine();
            bw.write("public class "+tableInfo.getBeanName()+" implements Serializable {");
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
        }finally{
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
