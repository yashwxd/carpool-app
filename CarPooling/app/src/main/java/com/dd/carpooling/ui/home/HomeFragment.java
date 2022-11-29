package com.dd.carpooling.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dd.carpooling.ModelClasses.Offerridedetails;
import com.dd.carpooling.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {


    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;
    FloatingActionButton fab;
    private FirebaseAuth mAuth;
    FirebaseUser user;
    String userid;
    int id = 0;
    Offerridedetails offerridedetails;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        e1 = root.findViewById(R.id.ridenametxt3);
        e2 = root.findViewById(R.id.pickupoint_home);
        e3 = root.findViewById(R.id.dropmePpoint_home);
        e4 = root.findViewById(R.id.checkpoints_home);
        e5 = root.findViewById(R.id.carmodel_home);
        e6 = root.findViewById(R.id.vehiclenumber_home);
        e7 = root.findViewById(R.id.noofperson_home);
        e8 = root.findViewById(R.id.date_home);
        e9 = root.findViewById(R.id.time_home);
        e10 = root.findViewById(R.id.chargeperkm_home);
        fab = root.findViewById(R.id.fab_home);

        offerridedetails=new Offerridedetails();

        mAuth = FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        userid=user.getUid();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference nm= database.getInstance().getReference().child("Users");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot npsnapshot : dataSnapshot.getChildren()) {
                    id = (int) dataSnapshot.getChildrenCount();
                }
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getActivity(), "opps.....", Toast.LENGTH_SHORT).show();

            }});

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDetails();
            }
        });

        return root;
    }

    public void SaveDetails()
    {
        final String ridename = e1.getText().toString().trim();
        final String pickuppoint = e2.getText().toString().trim();
        final String dropmeoffpoint = e3.getText().toString().trim();
        final String checkpoint = e4.getText().toString().trim();
        final String carmodel = e5.getText().toString().trim();
        final String vehicleno = e6.getText().toString().trim();
        final String noofperson = e7.getText().toString().trim();
        final String date = e8.getText().toString().trim();
        final String time = e9.getText().toString().trim();
        final String chargeperkm = e10.getText().toString().trim();


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
        if (carmodel.isEmpty()) {
            e5.setError(getString(R.string.input_error_carmodel));
            e5.requestFocus();
            return;
        }
        if (vehicleno.isEmpty()) {
            e6.setError(getString(R.string.input_error_Vehicleno));
            e6.requestFocus();
            return;
        }
        if (noofperson.isEmpty()) {
            e7.setError(getString(R.string.input_error_noofpersons));
            e7.requestFocus();
            return;
        }
        if (date.isEmpty()) {
            e8.setError(getString(R.string.input_error_Date));
            e8.requestFocus();
            return;
        }
        if (time.isEmpty()) {
            e9.setError(getString(R.string.input_error_time));
            e9.requestFocus();
            return;
        }
        if (chargeperkm.isEmpty()) {
            e10.setError(getString(R.string.input_error_chargeperkm));
            e10.requestFocus();
            return;
        }

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myref = database.getReference("NewRideDetails");

        offerridedetails.setRidename(ridename);
        offerridedetails.setPickuppoint(pickuppoint);
        offerridedetails.setDropoffpoint(dropmeoffpoint);
        offerridedetails.setCheckpoint(checkpoint);
        offerridedetails.setCarmodel(carmodel);
        offerridedetails.setVehiclenumber(vehicleno);
        offerridedetails.setDate(date);
        offerridedetails.setTime(time);
        offerridedetails.setNumberofpersons(noofperson);
        offerridedetails.setChargeperkm(chargeperkm);
        offerridedetails.setUserid(userid);
        myref.child(String.valueOf(id+1)).setValue(offerridedetails);
    }
}


