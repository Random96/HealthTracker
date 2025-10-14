package ru.emlsoft.healthtracker.model;

import android.provider.BaseColumns;

import java.lang.reflect.Array;

public final class HealthDBContract {

    private HealthDBContract() {
    }

    public static class Dimension implements BaseColumns {
        public static final String TABLE_NAME = "dimension";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORT_NAME = "short_name";
        public static final String COLUMN_PARENT = "parent";
        public static final String COLUMN_QTY = "qty";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT(200),"
                + COLUMN_SHORT_NAME + " TEXT(10),"
                + COLUMN_PARENT + " INTEGER,"
                + COLUMN_QTY + " NUMBER,"
                + "UNIQUE KEY ( " + COLUMN_NAME + "),"
                + "FOREIGN KEY ( " + COLUMN_PARENT + ") REFERENCES "
                + TABLE_NAME + "(" + _ID + ")"
                + ")";
    }

    public static class DrugDb implements BaseColumns {
        public static final String TABLE_NAME = "drug";
        public static final String COLUMN_NAME = "name";
        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT,"
                + "UNIQUE KEY ( " + COLUMN_NAME + ")"
                + ")";

        public Drug[] GetList() {
            return null;
        }
    }

    public static class FormOfDrug implements BaseColumns {
        public static final String TABLE_NAME = "formofdrug";

        public static final String COLUMN_DRUG_ID = "drug_id";
        public static final String COLUMN_FACTOR_TYPE = "factor_type";
        public static final String COLUMN_QTY = "qty";
        public static final String COLUMN_DIMENSION_ID = "dimension_id";
        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_DRUG_ID + " INTEGER NOT NULL,"
                + COLUMN_FACTOR_TYPE + " INTEGER(1) NOT NULL,"
                + COLUMN_QTY + " NUMBER,"
                + COLUMN_DIMENSION_ID + " INTEGER,"
                + "FOREIGN KEY ( " + COLUMN_DRUG_ID + ") REFERENCES "
                + DrugDb.TABLE_NAME + "(" + DrugDb._ID + "),"
                + "FOREIGN KEY ( " + COLUMN_DIMENSION_ID + ") REFERENCES "
                + DrugDb.TABLE_NAME + "(" + Dimension._ID + ")"
                + ")";
    }
}
