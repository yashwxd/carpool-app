package com.dd.carpooling.ui.bookedrides;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dd.carpooling.ApdapterClasses.BookedRide_adapter;
import com.dd.carpooling.ModelClasses.BookedRidesmodel;
import com.dd.carpooling.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class BookedridesFragment extends Fragment {

    ArrayList<BookedRidesmodel> listData;
    private RecyclerView rv;
    private BookedRide_adapter adapter;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference myRef, refg;
    String userid;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_bookedrides, container, false);

        rv=(RecyclerView)root.findViewById(R.id.recycler_view1_booked);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        listData=new ArrayList<BookedRidesmodel>();
        auth= FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        userid=user.getUid();

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference().child("BookedRides");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                    BookedRidesmodel ld=npsnapshot.getValue(BookedRidesmodel.class);
                    String user=ld.getUserid();
                    if(user.equals(userid))
                    {
                        listData.add(ld);
                    }

                }
                adapter=new BookedRide_adapter(getActivity(),listData);
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