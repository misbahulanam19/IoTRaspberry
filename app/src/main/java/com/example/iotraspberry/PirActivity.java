package com.example.iotraspberry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PirActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refDB_pir = database.getReference("PIR");
    DatabaseReference refPIR;
    ToggleButton btn_ToggleStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pir);

        refPIR = refDB_pir.child("Nilai");

        btn_ToggleStatus = findViewById(R.id.tgbtn_Status);

        //munculkan tulisan
        btn_ToggleStatus.setTextOn("Ada Gerakan");
        btn_ToggleStatus.setTextOff("Aman");

        showstatus(refPIR, btn_ToggleStatus);
    }

    private void showstatus(final DatabaseReference refPIR, final ToggleButton btn_ToggleStatus) {
        refPIR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                String nilai_status = dataSnapshot.getValue().toString();
//                textPIR.setText(nilai_status);
                Boolean statusPir = (Boolean) dataSnapshot.getValue();
                btn_ToggleStatus.setChecked(statusPir);
                if (statusPir){
                    btn_ToggleStatus.setTextOn("Ada Gerakan");
//                    btn_ToggleStatus.setBackgroundDrawable(getDrawable(R.drawable.ic_pir_peringatan));
                } else {
                    btn_ToggleStatus.setTextOff("Aman");
//                    btn_ToggleStatus.setBackgroundDrawable(getDrawable(R.drawable.ic_pir_aman));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}
