package net.maku;

import net.maku.bean.TableInfo;
import net.maku.builder.BuildBase;
import net.maku.builder.BuildPo;
import net.maku.builder.BuildQuery;
import net.maku.builder.buildTable;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<TableInfo> tableInfoList=buildTable.getTables();
        BuildBase.execute();//生成常规的工具类
        for(TableInfo tableInfo:tableInfoList){
            BuildPo.execute(tableInfo);//根据表信息生成实体类
            BuildQuery.execute(tableInfo);//根据表生成实体类的query类
        }

    }

}