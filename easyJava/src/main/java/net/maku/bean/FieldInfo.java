package net.maku.bean;

import lombok.Data;

@Data
public class FieldInfo {
    private String FieldName;

    private String propertyName;

    private String sqlType;
//对应java的类型
    private String javaType;

    private String comment;
//是否自增长
    private Boolean isAutoIncrement;

}
