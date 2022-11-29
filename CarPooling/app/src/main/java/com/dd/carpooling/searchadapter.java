package com.dd.carpooling;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.dd.carpooling.ModelClasses.Offerridedetails;


import java.util.ArrayList;

public class searchadapter extends RecyclerView.Adapter<searchadapter.MyViewHolder> {
    String userid,pgname;
    public Context context;
    ArrayList<Offerridedetails> list;


    public searchadapter(Context context, ArrayList<Offerridedetails> list){
        this.context = context;
        this.list=list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_search_adapter,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
//        model model1=list.get(i);
//        holder.pgname.setText(list.get(i).getPgname());
//        holder.pgaddress.setText(list.get(i).getAddress());
//        holder.rent.setText(list.get(i).getRent());
//        Glide.with(holder.ImageView.getContext()).load(model1.getPgimage()).into(holder.ImageView);

        Offerridedetails offerridedetails=list.get(i);

        holder.ridename.setText(list.get(i).getRidename());
        holder.pickuppoint.setText(list.get(i).getPickuppoint());
        holder.dropoffpoint.setText(list.get(i).getDropoffpoint());
        holder.date.setText(list.get(i).getDate());
        holder.time.setText(list.get(i).getTime());
        holder.chargeperkm.setText(list.get(i).getChargeperkm());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView ridename,pickuppoint,dropoffpoint,date,time,chargeperkm,checkpoint,noofpersons,vehiclename;
        CardView cv;
        private CardView cv1;

        public MyViewHolder(View itemView){
            super(itemView);

            ridename=itemView.findViewById(R.id.ridename_seach);
            pickuppoint=itemView.findViewById(R.id.pickupoint__seach);
            dropoffpoint=itemView.findViewById(R.id.dropoffpoint_seach);
            date=itemView.findViewById(R.id.date_seach);
            time=itemView.findViewById(R.id.time_seach);
            chargeperkm=itemView.findViewById(R.id.chargeperkm_seach);

            cv=itemView.findViewById(R.id.cardview_search);
        }
    }
}
