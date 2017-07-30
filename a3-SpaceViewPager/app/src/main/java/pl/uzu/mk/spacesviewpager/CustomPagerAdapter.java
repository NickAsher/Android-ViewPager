package pl.uzu.mk.spacesviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import pl.uzu.mk.spacesviewpager.fragments.fragment1;
import pl.uzu.mk.spacesviewpager.fragments.fragment2;
import pl.uzu.mk.spacesviewpager.fragments.fragment3;
import pl.uzu.mk.spacesviewpager.fragments.fragment4;
import pl.uzu.mk.spacesviewpager.fragments.fragment5;
import pl.uzu.mk.spacesviewpager.fragments.fragment6;


public class CustomPagerAdapter extends FragmentPagerAdapter {



    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

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
            case 4 : return new fragment5() ;
            case 5 : return new fragment6() ;

            default: return new fragment1() ;
        }
    }


}
