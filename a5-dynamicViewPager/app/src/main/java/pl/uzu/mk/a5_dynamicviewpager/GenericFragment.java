package pl.uzu.mk.a5_dynamicviewpager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class GenericFragment extends Fragment {
    Context context ;
    TextView textView;
    LinearLayout linearLayout ;

    String texty ;
    String colory ;


    public GenericFragment(){

    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_1,container,false);

        return v ;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        context = getActivity() ;
        Bundle bundle = this.getArguments() ;
        if(bundle != null){
            texty = bundle.getString("text") ;
            colory = bundle.getString("color") ;
        }


        getReferences(view) ;
        setupRecyclerView() ;
    }


    public void getReferences(View v){
        textView = (TextView) v.findViewById(R.id.genericFragment_TextView);
        linearLayout = (LinearLayout) v.findViewById(R.id.genericFragment_LinearLayout) ;

    }

    private void setupRecyclerView() {
        textView.setText(texty);
        linearLayout.setBackgroundColor(Color.parseColor(colory));
    }


}
