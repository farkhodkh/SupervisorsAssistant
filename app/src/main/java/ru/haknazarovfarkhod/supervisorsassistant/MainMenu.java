package ru.haknazarovfarkhod.supervisorsassistant;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainMenu extends Fragment {
    private OnFragmentInteractionListener mListener;

    private ProductsFragment productsFragment;
    private Button newOrderButton;
    private Button ordersListButton;
    private Button productsMatrixButton;
    private Button tradeOutletsButton;

    public MainMenu() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        //productsFragment = new ProductsFragment();

        newOrderButton = view.findViewById(R.id.newOrderButton);
        newOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });

        ordersListButton = view.findViewById(R.id.ordersListButton);
        ordersListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        productsMatrixButton = view.findViewById(R.id.productsMatrixButton);
        productsMatrixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        tradeOutletsButton = view.findViewById(R.id.tradeOutletsButton);
        tradeOutletsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
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
        fragmentManager
                .beginTransaction()
                .add(R.id.mainActivity_ConstraintLayout, productsFragment, MainActivity.PRODUCTS_FRAGMENT_TAG)
                .addToBackStack(null)
                .commit();
    }
}
