package com.dd.carpooling.ApdapterClasses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dd.carpooling.BookRideDetails;
import com.dd.carpooling.ModelClasses.Offerridedetails;
import com.dd.carpooling.R;

import java.util.ArrayList;


public class AllRides extends RecyclerView.Adapter<AllRides.ViewHolder> implements Filterable {
    public Context context;
    String a,b;
    ArrayList<Offerridedetails> listData;
    public AllRides(Context context, ArrayList<Offerridedetails> listData) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bookride_getride_singlerow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Offerridedetails offerridedetails=listData.get(position);

        holder.ridename.setText(offerridedetails.getRidename());
        holder.pickuppoint.setText(offerridedetails.getPickuppoint());
        holder.dropoffpoint.setText(offerridedetails.getDropoffpoint());
        holder.date.setText(offerridedetails.getDate());
        holder.time.setText(offerridedetails.getTime());
        holder.chargeperkm.setText(offerridedetails.getChargeperkm());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String carmodel=offerridedetails.getCarmodel();
                String vehicleno=offerridedetails.getVehiclenumber();
                String checkpoints=offerridedetails.getCheckpoint();
                String pickup=offerridedetails.getPickuppoint();
                String dropoff=offerridedetails.getDropoffpoint();
                String date=offerridedetails.getDate();
                String time=offerridedetails.getTime();
                String charge=offerridedetails.getChargeperkm();
                String ride=offerridedetails.getRidename();

                Intent i = new Intent(context.getApplicationContext(), BookRideDetails.class);
                i.putExtra("carmodel",carmodel);
                i.putExtra("vehicleno",vehicleno);
                i.putExtra("checkpoints",checkpoints);
                i.putExtra("pickup",pickup);
                i.putExtra("dropoff",dropoff);
                i.putExtra("date",date);
                i.putExtra("time",time);
                i.putExtra("charge",charge);
                i.putExtra("ridename",ride);
                context.startActivity(i);
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
        private TextView ridename,pickuppoint,dropoffpoint,date,time,chargeperkm;
        CardView cv;
        public ViewHolder(View itemView) {
            super(itemView);

            ridename=itemView.findViewById(R.id.ridename_allrides);
            pickuppoint=itemView.findViewById(R.id.pickupoint_allrides);
            dropoffpoint=itemView.findViewById(R.id.dropoffpoint_allrides);
            date=itemView.findViewById(R.id.date_allrides);
            time=itemView.findViewById(R.id.time_allrides);
            chargeperkm=itemView.findViewById(R.id.chargeperkm_allrides);

            cv=itemView.findViewById(R.id.cardview_allrides);



        }

    }
}
