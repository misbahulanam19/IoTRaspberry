package com.example.iotraspberry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LcdActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refDB_LCD = database.getReference("LCD");
    DatabaseReference refPesan;
    EditText tekslcd;
    Button tampilkan;
    Datakirim datakirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lcd);

        refPesan = refDB_LCD.child("pesan");
        tekslcd = findViewById(R.id.tv_lcdInput);
        tampilkan = findViewById(R.id.btn_lcdInput);
        datakirim = new Datakirim();
    }

    private void getValues(){
        datakirim.setTekslcd(tekslcd.getText().toString());
    }

    public void btnKirim(View view) {
        refPesan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValues();
                refPesan.setValue(datakirim);
                Toast.makeText(LcdActivity.this, "Teks Ditampilkan!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
