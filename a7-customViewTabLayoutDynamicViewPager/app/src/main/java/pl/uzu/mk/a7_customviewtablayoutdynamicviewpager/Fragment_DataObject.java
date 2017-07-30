package pl.uzu.mk.a7_customviewtablayoutdynamicviewpager;

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
