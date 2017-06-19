package com.mydashboardgroup.optumtracker.optumtracker.Class;

import android.app.IntentService;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by ratienz2 on 6/19/2017.
 */

public class SimpleIntentService extends IntentService {

    //private SomeDataProvider myDataProvider;
    private static final String DEBUG_TAG = "SimpleIntentService";

    public SimpleIntentService(){
        super(DEBUG_TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent){
        //retrieve the url from the intent
        String url = intent.getStringExtra("url");

        //use our custom data
        /*
            myDataProvider = new myDataProvider();

            ArrayList<SomeData> dataList = myDataProvider.getData(url);
            Log.d(DEBUG_TAG,"Data received");
        */




    }
}
