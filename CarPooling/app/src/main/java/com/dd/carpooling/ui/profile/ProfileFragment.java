package com.dd.carpooling.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dd.carpooling.LoginActivity;
import com.dd.carpooling.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    TextView t1,t2,t3,t4,t5,t6;
    Button b1;
    public String userid;
    private FirebaseAuth mAuth;
    FirebaseUser user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        t1=root.findViewById(R.id.textView15);
        t2=root.findViewById(R.id.profile_name_txt);
        t3=root.findViewById(R.id.profile_email_txt);
        t4=root.findViewById(R.id.profile_mob_txt);
        t5=root.findViewById(R.id.profile_occupation_txt);
        t6=root.findViewById(R.id.profile_address_txt);
        b1=root.findViewById(R.id.button3);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();

        userid=user.getUid();

        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference myref = db.getReference("Users");
        int id=0;
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                for (DataSnapshot npsnapshot : ds.getChildren()){

                    String customername=ds.child(userid).child("customername").getValue().toString();
                    String email=ds.child(userid).child("email").getValue().toString();
                    String mobileno=ds.child(userid).child("mobileno").getValue().toString();
                    String occupation=ds.child(userid).child("occupation").getValue().toString();
                    String address=ds.child(userid).child("address").getValue().toString();


                    t1.setText(customername);
                    t2.setText(customername);
                    t3.setText(email);
                    t4.setText(mobileno);
                    t5.setText(occupation);
                    t6.setText(address);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getActivity(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getActivity(),"fsf",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });

        return root;
    }

}