package ru.haknazarovfarkhod.supervisorsassistant;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.haknazarovfarkhod.supervisorsassistant.DBControlers.DatabaseHelper;
import ru.haknazarovfarkhod.supervisorsassistant.DBControlers.Products.Product;
import ru.haknazarovfarkhod.supervisorsassistant.DBControlers.Products.ProductListAdapter;
import ru.haknazarovfarkhod.supervisorsassistant.DBControlers.Products.ProductsList;

public class ProdictsFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private ArrayAdapter<String> listAdapter;
    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor productCursor;
    ProductListAdapter productListAdapter;
    ListView productsList;
    //EditText userFilter;

    public ProdictsFragment() {

    }

    public static ProdictsFragment newInstance(String param1, String param2) {
        ProdictsFragment fragment = new ProdictsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getArguments() != null) {
//
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sqlHelper = new DatabaseHelper(getContext());
        // создаем базу данных
        sqlHelper.create_db();

        List<Product> productsList = new ProductsList().getProductsList();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                inflater.getContext(), android.R.layout.simple_list_item_1,
//                productsList);
//
//        setListAdapter(adapter);

        return inflater.inflate(R.layout.fragment_prodicts, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            db = sqlHelper.open();
            productCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE, null);
            String[] headers = new String[]{DatabaseHelper.COLUMN_productName, DatabaseHelper.COLUMN_articleNumber};
            productListAdapter = new ProductListAdapter(this, android.R.layout.two_line_list_item,
                    productCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);
//
//            // если в текстовом поле есть текст, выполняем фильтрацию
//            // данная проверка нужна при переходе от одной ориентации экрана к другой
//            if(!userFilter.getText().toString().isEmpty())
//                userAdapter.getFilter().filter(userFilter.getText().toString());
//
//            // установка слушателя изменения текста
//            userFilter.addTextChangedListener(new TextWatcher() {
//
//                public void afterTextChanged(Editable s) { }
//
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
//                // при изменении текста выполняем фильтрацию
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                    userAdapter.getFilter().filter(s.toString());
//                }
//            });
//
//            // устанавливаем провайдер фильтрации
//            userAdapter.setFilterQueryProvider(new FilterQueryProvider() {
//                @Override
//                public Cursor runQuery(CharSequence constraint) {
//
//                    if (constraint == null || constraint.length() == 0) {
//
//                        return db.rawQuery("select * from " + DatabaseHelper.TABLE, null);
//                    }
//                    else {
//                        return db.rawQuery("select * from " + DatabaseHelper.TABLE + " where " +
//                                DatabaseHelper.COLUMN_NAME + " like ?", new String[]{"%" + constraint.toString() + "%"});
//                    }
//                }
//            });

            productsList.setAdapter(productListAdapter);
        }
        catch (SQLException ex){}
    }
    }

    public void setListAdapter(ArrayAdapter<String> listAdapter) {
        this.listAdapter = listAdapter;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
