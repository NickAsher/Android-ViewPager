package pl.uzu.mk.a5_dynamicviewpager;

import android.support.v4.app.Fragment;

/**
 * Created by Killer on 7/14/2017.
 */
public class Fragment_DataObject {


    String mText;
    String mColor ;

    public Fragment_DataObject(String text, String color){
        this.mColor=color;
        this.mText=text ;
    }


    public String getText() {
        return mText;
    }

    public String getColor() {
        return mColor;
    }


}
