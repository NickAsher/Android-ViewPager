package pl.uzu.mk.spacesviewpager;

import android.content.Context;
import android.widget.Toast;


public final class Message {
    public static final void display(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
