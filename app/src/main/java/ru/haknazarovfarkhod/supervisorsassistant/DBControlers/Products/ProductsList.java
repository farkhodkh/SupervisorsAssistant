package ru.haknazarovfarkhod.supervisorsassistant.DBControlers.Products;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Farhod.Haknazarov on 19.01.2018.
 */

public class ProductsList {
    List<Product> productsList = new ArrayList<>();

    public List<Product> getProductsList() {


//        SQLiteDatabase db = applicationContext.openOrCreateDatabase("supervisorsassistant.db", MODE_PRIVATE, null);
//
//        Cursor query = db.rawQuery("SELECT * FROM products;", null);
//        if(!query.moveToFirst()){
//            db.execSQL("CREATE TABLE IF NOT EXISTS products (productName TEXT, unitOfMeasurement TEXT, int minimumQuantity, TEXT articleNumber)");
//
//            db.execSQL("INSERT INTO products VALUES ('Товар №1', 'шт', 5, 'АС456789');");
//            db.execSQL("INSERT INTO products VALUES ('Товар №2', 'кг', 1.5, 'АС789456');");
//            db.execSQL("INSERT INTO products VALUES ('Товар №3', 'шт', 10, 'АС321654');");
//
//            query = db.rawQuery("SELECT * FROM products;", null);
//        }
//
//        if(query.moveToFirst()){
//            do{
//                String productName = query.getString(0);
//                String unitOfMeasurementName = query.getString(1);
//                int minimumQuantity = query.getInt(2);
//                String articleNumber = query.getString(3);
//                productsList.add(new Product(productName, new UnitOfMeasurement(unitOfMeasurementName), minimumQuantity, articleNumber));
//            }
//            while(query.moveToNext());
//        }
//        query.close();
//        db.close();
//
        return productsList;
    }

//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
}
