package com.example.iotraspberry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UltrasonikActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refDB_jarak = database.getReference("Ultrasonik");
    DatabaseReference refJarak;

    TextView textJarak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultrasonik);

        refJarak = refDB_jarak.child("Jarak");
        textJarak = (TextView) findViewById(R.id.tv_jarak);

        showjarak(refJarak, textJarak);

    }

    private void showjarak(final DatabaseReference refJarak, final TextView textJarak) {
        refJarak.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nilai_jarak = dataSnapshot.getValue().toString();
                textJarak.setText(nilai_jarak + " cm");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
