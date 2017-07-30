package pl.uzu.mk.a4_tablayoutviewpager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ViewPager viewpager ;
    Context context ;
    CustomPagerAdapter adapter ;
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
        viewpager = (ViewPager) findViewById(R.id.ViewPager) ;
        tabLayout = (TabLayout) findViewById(R.id.Tablayout);


    }

    private void setupViewPager(){

        adapter = new CustomPagerAdapter(getSupportFragmentManager(), context) ;
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setIcon(R.drawable.pizza_white) ;
        tabLayout.getTabAt(1).setIcon(R.drawable.pasta_white) ;
        tabLayout.getTabAt(2).setIcon(R.drawable.chicken2_white) ;
        tabLayout.getTabAt(3).setIcon(R.drawable.coffee_white) ;
        tabLayout.getTabAt(4).setIcon(R.drawable.cupcake_white) ;
        tabLayout.getTabAt(5).setIcon(R.drawable.donut_white) ;
        tabLayout.getTabAt(6).setIcon(R.drawable.drink_white) ;
        tabLayout.getTabAt(7).setIcon(R.drawable.hamburger_white) ;
        tabLayout.getTabAt(8).setIcon(R.drawable.hotdog_white) ;
        tabLayout.getTabAt(9).setIcon(R.drawable.sandwich_white) ;
        tabLayout.getTabAt(10).setIcon(R.drawable.icecream_cone2_white) ;
        tabLayout.getTabAt(11).setIcon(R.drawable.icecream_stick1_white) ;
        tabLayout.getTabAt(12).setIcon(R.drawable.icecream_sundae2_white) ;
        tabLayout.getTabAt(13).setIcon(R.drawable.icecream_twister_white) ;

        setupViewPagerHeadingIcons();

    }


    public void setupViewPagerHeadingIcons(){


        /*
         * The following for loop will apply a tint of grey color on all the tablayout icons
         */
        int NoOfItems = 14 ;
        for (int i=0;i<NoOfItems;i++) {
            tabLayout.getTabAt(i).getIcon().setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);

        }



        /*
         * The onTabSelectedListener is called whenever we change tabs. In this we can perform some action when a tab is selected and then unselected
         * Here what we are doing is that whenever tab is selected, a white tint is applied on it
         * When it is unselected, a grey tint is applied on it, so it goes back to its previous color.
         * Doing this will make it look like that by default all items were grey, but when a item is selected, then its white
         */
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
        tabLayout.getTabAt(1).select();
        tabLayout.getTabAt(0).select();
    }

}
