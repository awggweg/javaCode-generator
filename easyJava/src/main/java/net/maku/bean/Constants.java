package net.maku.bean;

import net.maku.utils.PropertiesUtils;

public class Constants {
    public static Boolean IGNORE_TABLE_PREFIX ;
    public static String SUFFIX_BEAN_PARAM;
    public static String PATH_BASE;
    public static String PATH_PO;
    public static String PATH_JAVA="java";
    public static String PACKAGE_BASE;
    public static String PACKAGE_PO;
    static {
        IGNORE_TABLE_PREFIX=Boolean.valueOf(PropertiesUtils.get("ignore.table.prefix"));
        SUFFIX_BEAN_PARAM=PropertiesUtils.get("suffix.bean.param");

        PATH_BASE=PropertiesUtils.get("path.base");
        PATH_BASE=PATH_BASE+PATH_JAVA+"/"+PropertiesUtils.get("package.base");
        PATH_BASE=PATH_BASE.replace(".","/");

        PATH_PO=PATH_BASE+"/"+PropertiesUtils.get("package.po").replace(".","/");
        PACKAGE_BASE=PropertiesUtils.get("package.base");
        PACKAGE_PO=PACKAGE_BASE+"."+PropertiesUtils.get("package.po");
    }
    public final static String[] SQL_DATE_TIME_TYPES=new String[]{"datetime","timestamp"};
    public final static String[] SQL_DATE_TYPES=new String[]{"date"};
    public final static String[] SQL_DECIMAL_TYPES=new String[]{"decimal","float","double"};
    public final static String[] SQL_INTEGER_TYPES=new String[]{"int","tinyint","smallint","mediumint"};
    public final static String[] SQL_STRING_TYPES=new String[]{"char","varchar","text","longtext","mediumtext"};
    public final static String[] SQL_LONG_TYPES=new String[]{"bigint"};
}
