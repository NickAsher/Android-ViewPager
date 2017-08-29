package pl.uzu.mk.simpleviewpager;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> arrayList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayList = new ArrayList<>() ;
        arrayList.add(R.drawable.a1);
        arrayList.add(R.drawable.a2);
        arrayList.add(R.drawable.a3);
        arrayList.add(R.drawable.a4);
        arrayList.add(R.drawable.a5);
        arrayList.add(R.drawable.a6);
        arrayList.add(R.drawable.a7);
        arrayList.add(R.drawable.a8);



        ViewPager viewPager = (ViewPager) findViewById(R.id.main_screen_viewpager);
        viewPager.setAdapter(new ImagePagerAdapter(this, arrayList));
    }


}
