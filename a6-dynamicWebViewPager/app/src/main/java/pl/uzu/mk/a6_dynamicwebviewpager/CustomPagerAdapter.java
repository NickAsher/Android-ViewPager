package pl.uzu.mk.a6_dynamicwebviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class CustomPagerAdapter extends FragmentPagerAdapter {
    Context context ;
    ArrayList<ViewPager_DataObject> mListOfViewPagerObjects ;

    public CustomPagerAdapter(FragmentManager fm, Context context, ArrayList<ViewPager_DataObject> listOfViewPagerObjects) {
        super(fm);
        this.context = context ;
        this.mListOfViewPagerObjects = listOfViewPagerObjects ;
    }



    @Override
    public int getCount() {
        /**
         * We simply return the number of items that we are going to add in the View Pager
         */
        return this.mListOfViewPagerObjects.size() ;
    }



    @Override
    public Fragment getItem(int position) {
        /**
         * In the fragment pager adapter, we in getItem, we have to return a fragment
         * for every position. Earlier we used a switch statement and return a different fragment in each case,
         *
         * Now we just make a generic Fragment and then pass the data in the generic fragment using bundle
         * Then always return that fragment object
         */
        GenericFragment f = new GenericFragment() ;
        Bundle args=new Bundle();
        args.putString("color", this.mListOfViewPagerObjects.get(position).getFragment_dataObject().getColor());
        args.putString("text", this.mListOfViewPagerObjects.get(position).getFragment_dataObject().getText());
        f.setArguments(args);
        return f;


    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return this.mListOfViewPagerObjects.get(position).getHeading() ;
    }


}
