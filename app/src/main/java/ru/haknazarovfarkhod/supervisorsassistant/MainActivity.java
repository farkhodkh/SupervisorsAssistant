package ru.haknazarovfarkhod.supervisorsassistant;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ru.haknazarovfarkhod.supervisorsassistant.DBControlers.Products.Product;

public class MainActivity extends AppCompatActivity {
    public static final String MAINMENY_FRAGMENT_TAG = "mainMenu_fragment";
    public static final String PRODUCTS_FRAGMENT_TAG = "products_fragment";

    private ProductsFragment productsFragment;

    private Button newOrderButton;
    private Button ordersListButton;
    private Button productsMatrixButton;
    private Button tradeOutletsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        newOrderButton = findViewById(R.id.newOrderButton);
        newOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });

        ordersListButton = findViewById(R.id.ordersListButton);
        ordersListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        productsMatrixButton = findViewById(R.id.productsMatrixButton);
        productsMatrixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        tradeOutletsButton = findViewById(R.id.tradeOutletsButton);
        tradeOutletsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });


//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager
//                .beginTransaction()
//                .add(R.id.mainActivity_ConstraintLayout, new MainMenu(), MAINMENY_FRAGMENT_TAG)
//                .addToBackStack(null)
//                .commit();
        return super.onCreateView(parent, name, context, attrs);
    }

    void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.productsMatrixButton:
                openTradeMatrixFragment();
        }
    }

    private void openTradeMatrixFragment() {
        FragmentManager fragmentManager = getFragmentManager();

        ProductsFragment currentFragment = (ProductsFragment) fragmentManager.findFragmentByTag(MainActivity.PRODUCTS_FRAGMENT_TAG);

        if (currentFragment != null) {
            fragmentManager
                    .beginTransaction()
                    .remove(currentFragment)
                    .commit();
        }

        productsFragment = new ProductsFragment();

        fragmentManager
                .beginTransaction()
                .add(R.id.mainActivity_ConstraintLayout, productsFragment, MainActivity.PRODUCTS_FRAGMENT_TAG)
                .addToBackStack(null)
                .commit();
    }
}
