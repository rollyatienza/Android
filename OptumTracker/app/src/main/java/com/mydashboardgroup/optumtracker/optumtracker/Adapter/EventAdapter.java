package com.mydashboardgroup.optumtracker.optumtracker.Adapter;

import android.os.ParcelUuid;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mydashboardgroup.optumtracker.optumtracker.Class.Events;
import com.mydashboardgroup.optumtracker.optumtracker.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ratienz2 on 6/8/2017.
 */

public class EventAdapter
        extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private final  ArrayList<Events> mDataset;

    //Provide a suitable constructor (depends on the kind of dataset
    public EventAdapter(ArrayList<Events> myDataset){
        mDataset = myDataset;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView meventID;
        public final TextView meventName;
        public final TextView meventDescription;
        public final TextView meventDate;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            meventID = (TextView) view.findViewById(R.id.eventID);
            meventName= (TextView) view.findViewById(R.id.eventName);
            meventDescription = (TextView) view.findViewById(R.id.eventDescription);
            meventDate = (TextView)view.findViewById(R.id.eventDate);
        }

        /*@Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position){
            Events event = mDataset.get(position);
            holder.meventID.setText(Integer.toString(event.getmMasterID()));
            holder.meventName.setText(event.getmName());
            holder.meventDescription.setText(event.getmDescription());
            holder.meventDate.setText(event.getmDate());



        //Implement Click Listener here
    }

    @Override
    public int getItemCount(){return mDataset.size();}











}
