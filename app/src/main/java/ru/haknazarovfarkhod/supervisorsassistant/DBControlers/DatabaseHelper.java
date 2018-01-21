package ru.haknazarovfarkhod.supervisorsassistant.DBControlers;

//import SQLiteOpenHelper;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Farhod.Haknazarov on 19.01.2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_PATH;
    private static String DB_NAME = "supervisorsassistant.db";
    private static final int SCHEMA = 1;
    public static final String TABLE_NAME = "products";

    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCMNAME = "productName";
    public static final String COLUMN_UNITOFMEASUREMENT = "unitOfMeasurement";
    public static final String COLUMN_MINIMUMQUANTITY = "minimumQuantity";
    public static final String COLUMN_ARTICLENUMBER = "articleNumber";
    private Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext = context;
        DB_PATH = context.getFilesDir().getPath() + DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PRODUCMNAME + " TEXT, "
                + COLUMN_UNITOFMEASUREMENT + " TEXT, "
                + COLUMN_MINIMUMQUANTITY + " INTEGER, "
                + COLUMN_ARTICLENUMBER +" TEXT);");
        db.execSQL("INSERT INTO "+ TABLE_NAME +" (" + COLUMN_PRODUCMNAME + ", " + COLUMN_UNITOFMEASUREMENT  + ", " + COLUMN_MINIMUMQUANTITY + ", " + COLUMN_ARTICLENUMBER + ")"
                + " VALUES ('Товар №12345', 'шт', 5, 'ABC123456');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        onCreate(db);
    }
//
//    public SQLiteDatabase open()throws SQLException {
//
//        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
//    }
}
