package pl.uzu.mk.a4_tablayoutviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.uzu.mk.a4_tablayoutviewpager.R;


public class fragment4 extends Fragment {


    public fragment4(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_4,container,false);

        return  v ;
    }
}
