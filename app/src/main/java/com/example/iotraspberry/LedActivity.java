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

public class LedActivity extends AppCompatActivity {

    //Koneksi ke database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refDB_led = database.getReference("LEDnew");
    DatabaseReference ref_LedMerah, ref_LedKuning, ref_LedHijau, ref_LedBiru;

    //Inisialisasi Toogle
    ToggleButton btn_ToggleMerah, btn_ToggleKuning, btn_ToggleHijau, btn_ToggleBiru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);

        //koneksi ke key led pada db
        ref_LedMerah = refDB_led.child("ledmerah/nilai");
        ref_LedKuning = refDB_led.child("ledkuning/nilai");
        ref_LedHijau = refDB_led.child("ledhijau/nilai");
        ref_LedBiru = refDB_led.child("ledbiru/nilai");

        //koneksikan ke id xml toggle
        btn_ToggleMerah = findViewById(R.id.tgbtn_red);
        btn_ToggleKuning = findViewById(R.id.tgbtn_yellow);
        btn_ToggleHijau = findViewById(R.id.tgbtn_green);
        btn_ToggleBiru = findViewById(R.id.tgbtn_blue);

        //munculkan tulisan
        btn_ToggleMerah.setTextOn("ON");
        btn_ToggleMerah.setTextOff("OFF");
        btn_ToggleKuning.setTextOn("ON");
        btn_ToggleKuning.setTextOff("OFF");
        btn_ToggleHijau.setTextOn("ON");
        btn_ToggleHijau.setTextOff("OFF");
        btn_ToggleBiru.setTextOn("ON");
        btn_ToggleBiru.setTextOff("OFF");

        //fungsikan toggle
        control_LEDMerah(ref_LedMerah, btn_ToggleMerah);
        control_LEDKuning(ref_LedKuning, btn_ToggleKuning);
        control_LEDHijau(ref_LedHijau, btn_ToggleHijau);
        control_LEDBiru(ref_LedBiru, btn_ToggleBiru);
    }

    private void control_LEDMerah(final DatabaseReference ref_ledMerah, final ToggleButton btn_toggleMerah) {
        btn_ToggleMerah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                ref_ledMerah.setValue(isChecked);
            }
        });

        ref_LedMerah.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean statusLed = (Boolean) dataSnapshot.getValue();
                btn_toggleMerah.setChecked(statusLed);
                if (statusLed){
                    btn_toggleMerah.setTextOn("On");
                } else {
                    btn_toggleMerah.setTextOff("Off");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void control_LEDKuning(final DatabaseReference ref_ledKuning, final ToggleButton btn_toggleKuning) {
        btn_ToggleKuning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                ref_ledKuning.setValue(isChecked);
            }
        });

        ref_LedKuning.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean statusLed = (Boolean) dataSnapshot.getValue();
                btn_toggleKuning.setChecked(statusLed);
                if (statusLed){
                    btn_toggleKuning.setTextOn("On");
                } else {
                    btn_toggleKuning.setTextOff("Off");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void control_LEDHijau(final DatabaseReference ref_ledHijau, final ToggleButton btn_toggleHijau) {
        btn_ToggleHijau.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                ref_ledHijau.setValue(isChecked);
            }
        });

        ref_LedHijau.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean statusLed = (Boolean) dataSnapshot.getValue();
                btn_toggleHijau.setChecked(statusLed);
                if (statusLed){
                    btn_toggleHijau.setTextOn("On");
                } else {
                    btn_toggleHijau.setTextOff("Off");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void control_LEDBiru(final DatabaseReference ref_ledBiru, final ToggleButton btn_toggleBiru) {
        btn_ToggleBiru.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                ref_ledBiru.setValue(isChecked);
            }
        });

        ref_LedBiru.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean statusLed = (Boolean) dataSnapshot.getValue();
                btn_toggleBiru.setChecked(statusLed);
                if (statusLed){
                    btn_toggleBiru.setTextOn("On");
                } else {
                    btn_toggleBiru.setTextOff("Off");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
