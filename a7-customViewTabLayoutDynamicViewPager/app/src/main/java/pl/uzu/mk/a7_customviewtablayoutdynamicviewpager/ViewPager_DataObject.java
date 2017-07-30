package pl.uzu.mk.a7_customviewtablayoutdynamicviewpager;

import android.graphics.drawable.Drawable;

/**
 * Created by Killer on 7/14/2017.
 */
public class ViewPager_DataObject {
    String mHeading ;
    String ImageName ;
    Fragment_DataObject mFragment_dataObject ;




    public ViewPager_DataObject(String heading, String imageName, Fragment_DataObject fragment_dataObject) {
        this.mHeading = heading;
        this.ImageName = imageName ;

        this.mFragment_dataObject = fragment_dataObject;
    }


    public String getHeading() {
        return mHeading;
    }

    public String getImageName() {
        return ImageName;
    }

    public Fragment_DataObject getFragment_dataObject() {
        return mFragment_dataObject;
    }
}
