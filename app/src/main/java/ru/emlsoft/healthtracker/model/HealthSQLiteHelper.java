package ru.emlsoft.healthtracker.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HealthSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "sample_database";

    public HealthSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(HealthDBContract.DrugDb.CREATE_TABLE);
        sqLiteDatabase.execSQL(HealthDBContract.FormOfDrug.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + HealthDBContract.DrugDb.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + HealthDBContract.FormOfDrug.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}