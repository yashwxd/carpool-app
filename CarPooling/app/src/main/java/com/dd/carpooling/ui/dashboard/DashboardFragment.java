package com.dd.carpooling.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dd.carpooling.ApdapterClasses.AllRides;
import com.dd.carpooling.ModelClasses.Offerridedetails;
import com.dd.carpooling.R;
import com.dd.carpooling.SearchActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {


    ArrayList<Offerridedetails> listData;
    private RecyclerView rv;
    private AllRides adapter;
    ImageView i1;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        rv=(RecyclerView)root.findViewById(R.id.recyclerview_dash);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        listData=new ArrayList<Offerridedetails>();
        i1=root.findViewById(R.id.imageView1_home);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i11=new Intent(getActivity(), SearchActivity.class);
                startActivity(i11);
            }
        });

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference().child("NewRideDetails");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                    Offerridedetails ld=npsnapshot.getValue(Offerridedetails.class);
                    listData.add(ld);

                }
                adapter=new AllRides(getActivity(),listData);
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