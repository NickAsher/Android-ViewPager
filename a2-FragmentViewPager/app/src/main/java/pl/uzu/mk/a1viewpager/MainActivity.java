package pl.uzu.mk.a1viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ViewPager viewpager ;
    Context context ;
    CustomPagerAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext() ;

        // Firstly we get a reference to the ViewPager
        viewpager = (ViewPager) findViewById(R.id.ViewPager) ;

        // We make a new adapter class and then make an object of it.
        // We have to pass the fragment manager as an argument to it
        // Since we are using the support library fragments, we use getSupportFragment Manager
        adapter = new CustomPagerAdapter(getSupportFragmentManager()) ;

        // Finally, we just set the adapter to the viewpager
        viewpager.setAdapter(adapter);
    }


}
