package pl.uzu.mk.simpleviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class CustomPagerAdapter extends PagerAdapter {
    ArrayList<Integer> arr ;
    Context context ;

    public CustomPagerAdapter(Context context) {
        arr = new ArrayList<Integer>() ;
        arr.add(R.layout.layout1);
        arr.add(R.layout.layout2);
        arr.add(R.layout.layout3);
        arr.add(R.layout.layout4);

        this.context = context ;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(arr.get(position),collection,false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
}
