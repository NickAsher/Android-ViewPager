package pl.uzu.mk.a7_customviewtablayoutdynamicviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewpager ;
    Context context ;
    CustomPagerAdapter adapter ;
    TabLayout tabLayout ;
    ArrayList<ViewPager_DataObject> listOfViewPagerObject ;
    ImageView testerImageView ;

    String LOG_TAG = "A6 DynamicWebViewPager" ;
    String url = Constants.DATA_PATH ;
    ArrayList<Drawable> iconDrawableArray ;
    int start = 0; int totalTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this ;

        listOfViewPagerObject = new ArrayList<>() ;

        getReferences() ;
        fetchData();




    }

    private void getReferences(){
        viewpager = (ViewPager) findViewById(R.id.ViewPager) ;
        tabLayout = (TabLayout) findViewById(R.id.Tablayout);
        testerImageView = (ImageView)findViewById(R.id.imagetester) ;
    }


    public void fetchData(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.e(LOG_TAG, response) ;
                        ProcessResponse(response);

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(LOG_TAG, error.getMessage() ) ;

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(context) ;
        requestQueue.add(stringRequest) ;
    }


    public void ProcessResponse(String response){
            try {
                Log.d(LOG_TAG, response) ;
                JSONArray jsonArray = new JSONArray(response) ;




                listOfViewPagerObject.clear();
                totalTabs = jsonArray.length() ;
                for(int i = 0; i < totalTabs; i++){
                    JSONObject object = jsonArray.getJSONObject(i) ;


                     String CategoryName = object.getString("category_name") ;
                     String ImageName = object.getString("category_image_name") ;
                     String TextData = object.getString("category_texty") ;
                     String BackGroundColor = object.getString("category_colory") ;

                    listOfViewPagerObject.add(new ViewPager_DataObject(CategoryName, ImageName, new Fragment_DataObject(TextData, BackGroundColor))) ;




                }
                setupViewPager() ;

                Toast.makeText(context, "Loading complete" + jsonArray.length(), Toast.LENGTH_SHORT).show();






            }
            catch (Exception e){
                Log.e(LOG_TAG, e.getMessage() ) ;
                Toast.makeText(context, "Loaded but error in parsing", Toast.LENGTH_SHORT).show();

            }



    }



    private void setupViewPager(){
        Log.d(LOG_TAG, "Viewpager is initialised") ;
        adapter = new CustomPagerAdapter(getSupportFragmentManager(), context, listOfViewPagerObject) ;
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        setupViewPagerHeadingIcons() ;

    }

    public void setupViewPagerHeadingIcons(){


        for (int i=0;i<tabLayout.getTabCount();i++) {

            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = vi.inflate(R.layout.layout_viewpager_tab, null);
            Log.d(LOG_TAG, "View is initialised") ;

            ImageView tabImageView = (ImageView)v.findViewById(R.id.tab_ImageView) ;
            Glide.with(context).load(Constants.IMAGE_PATH + listOfViewPagerObject.get(i).getImageName()).into(tabImageView) ;

            TextView textView = (TextView)v.findViewById(R.id.tab_TextView) ;
            if (Build.VERSION.SDK_INT >= 24) {
                // for 24 api and more
                textView.setText(Html.fromHtml(listOfViewPagerObject.get(i).getHeading(), Html.FROM_HTML_MODE_LEGACY) );
            } else {
                // or for older api
                textView.setText(Html.fromHtml(listOfViewPagerObject.get(i).getHeading()));
            }

            tabLayout.getTabAt(i).setCustomView(v) ;


        }









        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewpager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);

                        int tabIconColor = ContextCompat.getColor(context, R.color.white);
                        ImageView tabImageView = (ImageView)tab.getCustomView().findViewById(R.id.tab_ImageView) ;
                        tabImageView.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);

                        int tabIconColor = ContextCompat.getColor(context, R.color.black);
                        ImageView tabImageView = (ImageView)tab.getCustomView().findViewById(R.id.tab_ImageView) ;
                        tabImageView.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
        /*
         * The following two lines are needed, because the above onTabSelectedLIstener works a tab is changed, so by default it does not work
         * Although it may seem that tab at position 0 is selected, but it is not.
         * So to run the above onTabSelectedListener code on first open, we firstly select item at position 1 and then go back item at position 0
         */
        tabLayout.getTabAt(1).select();
        tabLayout.getTabAt(0).select();
    }
}
