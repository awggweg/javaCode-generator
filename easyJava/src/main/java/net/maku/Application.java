package net.maku;

import net.maku.bean.TableInfo;
import net.maku.builder.BuildPo;
import net.maku.builder.buildTable;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<TableInfo> tableInfoList=buildTable.getTables();
        BuildPo.execute(tableInfoList.get(0));
    }

}