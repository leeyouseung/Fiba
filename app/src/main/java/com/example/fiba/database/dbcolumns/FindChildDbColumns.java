package com.example.fiba.database.dbcolumns;

import android.provider.BaseColumns;

public class FindChildDbColumns {

    private FindChildDbColumns() {

    }

    public static class FindChildEntry implements BaseColumns {

        public static final String TABLE_NAME = "find_child";
        public static final String CLUAMN_NAME_FIND_CHILD_NAME = "find_child_name";
        public static final String CLUAMN_NAME_LOST_PLACE = "lost_place";
        public static final String CLUAMN_NAME_FIND_CHILD_HEIGHT = "find_child_height";
        public static final String CLUAMN_NAME_FIND_CHILD_WEIGHT = "find_child_weight";
        public static final String CLUAMN_NAME_FIND_CHILD_SEX = "find_child_sex";
        public static final String CLUAMN_NAME_FIND_CHILD_AGE = "find_child_age";
    }
}
