package com.example.iotraspberry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dht11Activity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refDB_dht11 = database.getReference("DHT11");
    DatabaseReference refKelembaban, refSuhu;
    TextView textKelembaban, textSuhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dht11);

        refKelembaban = refDB_dht11.child("Humid");
        refSuhu = refDB_dht11.child("Temp");

        textKelembaban = findViewById(R.id.tvKelembaban);
        textSuhu = findViewById(R.id.tvSuhu);

        showkelembaban(refKelembaban, textKelembaban);
        showsuhu(refSuhu, textSuhu);
    }

    private void showsuhu(final DatabaseReference refSuhu, final TextView textSuhu) {
        refSuhu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nilai_suhu = dataSnapshot.getValue().toString();
                textSuhu.setText(nilai_suhu + " °C");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void showkelembaban(final DatabaseReference refKelembaban, final TextView textKelembaban) {
        refKelembaban.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nilai_kelembaban = dataSnapshot.getValue().toString();
                textKelembaban.setText(nilai_kelembaban + " %");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }
}
