package ru.haknazarovfarkhod.supervisorsassistant;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PRODUCTS_FRAGMENT_TAG = "products_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View mainActivity_ConstraintLayout = (View) findViewById(R.id.mainActivity_ConstraintLayout);
        ProdictsFragment prodictsFragment = new ProdictsFragment();

        getFragmentManager()
                .beginTransaction()
                .add(R.id.mainActivity_ConstraintLayout, prodictsFragment, PRODUCTS_FRAGMENT_TAG)
                .commit();

        Fragment fragment = getFragmentManager().findFragmentByTag(PRODUCTS_FRAGMENT_TAG);

        Toast.makeText(getApplicationContext(),"Hello from fragment", Toast.LENGTH_LONG).show();
    }
}
