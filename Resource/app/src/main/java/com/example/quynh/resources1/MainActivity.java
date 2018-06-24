package com.example.quynh.resources1;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quynh.resources1.calendar.DatePickerFragment;
import com.example.quynh.resources1.calendar.MainCalendar;
import com.example.quynh.resources1.calendar.ReadSharePreCalendar;
import com.example.quynh.resources1.data.main.Doc;
import com.example.quynh.resources1.data.main.Main;
import com.example.quynh.resources1.data.main.MainService;
import com.example.quynh.resources1.data.main.Multimedium;
import com.example.quynh.resources1.recyclerview.main.EndlessRecyclerViewScrollListener;
import com.example.quynh.resources1.recyclerview.main.MainView;
import com.example.quynh.resources1.recyclerview.main.MainViewAdapter;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainView> mainViewslist = new ArrayList<>();
    ReadSharePreCalendar rspc = new ReadSharePreCalendar();
    Button btnSearch;
    EditText editSearch;
    Integer page0 = 0;
    LinearLayoutManager layoutManager;
    MainViewAdapter mainViewAdapter;
    Boolean network = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //anh xa
        btnSearch = (Button)findViewById(R.id.btn_search) ;
        editSearch = (EditText)findViewById(R.id.edit_search) ;
        fun_retrofit(0);
        //fun_initView();
        //fun_readPreShare();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun_search();
            }
        });
    }

    public void fun_search(){
        page0 = 0;
        fun_retrofit(page0);
        editSearch.setText("");
    }
    //menu trong android 4
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.miFilter:
                return true;
            case R.id.miAbout:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //Click item menu on toolbar
    public void onFilterAction(MenuItem mi) {
        // handle click here
        Log.d("Click","miCompose");
        Intent filterIntent = new Intent(this,MainCalendar.class);
        startActivity(filterIntent);
    }
    public void onAboutAction(MenuItem mi) {
        // handle click here
        Log.d("Click","miProfile");
    }
    //Doc du lieu ben MainCalendar tra ve
    public void fun_readPreShare(){
        SharedPreferences pre = getSharedPreferences ("data_maincalendar",Context.MODE_PRIVATE);
        rspc.setQ( pre.getString("calendar","20180101") );
        rspc.setSort( pre.getString("spinner","newest") );
        rspc.setFq("Fashion");
        Boolean check1 = pre.getBoolean("check1",false);
        Boolean check2 = pre.getBoolean("check2",false);
        Boolean check3 = pre.getBoolean("check3",false);
        String fq_s = "news_desk:(";
        String fq_e =  ")";
        String fq_full = "";
        fq_full += editSearch.getText() + " ";
        fq_full += fq_s;
        if(check1 == true){ fq_full += "\"Arts\" "; }
        if(check2 == true){ fq_full += "\"Fashion\" \"Style\" "; }
        if(check3 == true){ fq_full += "\"Sports\" ";}

        ;
        fq_full += fq_e;
        rspc.setFq( fq_full );

        if(check1 == false & check2 == false & check3 == false){
            rspc.setFq(null);
        }

        Log.d("Query Q",rspc.getQ());
        Log.d("Query Sort",rspc.getSort());
        //Log.d("Query FQ",rspc.getFq());
    }
    //retrofit + Query
    public void fun_retrofit(int page){
        fun_readPreShare();
        String BASE_URL = "https://api.nytimes.com/svc/search/v2/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MainService mainService = retrofit.create(MainService.class);
        //Call<Main> call = mainService.gettestKey();
        Call<Main> call = mainService.gettestQuery(rspc.getQ(),page0,rspc.getSort(),rspc.getFq(),"b8dcacb453d04ace85cc9a330c06f45d");

        Log.d("new york time", call.request().toString());
        call.enqueue(new Callback<Main>() {
            @Override
            public void onResponse(Call<Main> call, Response<Main> response) {
                Main main = response.body();
                com.example.quynh.resources1.data.main.Response response1 = main.getResponse();
                java.util.List<Doc> docList = response1.getDocs();
                //Log.d("doc",docList.toString());

                for(Doc doc1 : docList){
                   //web_url,snippet,url_hinh
                    if(doc1.getMultimedia().size() == 0){
                        Log.d("Multimedium ","error null");
                    }else {
                        Multimedium multimedium = doc1.getMultimedia().get(0);
                        mainViewslist.add(new MainView(doc1.getWebUrl(),doc1.getSnippet(),multimedium.getUrl()));
                        Log.d("url hinh",multimedium.getUrl());
                    }
                }

                fun_initView();
            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) { }
        });
    }

    //public EndlessRecyclerViewScrollListener scrollListener;
    Boolean isScrolling = false;
    int curentItems,totalItems,scrollItems;
    public void fun_initView(){
        //recyclerView
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);// the nay toi uu hoa du lieu
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        //duong ngan cach
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        mainViewAdapter = new MainViewAdapter(mainViewslist,getApplicationContext());
        /*//animation recycler
        recyclerView.setItemAnimator(new ScaleInAnimator());
        recyclerView.setAdapter(new ScaleInAnimationAdapter(mainViewAdapter));*/

        recyclerView.setAdapter(mainViewAdapter);
        /*//chia cot
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);*/



        //ScrollView of RecyclView
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                curentItems = layoutManager.getChildCount();
                totalItems = layoutManager.getItemCount();
                scrollItems = layoutManager.findFirstVisibleItemPosition();

                if(isScrolling && (curentItems + scrollItems == totalItems)){
                    isScrolling = false;
                    fetchData();
                }

            }
        });

        Log.d("fun_initView","OK");
    }
    public void fetchData() {
        Log.d("Scroll","load more ok");
        page0++;
        mainViewAdapter.notifyDataSetChanged();
        fun_retrofit(page0);
    }
    //Xet mang
    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
