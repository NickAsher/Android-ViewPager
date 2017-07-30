package pl.uzu.mk.a5_dynamicviewpager;

/**
 * Created by Killer on 7/14/2017.
 */
public class ViewPager_DataObject {
    String mHeading ;
    int mIconId ;
    Fragment_DataObject mFragment_dataObject ;




    public ViewPager_DataObject(String heading, int iconId, Fragment_DataObject fragment_dataObject) {
        this.mHeading = heading;
        this.mIconId = iconId ;

        this.mFragment_dataObject = fragment_dataObject;
    }


    public String getHeading() {
        return mHeading;
    }

    public int getIconId() {
        return mIconId;
    }

    public Fragment_DataObject getFragment_dataObject() {
        return mFragment_dataObject;
    }
}
