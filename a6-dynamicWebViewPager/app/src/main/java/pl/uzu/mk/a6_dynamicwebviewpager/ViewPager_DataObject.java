package pl.uzu.mk.a6_dynamicwebviewpager;

import android.graphics.drawable.Drawable;

/**
 * Created by Killer on 7/14/2017.
 */
public class ViewPager_DataObject {
    String mHeading ;
    Drawable mIconDrawable ;
    Fragment_DataObject mFragment_dataObject ;




    public ViewPager_DataObject(String heading, Drawable iconDrawable, Fragment_DataObject fragment_dataObject) {
        this.mHeading = heading;
        this.mIconDrawable = iconDrawable ;

        this.mFragment_dataObject = fragment_dataObject;
    }


    public String getHeading() {
        return mHeading;
    }

    public Drawable getIconDrawable() {
        return mIconDrawable;
    }

    public Fragment_DataObject getFragment_dataObject() {
        return mFragment_dataObject;
    }
}
