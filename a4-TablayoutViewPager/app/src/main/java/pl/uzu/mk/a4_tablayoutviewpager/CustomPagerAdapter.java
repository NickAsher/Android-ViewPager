package pl.uzu.mk.a4_tablayoutviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import pl.uzu.mk.a4_tablayoutviewpager.fragments.fragment1;
import pl.uzu.mk.a4_tablayoutviewpager.fragments.fragment2;
import pl.uzu.mk.a4_tablayoutviewpager.fragments.fragment3;
import pl.uzu.mk.a4_tablayoutviewpager.fragments.fragment4;
import pl.uzu.mk.a4_tablayoutviewpager.fragments.fragment5;
import pl.uzu.mk.a4_tablayoutviewpager.fragments.fragment6;


public class CustomPagerAdapter extends FragmentPagerAdapter {
    Context context ;


    public CustomPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context ;
    }

    private String tabTitles[] = new String[] { "Pizza", "Pasta", "Chicken", "Coffee"
    , "Cupcake", "Donut", "Drinks", "Burgers", "Hotdogs", "Sandwiches", "Ice-crean Cones",
    "Ice-Cream Sticks", "Ice-cream Sundae", "Ice-cream Twister"};


    @Override
    public int getCount() {
        /**
         * We simply return the number of items that we are going to add in the View Pager
         */
        return 14;
    }



    @Override
    public Fragment getItem(int position) {
        /**
         * In the fragment pager adapter, we im getItem, we have to return a fragment
         * for every position. So we simply use a switch statement and in each case,
         * we return a different fragment
         */
        switch (position){
            case 0 : return new fragment1() ;
            case 1 : return new fragment2() ;
            case 2 : return new fragment3() ;
            case 3 : return new fragment4() ;
            case 4 : return new fragment5() ;
            case 5 : return new fragment6() ;
            case 6 : return new fragment1() ;
            case 7 : return new fragment2() ;
            case 8 : return new fragment3() ;
            case 9 : return new fragment4() ;
            case 10: return new fragment5() ;
            case 11 : return new fragment6() ;
            case 12 : return new fragment1() ;
            case 13 : return new fragment1() ;


            default: return new fragment1() ;
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position] ;
    }


}
