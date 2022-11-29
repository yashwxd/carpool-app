package com.dd.carpooling.ApdapterClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dd.carpooling.ModelClasses.AddRideRequests;
import com.dd.carpooling.R;

import java.util.ArrayList;

public class RideRequests_adapter extends RecyclerView.Adapter<RideRequests_adapter.ViewHolder> implements Filterable {
    public Context context;
    String a,b;
    ArrayList<AddRideRequests> listData;
    public RideRequests_adapter(Context context, ArrayList<AddRideRequests> listData) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.riderequest_singlerow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AddRideRequests addRideRequests=listData.get(position);

        holder.name.setText(addRideRequests.getPersonname());
        holder.mobilno.setText(addRideRequests.getMobileno());
        holder.ridename.setText(addRideRequests.getRidename());
        holder.pickuppoint.setText(addRideRequests.getPickup());
        holder.dropoffpoint.setText(addRideRequests.getDropmeoff());
        holder.noofpersons.setText(addRideRequests.getNoofpersons());
        holder.checkpoint.setText(addRideRequests.getCheckpoint());
        holder.date.setText(addRideRequests.getDate());
        holder.time.setText(addRideRequests.getTime());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,mobilno,ridename,pickuppoint,dropoffpoint,date,time,chargeperkm,checkpoint,noofpersons,vehiclename;
        CardView cv;
        public ViewHolder(View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name_request);
            mobilno=itemView.findViewById(R.id.mobileno_request);
            ridename=itemView.findViewById(R.id.ridename_requests);
            pickuppoint=itemView.findViewById(R.id.pickuppoint_request);
            dropoffpoint=itemView.findViewById(R.id.dropoffpoint_request);
            checkpoint=itemView.findViewById(R.id.checkpoint_request);
            noofpersons=itemView.findViewById(R.id.noofpersons_request);
            date=itemView.findViewById(R.id.date_requests);
            time=itemView.findViewById(R.id.time_requests);


            cv=itemView.findViewById(R.id.cardview_allrides);



        }

    }
}
