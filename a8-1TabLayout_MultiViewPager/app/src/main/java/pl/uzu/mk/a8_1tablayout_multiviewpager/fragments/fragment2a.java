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


public class fragment2a extends Fragment {
    Context context ;



    public fragment2a(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_2,container,false);

        return  v ;



    }









}
