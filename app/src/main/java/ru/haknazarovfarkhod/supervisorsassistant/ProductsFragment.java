package ru.haknazarovfarkhod.supervisorsassistant;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import ru.haknazarovfarkhod.supervisorsassistant.DBControlers.DatabaseHelper;

public class ProductsFragment extends Fragment {
    ListView productList;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor productCursor;
    SimpleCursorAdapter productAdapter;
    ListView productListView;

    public ProductsFragment() {

    }

//    public static ProductsFragment newInstance(String param1, String param2) {
//        ProductsFragment fragment = new ProductsFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_prodicts,
                container, false);
        productListView = view.findViewById(R.id.list);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        db = databaseHelper.getReadableDatabase();
        databaseHelper.onCreate(db);

        productCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLE_NAME, null);

        String[] headers = new String[] {DatabaseHelper.COLUMN_PRODUCMNAME, DatabaseHelper.COLUMN_ARTICLENUMBER};

        productAdapter = new SimpleCursorAdapter(getContext(), android.R.layout.two_line_list_item,
                productCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);

        productListView.setAdapter(productAdapter);
    }

}
