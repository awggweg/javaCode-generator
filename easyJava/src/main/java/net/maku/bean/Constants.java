package net.maku.bean;

import net.maku.utils.PropertiesUtils;

public class Constants {
    public static Boolean IGNORE_TABLE_PREFIX ;
    public static String SUFFIX_BEAN_PARAM;

    //需要忽略的属性
    public static String IGNORE_BEAN_TOJSON_FILED;
    public static String IGNORE_BEAN_TOJSON_EXPRESSIONS;
    public static String IGNORE_BEAN_TOJSON_CLASS;

    //日期序列化，反序列化
    public static String BEAN_DATE_FORMAT_EXPRESSION;
    public static String BEAN_DATE_FORMAT_CLASS;

    public static String BEAN_DATE_UNFORMAT_EXPRESSION;
    public static String BEAN_DATE_UNFORMAT_CLASS;

    public static String PATH_BASE;
    public static String PATH_PO;
    public static String PATH_JAVA="java";
    public static String PACKAGE_BASE;
    public static String PACKAGE_PO;
    public static String AUTHOR_NAME;

    public static String BEAN_DATA_EXPRESSION;
    public static String BEAN_DATA_CLASS;
    static {
        IGNORE_TABLE_PREFIX=Boolean.valueOf(PropertiesUtils.get("ignore.table.prefix"));
        SUFFIX_BEAN_PARAM=PropertiesUtils.get("suffix.bean.param");

        PATH_BASE=PropertiesUtils.get("path.base");
        PATH_BASE=PATH_BASE+PATH_JAVA+"/"+PropertiesUtils.get("package.base");
        PATH_BASE=PATH_BASE.replace(".","/");

        PATH_PO=PATH_BASE+"/"+PropertiesUtils.get("package.po").replace(".","/");
        PACKAGE_BASE=PropertiesUtils.get("package.base");
        PACKAGE_PO=PACKAGE_BASE+"."+PropertiesUtils.get("package.po");

        AUTHOR_NAME=PropertiesUtils.get("authorName");

        IGNORE_BEAN_TOJSON_CLASS=PropertiesUtils.get("ignore.bean.tojson.class");
        IGNORE_BEAN_TOJSON_FILED=PropertiesUtils.get("ignore.bean.tojson.filed");
        IGNORE_BEAN_TOJSON_EXPRESSIONS=PropertiesUtils.get("ignore.bean.tojson.expression");

        BEAN_DATE_FORMAT_EXPRESSION=PropertiesUtils.get("bean.date.format.expression");
        BEAN_DATE_FORMAT_CLASS=PropertiesUtils.get("bean.date.format.class");
        BEAN_DATE_UNFORMAT_EXPRESSION=PropertiesUtils.get("bean.date.unformat.expression");
        BEAN_DATE_UNFORMAT_CLASS=PropertiesUtils.get("bean.date.unformat.class");

        BEAN_DATA_CLASS=PropertiesUtils.get("bean.data.class");
        BEAN_DATA_EXPRESSION=PropertiesUtils.get("bean.data.expression");
    }
    public final static String[] SQL_DATE_TIME_TYPES=new String[]{"datetime","timestamp"};
    public final static String[] SQL_DATE_TYPES=new String[]{"date"};
    public final static String[] SQL_DECIMAL_TYPES=new String[]{"decimal","float","double"};
    public final static String[] SQL_INTEGER_TYPES=new String[]{"int","tinyint","smallint","mediumint"};
    public final static String[] SQL_STRING_TYPES=new String[]{"char","varchar","text","longtext","mediumtext"};
    public final static String[] SQL_LONG_TYPES=new String[]{"bigint"};
}
