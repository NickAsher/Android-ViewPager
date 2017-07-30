package pl.uzu.mk.a8_1tablayout_multiviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment1;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment1a;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment2;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment2a;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment3;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment3a;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment4;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment4a;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment5;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment5a;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment6;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment6a;
import pl.uzu.mk.a8_1tablayout_multiviewpager.fragments.fragment7;


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
        return 6;
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
            case 4 : return new fragment2() ;
            case 5 : return new fragment6() ;




            default: return new fragment1() ;
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position] ;
    }


}
