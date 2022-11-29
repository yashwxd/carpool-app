package com.dd.carpooling.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dd.carpooling.AddRideRequestsact;
import com.dd.carpooling.ApdapterClasses.RideRequests_adapter;
import com.dd.carpooling.ModelClasses.AddRideRequests;
import com.dd.carpooling.ModelClasses.Offerridedetails;
import com.dd.carpooling.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {


    ArrayList<AddRideRequests> listData;
    private RecyclerView rv;
    private RideRequests_adapter adapter;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference myRef, refg;
    String userid;
    ImageView i1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        i1=root.findViewById(R.id.imageview_request);

        rv=(RecyclerView)root.findViewById(R.id.recycler_view1_request);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        listData=new ArrayList<AddRideRequests>();
        auth= FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        userid=user.getUid();

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getActivity(), AddRideRequestsact.class);
                startActivity(i2);
            }
        });


        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference().child("RideRequests");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                    AddRideRequests ld=npsnapshot.getValue(AddRideRequests.class);
                    listData.add(ld);

                }
                adapter=new RideRequests_adapter(getActivity(),listData);
                rv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getActivity(),"opps.....",Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

}