package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        TableInterface tinterface;
        public TableInterfaceWrapper(TableInterface tableInterface) {
            this.tinterface = tableInterface;
        }

        @Override
        public void setModel(List rows) {
            System.out.print(rows.size());
            tinterface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return tinterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            tinterface.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}