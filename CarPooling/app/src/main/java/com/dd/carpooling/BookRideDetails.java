package com.dd.carpooling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.carpooling.ModelClasses.BookedRidesmodel;
import com.dd.carpooling.ModelClasses.Offerridedetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class BookRideDetails extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    String getpickup,getdropup,getcheckup,getcarmodel,getvehicle,getdate,gettime,getcharge,getridename;
    Switch switch1;
    BookedRidesmodel bookedRidesmodel;
    public String userid;
    private FirebaseAuth mAuth;
    FirebaseUser user;
    int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingride);

        getSupportActionBar().hide();

        t1=findViewById(R.id.pickupoint_book);
        t2=findViewById(R.id.dropoffpoint_book);
        t3=findViewById(R.id.checkpoints_book);
        t4=findViewById(R.id.carmodel_book);
        t5=findViewById(R.id.vehiclenumber_book);
        t6=findViewById(R.id.date_book);
        t7=findViewById(R.id.time_book);
        t8=findViewById(R.id.chargeperkm_book);
        t9=findViewById(R.id.ridename);
        switch1=findViewById(R.id.booking_switch);

        getpickup=getIntent().getStringExtra("pickup");
        getdropup=getIntent().getStringExtra("dropoff");
        getcheckup=getIntent().getStringExtra("checkpoints");
        getcarmodel=getIntent().getStringExtra("carmodel");
        getvehicle=getIntent().getStringExtra("vehicleno");
        getdate=getIntent().getStringExtra("date");
        gettime=getIntent().getStringExtra("time");
        getcharge=getIntent().getStringExtra("charge");
        getridename=getIntent().getStringExtra("ridename");


        t1.setText(getpickup);
        t2.setText(getdropup);
        t3.setText(getcheckup);
        t4.setText(getcarmodel);
        t5.setText(getvehicle);
        t6.setText(getdate);
        t7.setText(gettime);
        t8.setText(getcharge);
        t9.setText(getridename);
        bookedRidesmodel=new BookedRidesmodel();

        mAuth = FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        userid=user.getUid();

//        final FirebaseDatabase db = FirebaseDatabase.getInstance();
//        final DatabaseReference myref = db.getReference("Customers");
//        int id=0;
//        myref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot ds) {
//                for (DataSnapshot npsnapshot : ds.getChildren()){
//
//                    String customername=ds.child(userid).child("customername").getValue().toString();
//                    String email=ds.child(userid).child("email").getValue().toString();
//                    String mobileno=ds.child(userid).child("mobileno").getValue().toString();
//                    String occupation=ds.child(userid).child("occupation").getValue().toString();
//                    String address=ds.child(userid).child("address").getValue().toString();
//
//
//                    t1.setText(customername);
//                    t2.setText(customername);
//                    t3.setText(email);
//                    t4.setText(mobileno);
//                    t5.setText(occupation);
//                    t6.setText(address);
//
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
//            }
//        });

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference nm= database.getInstance().getReference().child("BookedRides");
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

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Book();
                Intent i = new Intent(getApplicationContext(), PaymentActivity.class);
                startActivity(i);
            }
        });

    }
    public void Book()
    {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myref = database.getReference("BookedRides");


        bookedRidesmodel.setPickuppoint(getpickup);
        bookedRidesmodel.setDropoffpoint(getdropup);
        bookedRidesmodel.setDate(getdate);
        bookedRidesmodel.setTime(gettime);
        bookedRidesmodel.setChargeperkm(getcharge);
        bookedRidesmodel.setUserid(userid);
        myref.child(String.valueOf(id+1)).setValue(bookedRidesmodel);
        Toast.makeText(getApplicationContext(),"Booked Successfully",Toast.LENGTH_SHORT).show();
    }
}