package pl.uzu.mk.a8_1tablayout_multiviewpager.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pl.uzu.mk.a8_1tablayout_multiviewpager.DemoItem;
import pl.uzu.mk.a8_1tablayout_multiviewpager.R;
import pl.uzu.mk.a8_1tablayout_multiviewpager.YOLORecylerAdapter;


public class fragment5 extends Fragment {
    Context context ;
    RecyclerView mRecyclerView ;
    YOLORecylerAdapter mAdapter ;
    ArrayList<DemoItem> listOfItems ;


    public fragment5(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_1,container,false);

        return  v ;



    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        context = getActivity() ;

        listOfItems = new ArrayList<>() ;
        listOfItems.add(new DemoItem("Item 1", 52.34, true)) ;
        listOfItems.add(new DemoItem("Item 2", 52.34, true)) ;
        listOfItems.add(new DemoItem("Item 3", 52.34, true)) ;
        listOfItems.add(new DemoItem("Item 4", 52.34, true)) ;
        listOfItems.add(new DemoItem("Item 5", 52.34, true)) ;
        listOfItems.add(new DemoItem("Item 6", 52.34, true)) ;
        listOfItems.add(new DemoItem("Item 7", 52.34, true)) ;




        getReferences(view) ;
        initRecyclerView() ;




    }


    private void getReferences(View v){
        mRecyclerView = (RecyclerView) v.findViewById(R.id.detailScr_RecyclerView);

    }

    public void initRecyclerView(){
        mRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager yolomanager = new LinearLayoutManager(context);
        yolomanager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(yolomanager);

        mAdapter = new YOLORecylerAdapter(listOfItems, context);
        mRecyclerView.setAdapter(mAdapter);
    }





}
