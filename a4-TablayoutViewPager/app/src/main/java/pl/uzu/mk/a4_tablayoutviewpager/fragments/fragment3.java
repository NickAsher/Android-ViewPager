package pl.uzu.mk.a4_tablayoutviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.uzu.mk.a4_tablayoutviewpager.R;


public class fragment3 extends Fragment {


    public fragment3(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_3,container,false);

        return  v ;
    }
}
