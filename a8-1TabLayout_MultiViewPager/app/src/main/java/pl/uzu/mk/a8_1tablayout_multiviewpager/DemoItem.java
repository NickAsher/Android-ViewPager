package pl.uzu.mk.a8_1tablayout_multiviewpager;


public class DemoItem {

    String Name;
    double price ;
    boolean selected ;

    public DemoItem(String Name, double price, boolean selected){
        this.Name = Name ;
        this.price = price ;
        this.selected = selected;
    }

    public String getName(){
        return Name ;
    }
    public double getPrice(){
        return price ;
    }
    public boolean getSelection(){
        return  selected ;
    }
    public void setSelected(boolean selection){
        this.selected = selection ;
    }
}
