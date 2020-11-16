package com.example.iotraspberry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BuzzerActivity extends AppCompatActivity {

    //Koneksi ke database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refDB_buzzer = database.getReference("Buzzer");
    DatabaseReference ref_Buzzer;

    //Inisialisasi Toogle
    ToggleButton btn_ToggleBuzzer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer);

        //koneksi ke key led pada db
        ref_Buzzer = refDB_buzzer.child("buzzer/nilai");

        //koneksikan ke id xml toggle
        btn_ToggleBuzzer = findViewById(R.id.tgbtn_buzzer);

        //munculkan tulisan
        btn_ToggleBuzzer.setTextOn("ON");
        btn_ToggleBuzzer.setTextOff("OFF");

        //fungsikan toggle
        control_Buzzer(ref_Buzzer, btn_ToggleBuzzer);
    }

    private void control_Buzzer(final DatabaseReference ref_buzzer, final ToggleButton btn_toggleBuzzer) {
        btn_ToggleBuzzer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                ref_buzzer.setValue(isChecked);
            }
        });

        ref_Buzzer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean statusBuzzer = (Boolean) dataSnapshot.getValue();
                btn_toggleBuzzer.setChecked(statusBuzzer);
                if (statusBuzzer){
                    btn_toggleBuzzer.setTextOn("On");
                } else {
                    btn_toggleBuzzer.setTextOff("Off");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
