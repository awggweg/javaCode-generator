package net.maku.builder;


import net.maku.bean.Constants;
import net.maku.utils.DateUtils;

import java.io.BufferedWriter;
import java.util.Date;

public class BuildComment {
    public static void createClassComment(BufferedWriter bw,String classComment) throws Exception{
        bw.write("/**");
        bw.newLine();
        bw.write(" * @Description:"+classComment);
        bw.newLine();
        bw.write(" * @Date:"+ DateUtils.format(new Date(),DateUtils.YYYYMMDD));
        //new Date获取系统时间，转换为DateUtils._YYYYMMDD指定格式
        bw.newLine();
        bw.write(" * @Author: "+ Constants.AUTHOR_NAME);
        bw.newLine();
        bw.write(" */");
        bw.newLine();
    }
    public static void createFieldComment(BufferedWriter bw,String fieldComment) throws Exception{
        bw.write("\t/**");
        bw.newLine();
        bw.write("\t * @Description:" + (fieldComment==null?"":fieldComment));
        bw.newLine();
        bw.write("\t*/");
        bw.newLine();
    }
    public static void createMethodComment(BufferedWriter bw,String methodComment) throws Exception{
        bw.write("\t/**");
        bw.newLine();
        bw.write("\t*Description:"+methodComment);
        bw.newLine();
        bw.write("\t*Date:");
        bw.newLine();
        bw.write("\t*/");
        bw.newLine();
    }
}
