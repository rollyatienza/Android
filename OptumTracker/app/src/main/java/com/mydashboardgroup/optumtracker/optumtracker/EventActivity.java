package com.mydashboardgroup.optumtracker.optumtracker;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mydashboardgroup.optumtracker.optumtracker.Adapter.EventAdapter;
import com.mydashboardgroup.optumtracker.optumtracker.Class.Events;
import com.mydashboardgroup.optumtracker.optumtracker.Class.SimpleDividerItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;

public class EventActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Events> eventList = new ArrayList<Events>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

        GetEvents();
        /*for(int i=0;i<2;i++){
            Events e = new Events();
            e.setmMasterID(i);
            e.setmName("Event Name : " + Integer.toString(i) );
            e.setmDescription("Description");
            e.setmDate("07/07/2017");

            eventList.add(e);
        }

        mAdapter = new EventAdapter(eventList);
        mRecyclerView.setAdapter(mAdapter);
        */

    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView){
        recyclerView.setAdapter(new EventAdapter(eventList));
    }

    private void GetEvents(){
        String url = getResources().getString(R.string.apiEvents);

        final ProgressDialog progressDialog = new ProgressDialog(EventActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Getting event list...");
        progressDialog.show();


        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // the response is already constructed as a JSONObject!
                        try {
                            JSONArray jsonArray = response.getJSONArray("Events");

                            for(int i=0;i<jsonArray.length();i++){
                                Events event = new Events();
                                JSONObject jsonEventObj = jsonArray.getJSONObject(i);
                                event.setmMasterID(jsonEventObj.getInt("EventMasterID"));
                                event.setmName(jsonEventObj.getString("EventName"));
                                event.setmDescription(jsonEventObj.getString("Description"));
                                event.setmDate(jsonEventObj.getString("EventDate"));
                                event.setmCoordinator(jsonEventObj.getString("Coordinator"));

                                eventList.add(event);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        mAdapter = new EventAdapter(eventList);
                        mRecyclerView.setAdapter(mAdapter);
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //_textHello.setText("Something went wrong!");
                        error.printStackTrace();
                    }

                });

        Volley.newRequestQueue(this).add(jsonRequest);
    }
}
