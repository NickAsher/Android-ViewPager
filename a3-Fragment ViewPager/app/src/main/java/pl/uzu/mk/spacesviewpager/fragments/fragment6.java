package pl.uzu.mk.spacesviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.uzu.mk.spacesviewpager.MyListeners;
import pl.uzu.mk.spacesviewpager.R;


public class fragment6 extends Fragment {
    MyListeners.MyFragmentClickListnere listener ;


    public fragment6(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_6,container,false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener = (MyListeners.MyFragmentClickListnere) getActivity();
                listener.OnMyClick(5);
            }
        });
        return  v ;
    }
}
