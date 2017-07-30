package pl.uzu.mk.a8_1tablayout_multiviewpager;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    NonSwipeableViewPager viewpager, viewPager2 ;
    String LOG_TAG = "log taggy" ;
    Context context ;
    CustomPagerAdapter adapter, adapter2 ;
    TabLayout tabLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this ;


        getReferences() ;
        setupViewPager() ;



    }

    private void getReferences(){
        viewpager = (NonSwipeableViewPager) findViewById(R.id.ViewPager) ;
        viewPager2 = (NonSwipeableViewPager) findViewById(R.id.ViewPager2) ;
        tabLayout = (TabLayout) findViewById(R.id.Tablayout);


    }

    private void setupViewPager(){

        adapter = new CustomPagerAdapter(getSupportFragmentManager(), context) ;
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);


        adapter2 = new CustomPagerAdapter(getSupportFragmentManager(), context) ;
        viewPager2.setAdapter(adapter2);

        tabLayout.setupWithViewPager(viewPager2);




        setupViewPagerHeadingIcons();

    }


    public void setupViewPagerHeadingIcons(){



        tabLayout.getTabAt(0).setIcon(R.drawable.pizza_white) ;
        tabLayout.getTabAt(1).setIcon(R.drawable.pasta_white) ;
        tabLayout.getTabAt(2).setIcon(R.drawable.chicken2_white) ;
        tabLayout.getTabAt(3).setIcon(R.drawable.coffee_white) ;
        tabLayout.getTabAt(4).setIcon(R.drawable.cupcake_white) ;
        tabLayout.getTabAt(5).setIcon(R.drawable.donut_white) ;


        /*
         * The following for loop will apply a tint of grey color on all the tablayout icons
         */
        int NoOfItems = 6 ;
        for (int i=0;i<NoOfItems;i++) {
            tabLayout.getTabAt(i).getIcon().setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);

        }




        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewpager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);

                        int tabIconColor = ContextCompat.getColor(context, R.color.white);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        int tabIconColor = ContextCompat.getColor(context, R.color.grey);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
        /*
         * The following two lines are needed, because the above onTabSelectedLIstener works when a tab is changed,
         * so by default it does not work on 0th item
         * Although it may seem that tab at position 0 is selected, but it is not.
         * So to run the above onTabSelectedListener code on first open, we firstly select item at position 1 and then select item at position 0
         */
//        tabLayout.getTabAt(1).select();
//        tabLayout.getTabAt(0).select();
    }

}
