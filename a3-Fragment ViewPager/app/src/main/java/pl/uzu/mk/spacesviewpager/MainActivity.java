package pl.uzu.mk.spacesviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements MyListeners.MyFragmentClickListnere {
    ViewPager viewpager ;
    Context context ;
    CustomPagerAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext() ;



        // To make the viewpager show boundaries on both sides, we need to do three things
        // 1. Set margin between pages of viewPager --> viewpager.setPageMargin
        // 2. Add padding on both sides of Viewpager in xml
        // 3. Set clipToPadding to false in ViewPager. We can do it in xml
        // or we can do it in code. In xml it is android:clipToPadding="false"
        // and in code it is viewpager.setClipToPadding(false);

        viewpager = (ViewPager) findViewById(R.id.ViewPager) ;
        viewpager.setPageMargin(24);

        adapter = new CustomPagerAdapter(getSupportFragmentManager(), context) ;
        viewpager.setAdapter(adapter);

        // we must call this method setCurrentItem after calling the setAdapter
        viewpager.setCurrentItem(3);

    }


    @Override
    public void OnMyClick(int position) {
        Message.display(context, "fragment " + position + " is clicked");
    }
}
