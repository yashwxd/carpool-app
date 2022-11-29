package com.dd.carpooling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.carpooling.ModelClasses.AddRideRequests;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class AddRideRequestsact extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    FloatingActionButton fab;
    private FirebaseAuth mAuth;
    FirebaseUser user;
    String userid;
    int id = 0;
    AddRideRequests addRideRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ride_requests);

        e1=findViewById(R.id.ridename_addriderequests);
        e2=findViewById(R.id.pickup_addriderequests);
        e3=findViewById(R.id.dropmePpoint_addriderequests);
        e4=findViewById(R.id.checkpoints_addriderequests);
        e5=findViewById(R.id.noofperson_addriderequests);
        e6=findViewById(R.id.date_addriderequests);
        e7=findViewById(R.id.time_addriderequests);
        e8=findViewById(R.id.personname_addriderequests);
        e9=findViewById(R.id.mobilno_addriderequests);

        fab=findViewById(R.id.fab_addriderequests);
        addRideRequests=new AddRideRequests();

        mAuth = FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        userid=user.getUid();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference nm= database.getInstance().getReference().child("RideRequests");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                    id = (int) dataSnapshot.getChildrenCount();
                }
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "opps.....", Toast.LENGTH_SHORT).show();

            }});

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDetails();
            }
        });

    }

    public void SaveDetails()
    {
        final String ridename = e1.getText().toString().trim();
        final String pickuppoint = e2.getText().toString().trim();
        final String dropmeoffpoint = e3.getText().toString().trim();
        final String checkpoint = e4.getText().toString().trim();
        final String noofperson = e5.getText().toString().trim();
        final String date = e6.getText().toString().trim();
        final String time = e7.getText().toString().trim();
        final String personname = e8.getText().toString().trim();
        final String mobilno = e9.getText().toString().trim();

        if (ridename.isEmpty()) {
            e1.setError(getString(R.string.input_error_ridename));
            e1.requestFocus();
            return;
        }
        if (pickuppoint.isEmpty()) {
            e2.setError(getString(R.string.input_error_pickup));
            e2.requestFocus();
            return;
        }
        if (dropmeoffpoint.isEmpty()) {
            e3.setError(getString(R.string.input_error_Dropoff));
            e3.requestFocus();
            return;
        }
        if (checkpoint.isEmpty()) {
            e4.setError(getString(R.string.input_error_Checkpoint));
            e4.requestFocus();
            return;
        }

        if (noofperson.isEmpty()) {
            e5.setError(getString(R.string.input_error_noofpersons));
            e5.requestFocus();
            return;
        }
        if (date.isEmpty()) {
            e6.setError(getString(R.string.input_error_Date));
            e6.requestFocus();
            return;
        }
        if (time.isEmpty()) {
            e7.setError(getString(R.string.input_error_time));
            e7.requestFocus();
            return;
        }


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myref = database.getReference("RideRequests");

        addRideRequests.setRidename(ridename);
        addRideRequests.setPickup(pickuppoint);
        addRideRequests.setDropmeoff(dropmeoffpoint);
        addRideRequests.setCheckpoint(checkpoint);
        addRideRequests.setDate(date);
        addRideRequests.setTime(time);
        addRideRequests.setNoofpersons(noofperson);
        addRideRequests.setPersonname(personname);
        addRideRequests.setMobileno(mobilno);
        addRideRequests.setUserid(userid);
        myref.child(String.valueOf(id+1)).setValue(addRideRequests);
    }
}