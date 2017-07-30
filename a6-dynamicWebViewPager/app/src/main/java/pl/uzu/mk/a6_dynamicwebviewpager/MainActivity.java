package pl.uzu.mk.a6_dynamicwebviewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
//                ProcessResponse("error");
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


                    final String CategoryName = object.getString("category_name") ;
                    final String ImageName = object.getString("category_image_name") ;
                    final String TextData = object.getString("category_texty") ;
                    final String BackGroundColor = object.getString("category_colory") ;


                    Picasso.with(getBaseContext()).load(Constants.IMAGE_PATH+ImageName).into(new Target() {

                        @Override
                        public void onPrepareLoad(Drawable arg0) {


                        }

                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
                            // TODO Create your drawable from bitmap and append where you like.
                            listOfViewPagerObject.add(new ViewPager_DataObject(CategoryName, new BitmapDrawable(getResources(),bitmap), new Fragment_DataObject(TextData, BackGroundColor))) ;
                            start = start + 1 ;
                            
                            if(start == totalTabs){
                                setupViewPager() ;
                            }


                        }

                        @Override
                        public void onBitmapFailed(Drawable arg0) {


                        }
                    });

                }
//                setupViewPager() ;

                Toast.makeText(context, "Loading complete" + jsonArray.length(), Toast.LENGTH_SHORT).show();






            }
            catch (Exception e){
                Log.e(LOG_TAG, e.getMessage() ) ;
                Toast.makeText(context, "Loaded but error in parsing", Toast.LENGTH_SHORT).show();

            }



    }



    private void setupViewPager(){
        Log.e(LOG_TAG, "Viewpager is initialised") ;
        adapter = new CustomPagerAdapter(getSupportFragmentManager(), context, listOfViewPagerObject) ;
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        setupViewPagerHeadingIcons() ;
    }

    public void setupViewPagerHeadingIcons(){
        /*
         * The following for loop firstly assign an icon to all the tabs
         * Then it sets the default color for those tabs
         */
        int NoOfItems = listOfViewPagerObject.size() ;
        ArrayList<Drawable> drawables = new ArrayList<>() ;
//        drawables.add(ResourcesCompat.getDrawable(getResources(), R.drawable.drink_white, null));
//        drawables.add(ResourcesCompat.getDrawable(getResources(), R.drawable.pizza_white, null));
//        drawables.add(ResourcesCompat.getDrawable(getResources(), R.drawable.pasta_white, null));
//        drawables.add(ResourcesCompat.getDrawable(getResources(), R.drawable.donut_white, null));
//        drawables.add(ResourcesCompat.getDrawable(getResources(), R.drawable.cupcake_white, null));

        for (int i=0;i<NoOfItems;i++) {

            tabLayout.getTabAt(i).setIcon(listOfViewPagerObject.get(i).getIconDrawable()) ;
//            tabLayout.getTabAt(i).setIcon(drawables.get(i)) ;
            tabLayout.getTabAt(i).getIcon().setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);

        }







        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewpager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        int tabIconColor = ContextCompat.getColor(context, R.color.white);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        int tabIconColor = ContextCompat.getColor(context, R.color.grey);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
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
