package net.maku.builder;

import net.maku.bean.Constants;
import net.maku.utils.PropertiesUtils;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class BuildBase {
    public static void execute(){
        List<String> headInfoList=new ArrayList<>();
        headInfoList.add("package"+ " "+Constants.PACKAGE_UTILS);
        build(headInfoList,"DateUtil",Constants.PATH_UTILS);

        headInfoList.clear();
        headInfoList.add("package"+" "+Constants.PACKAGE_ENUMS);
        build(headInfoList,"DatePatternEnum",Constants.PATH_ENUMS);
    }
//headInfoList是一个字符串列表，用于存储类的头部信息，包括Package包名等
    private static void build(List<String> headInfoList,String fileName,String outPutPath){
        File folder =new File(outPutPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        File beanFile=new File(outPutPath,fileName+".java");
        FileOutputStream out=null;
        OutputStreamWriter outW=null;
        BufferedWriter bw=null;

        InputStream in=null;
        InputStreamReader inr=null;
        BufferedReader bf=null;
        try{
            out=new FileOutputStream(beanFile);
            outW=new OutputStreamWriter(out,"utf-8");
            bw=new BufferedWriter(outW);
            in= BuildBase.class.getClassLoader().getResourceAsStream("template/"+fileName+".txt");
            inr=new InputStreamReader(in,"utf-8");
            bf=new BufferedReader(inr);

            for(String str:headInfoList){
                bw.write(str+";");
                bw.newLine();
            }
            bw.newLine();
            bw.newLine();
            String lineInfo=null;
            while((lineInfo=bf.readLine())!=null){
                bw.write(lineInfo);
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            if (in != null) {
                try{
                    in.close();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
            if (inr != null) {
                try {
                    inr.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outW != null) {
                try {
                    outW.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
