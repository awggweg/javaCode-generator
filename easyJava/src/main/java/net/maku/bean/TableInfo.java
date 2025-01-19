package net.maku.bean;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class TableInfo {
    private String tableName;

    private String beanName;
    //参数名称
    private String beanParamName;

    private String comment;

    private List<FieldInfo> fieldList;

    private Map<String,List<FieldInfo>> keyIndexMap = new LinkedHashMap<>();

    private Boolean haveDate=false;

    private Boolean haveDateTime=false;

    private Boolean haveBigDecimal=false;
}
