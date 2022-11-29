package com.dd.carpooling.ApdapterClasses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dd.carpooling.BookRideDetails;
import com.dd.carpooling.ModelClasses.BookedRidesmodel;
import com.dd.carpooling.ModelClasses.Offerridedetails;
import com.dd.carpooling.R;

import java.util.ArrayList;

public class BookedRide_adapter extends RecyclerView.Adapter<BookedRide_adapter.ViewHolder> implements Filterable {
    public Context context;
    String a,b;
    ArrayList<BookedRidesmodel> listData;
    public BookedRide_adapter(Context context, ArrayList<BookedRidesmodel> listData) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bookedride_singlerow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BookedRidesmodel bookedRidesmodel=listData.get(position);

        holder.ridename.setText(bookedRidesmodel.getRidename());
        holder.pickuppoint.setText(bookedRidesmodel.getPickuppoint());
        holder.dropoffpoint.setText(bookedRidesmodel.getDropoffpoint());
        holder.date.setText(bookedRidesmodel.getDate());
        holder.time.setText(bookedRidesmodel.getTime());
        holder.chargeperkm.setText(bookedRidesmodel.getChargeperkm());

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

            ridename=itemView.findViewById(R.id.ridename_bookedride);
            pickuppoint=itemView.findViewById(R.id.pickupoint_bookedride);
            dropoffpoint=itemView.findViewById(R.id.dropoffpoint_bookedride);
            date=itemView.findViewById(R.id.date_bookedride);
            time=itemView.findViewById(R.id.time_bookedride);
            chargeperkm=itemView.findViewById(R.id.chargeperkm_bookedride);

            cv=itemView.findViewById(R.id.cardview_allrides);



        }

    }
}
