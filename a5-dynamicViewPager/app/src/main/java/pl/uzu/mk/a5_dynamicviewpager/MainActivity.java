package pl.uzu.mk.a5_dynamicviewpager;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewpager ;
    Context context ;
    CustomPagerAdapter adapter ;
    TabLayout tabLayout ;
    ArrayList<ViewPager_DataObject> listOfViewPagerObject ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this ;


        getReferences() ;
        /*
         * The viewpager is setup in this fake fetch data method.
         * This is because we only want to setup the viewpager after fetching data from the internet
         */
        fetchFakeData();




    }

    private void getReferences(){
        viewpager = (ViewPager) findViewById(R.id.ViewPager) ;
        tabLayout = (TabLayout) findViewById(R.id.Tablayout);
    }


    public void fetchFakeData(){
        listOfViewPagerObject = new ArrayList<>() ;
        listOfViewPagerObject.add(new ViewPager_DataObject("Pizza", R.drawable.pizza_white, new Fragment_DataObject("This is yolo1", "#ff0000"))) ;
        listOfViewPagerObject.add(new ViewPager_DataObject("Pasta", R.drawable.pasta_white, new Fragment_DataObject("This is yolo2", "#0000ff"))) ;
        listOfViewPagerObject.add(new ViewPager_DataObject("Cupcake", R.drawable.cupcake_white,new Fragment_DataObject("This is yolo3", "#00ff00"))) ;
        listOfViewPagerObject.add(new ViewPager_DataObject("Donut", R.drawable.donut_white,new Fragment_DataObject("This is yolo4", "#ffff00"))) ;
        listOfViewPagerObject.add(new ViewPager_DataObject("Drink", R.drawable.drink_white,new Fragment_DataObject("This is yolo5", "#ff00ff"))) ;


        setupViewPager() ;
    }

    private void setupViewPager(){
        adapter = new CustomPagerAdapter(getSupportFragmentManager(), context, listOfViewPagerObject) ;
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        setupViewPagerHeadingIcons() ;




    }
    
    public void setupViewPagerHeadingIcons(){
        /*
         * The following for loop firstly assign an icon to all the tabs
         * Then it sets the default color for those tabs
         */
        int NoOfItems = listOfViewPagerObject.size() ;
        for (int i=0;i<NoOfItems;i++) {
            tabLayout.getTabAt(i).setIcon(listOfViewPagerObject.get(i).getIconId()) ;
            tabLayout.getTabAt(i).getIcon().setColorFilter(ContextCompat.getColor(context, R.color.DarkGrey), PorterDuff.Mode.SRC_IN);

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
                        int tabIconColor = ContextCompat.getColor(context, R.color.DarkGrey);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
        /*
         * The following two lines are needed, because the above onTabSelectedLIstener works a tab is changed, so by default it does not work
         * Although it may seem that tab at position 0 is selected, but it is not.
         * So to run the above onTabSelectedListener code on first open, we firstly select item at position 1 and then go back item at position 0
         */
        tabLayout.getTabAt(1).select();
        tabLayout.getTabAt(0).select();
    }
}
