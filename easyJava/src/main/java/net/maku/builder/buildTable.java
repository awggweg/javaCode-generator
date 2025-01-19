package net.maku.builder;

//import jdk.nashorn.internal.runtime.JSONFunctions;
import net.maku.bean.Constants;
import net.maku.bean.FieldInfo;
import net.maku.bean.TableInfo;
import net.maku.utils.JsonUtils;
import net.maku.utils.PropertiesUtils;
import net.maku.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

public class buildTable {
    private static final Logger logger=LoggerFactory.getLogger(buildTable.class);
    private static Connection conn=null;
    private static String SQL_SHOW_TABLE_STATUS="show table status";
    private static String SQL_SHOW_TABLE_FIELDS="show full fields from %s";
    private static String SQL_SHOW_TABLE_INDEX="show index from %s";
    static{
        String diverName= PropertiesUtils.get("db.driver.name");
        System.out.printf("diverName: %s\n", diverName);
        String url= PropertiesUtils.get("db.url");
        System.out.printf("url: %s\n", url);
        String username= PropertiesUtils.get("db.username");
        System.out.printf("username: %s\n", username);
        String password= PropertiesUtils.get("db.password");
        System.out.printf("password: %s\n", password);
        try{
            Class.forName(diverName);
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException|ClassNotFoundException e){
           logger.error("数据库连接失败",e);
        }
    }
    public static List<TableInfo> getTables(){
        PreparedStatement ps=null;
        ResultSet tableResult=null;
        List<TableInfo> tableInfoList=new ArrayList<>();
        try{
            ps=conn.prepareStatement(SQL_SHOW_TABLE_STATUS);
            tableResult =ps.executeQuery();
            while(tableResult.next()){
                String tableName=tableResult.getString("Name");
                String comment=tableResult.getString("Comment");
                //logger.info("tableName:{},comment:{}",tableName,comment);


                String beanName=tableName;
                if(Constants.IGNORE_TABLE_PREFIX){
                    beanName=tableName.substring(tableName.indexOf("_")+1);
                }
                beanName=processField(beanName,true);
                TableInfo tableInfo=new TableInfo();
                tableInfo.setTableName(tableName);
                tableInfo.setBeanName(beanName);
                tableInfo.setComment(comment);
                tableInfo.setBeanParamName(beanName+Constants.SUFFIX_BEAN_PARAM);
                getFieldInfo(tableInfo);
//                logger.info("表：{}", JsonUtils.convertObj2Json(tableInfo));
//                logger.info("字段：{}",JsonUtils.convertObj2Json(fieldInfoList));
                getKeyIndexInfo(tableInfo);
                logger.info("表：{}", JsonUtils.convertObj2Json(tableInfo));
                tableInfoList.add(tableInfo);
            }
            return tableInfoList;
        } catch (SQLException e) {
            logger.error("读取表失败",e);
        }finally {
            if(tableResult!=null){
                try{
                    tableResult.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try{
                    ps.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            //这里对于数据库连接 文件流这些资源，必须用
            //close函数显式回收内存，否则会造成内存泄漏
            //这些是java的垃圾回收机制无法管到的
        }
        return null;
    }

    public static void getKeyIndexInfo(TableInfo tableInfo){
        PreparedStatement ps=null;
        ResultSet fieldResult=null;
//        List<FieldInfo> fieldInfoList=new ArrayList<>();
        try{
            Map<String ,FieldInfo> tempMap=new HashMap<>();
            for(FieldInfo fieldInfo:tableInfo.getFieldList()){
                tempMap.put(fieldInfo.getFieldName(),fieldInfo);
            }

            ps=conn.prepareStatement(String.format(SQL_SHOW_TABLE_INDEX,tableInfo.getTableName()));
            fieldResult=ps.executeQuery();
            while(fieldResult.next()){
                String keyName=fieldResult.getString("Key_name");
                Integer nonUnique=fieldResult.getInt("non_unique");
                String columnName=fieldResult.getString("Column_name");
                if(nonUnique==1){
                    continue;
                }
                List<FieldInfo> keyFieldList=tableInfo.getKeyIndexMap().get(keyName);
                if(null==keyFieldList){
                    keyFieldList=new ArrayList<>();
                    tableInfo.getKeyIndexMap().put(keyName,keyFieldList);
                }
//                for(FieldInfo fieldInfo:tableInfo.getFieldList()){
//                    if(fieldInfo.getFieldName().equals(columnName)){
//                        keyFieldList.add(fieldInfo);
//                    }
//                }
                keyFieldList.add(tempMap.get(columnName));
            }
        } catch (SQLException e) {
            logger.error("读取索引失败",e);
        }finally {
            if(fieldResult!=null){
                try{
                    fieldResult.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try{
                    ps.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }

        }

    }

    public static void getFieldInfo(TableInfo tableInfo){
        PreparedStatement ps=null;
        ResultSet fieldResult=null;
        try{
            ps=conn.prepareStatement(String.format(SQL_SHOW_TABLE_FIELDS,tableInfo.getTableName()));
            fieldResult=ps.executeQuery();
            List<FieldInfo> fieldInfoList=new ArrayList<>();
            while(fieldResult.next()){
                FieldInfo fieldInfo=new FieldInfo();
                String type=fieldResult.getString("Type");
                fieldInfo.setFieldName(fieldResult.getString("Field"));
                fieldInfo.setPropertyName(processField(fieldInfo.getFieldName(),false));
                if(type.indexOf("(")>0){
                    type=type.substring(0,type.indexOf("("));
                }
                fieldInfo.setSqlType(type);
                fieldInfo.setJavaType(processSqlType(fieldInfo.getSqlType()));
                fieldInfo.setIsAutoIncrement("auto_increment".equalsIgnoreCase(fieldResult.getString("Extra"))?true:false);
                fieldInfo.setComment(fieldResult.getString("Comment"));
                fieldInfoList.add(fieldInfo);
                if(Arrays.stream(Constants.SQL_DATE_TIME_TYPES).anyMatch(type::contains)){
                    tableInfo.setHaveDateTime(true);
                }
                if (Arrays.stream(Constants.SQL_DATE_TYPES).anyMatch(type::contains)) {
                    tableInfo.setHaveDate(true);
                }
                if(Arrays.stream(Constants.SQL_DECIMAL_TYPES).anyMatch(type::contains)){
                    tableInfo.setHaveBigDecimal(true);
                }
                logger.info("fieldInfo:{}",fieldInfoList);

            }
            tableInfo.setFieldList(fieldInfoList);
        } catch (SQLException e) {
            logger.error("读取字段失败",e);
        }finally {
            if(fieldResult!=null){
                try{
                    fieldResult.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try{
                    ps.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }

        }

    }

    private static String processField(String field,Boolean uperCaseFirstLetter){
        StringBuffer stringBuffer=new StringBuffer();
        String[] fields=field.split("_");
        stringBuffer.append(uperCaseFirstLetter? StringUtils.uperCaseFirstLetter(fields[0]):fields[0]);
        for(int i=1;i<fields.length;i++){
            stringBuffer.append(StringUtils.uperCaseFirstLetter(fields[i]));
        }
        return stringBuffer.toString();
    }

    private static String processSqlType(String type) {
        if (type == null) {
            return null;
        }

        type = type.toLowerCase();

        if (Arrays.stream(Constants.SQL_DATE_TIME_TYPES).anyMatch(type::contains)) {
            return "Date";
        }

        if (Arrays.stream(Constants.SQL_DATE_TYPES).anyMatch(type::contains)) {
            return "Date";
        }

        if (Arrays.stream(Constants.SQL_DECIMAL_TYPES).anyMatch(type::contains)) {
            return "BigDecimal";
        }

        if (Arrays.stream(Constants.SQL_INTEGER_TYPES).anyMatch(type::contains)) {
            return "Integer";
        }

        if (Arrays.stream(Constants.SQL_STRING_TYPES).anyMatch(type::contains)) {
            return "String";
        }

        if (Arrays.stream(Constants.SQL_LONG_TYPES).anyMatch(type::contains)) {
            return "Long";
        }

        logger.error("no matching type{}", type);
        return "Object";// Default type if no match is found
    }
}
