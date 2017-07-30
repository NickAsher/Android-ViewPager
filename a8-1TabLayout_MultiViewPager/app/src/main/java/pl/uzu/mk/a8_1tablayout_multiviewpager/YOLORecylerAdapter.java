package pl.uzu.mk.a8_1tablayout_multiviewpager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;


public class YOLORecylerAdapter extends RecyclerView.Adapter<YOLORecylerAdapter.YOLOViewHolder> {
    ArrayList<DemoItem> Cofeelist ;
    Context mContext ;


    // Constructor
    public YOLORecylerAdapter(ArrayList<DemoItem> Cofeelist, Context context ) {
        this.Cofeelist = Cofeelist ;
        this.mContext = context ;

    }

    //Inflate the main parent (single row) layout here nd set the viewholder to it
    @Override
    public YOLOViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singlerow_demoitem,viewGroup,false) ;
        // YOLOViewHolder viewHolder = new YOLOViewHolder(convertView) ;

        return new YOLOViewHolder(convertView) ;
    }

    //replace the contents of your views here like setText and SetImageResource
    @Override
    public void onBindViewHolder(final YOLOViewHolder yoloViewHolder, final int position) {
        yoloViewHolder.mTextView.setText(this.Cofeelist.get(position).getName() + "   ");
        yoloViewHolder.mTextView2.setText("$" + this.Cofeelist.get(position).getPrice());







    }


    //return the no.of items here
    @Override
    public int getItemCount() {
        return Cofeelist.size() ;
    }


    // ----------------Inner view holder class ---------------------------------
    // We don't have to implement any method in pur vieholder except the constructor
    // In constructor after calling super methos, we have to get a reference to ech view item.
    public static class YOLOViewHolder extends RecyclerView.ViewHolder {

        // here we re going to just declare our textviews and imageviews and nothing more
        TextView mTextView;
        TextView mTextView2;
        CheckBox mCheckBox ;



        public YOLOViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.detail_scrn_topping_single_row_textview_name);
            mTextView2 = (TextView) itemView.findViewById(R.id.detail_scrn_topping_single_row_textview_price);
            mCheckBox = (CheckBox) itemView.findViewById((R.id.detail_scrn_topping_single_row_checkbox)) ;



        }
    }




}




