package com.example.iotraspberry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PwmActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refPWM_led = database.getReference("PWMled");
    DatabaseReference ref_pwmMerah, ref_pwmKuning, ref_pwmHijau, ref_pwmBiru,
            ref_frekMerah, ref_frekKuning, ref_frekHijau, ref_frekBiru;

    Button btn_frek_ledMerah, btn_frek_ledKuning, btn_frek_ledHijau, btn_frek_ledBiru;
    SeekBar seekBar_Merah, seekBar_Kuning, seekBar_Hijau, seekBar_Biru;
    TextView tv_sb_ledMerah, tv_sb_ledKuning, tv_sb_ledHijau, tv_sb_ledBiru;
    EditText et_ledMerah, et_ledKuning, et_ledHijau, et_ledBiru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwm);

        ref_pwmMerah = refPWM_led.child("ledmerah/bright");
        ref_pwmKuning = refPWM_led.child("ledkuning/bright");
        ref_pwmHijau = refPWM_led.child("ledhijau/bright");
        ref_pwmBiru = refPWM_led.child("ledbiru/bright");

        ref_frekMerah = refPWM_led.child("ledmerah/freq");
        ref_frekKuning = refPWM_led.child("ledkuning/freq");
        ref_frekHijau = refPWM_led.child("ledhijau/freq");
        ref_frekBiru = refPWM_led.child("ledbiru/freq");

        seekBar_Merah = findViewById(R.id.sbRed);
        tv_sb_ledMerah = findViewById(R.id.tv_sb_Red);

        seekBar_Kuning = findViewById(R.id.sbYellow);
        tv_sb_ledKuning = findViewById(R.id.tv_sb_Yellow);

        seekBar_Hijau = findViewById(R.id.sbGreen);
        tv_sb_ledHijau = findViewById(R.id.tv_sb_Green);

        seekBar_Biru = findViewById(R.id.sbBlue);
        tv_sb_ledBiru = findViewById(R.id.tv_sb_Blue);

        et_ledMerah = findViewById(R.id.et_frek_Red);
        et_ledKuning = findViewById(R.id.et_frek_Yellow);
        et_ledHijau = findViewById(R.id.et_frek_Green);
        et_ledBiru = findViewById(R.id.et_frek_Blue);

        btn_frek_ledMerah = findViewById(R.id.btn_frek_Red);
        btn_frek_ledKuning = findViewById(R.id.btn_frek_Yellow);
        btn_frek_ledHijau = findViewById(R.id.btn_frek_Green);
        btn_frek_ledBiru = findViewById(R.id.btn_frek_Blue);

        controlPWMledred(ref_pwmMerah, seekBar_Merah, tv_sb_ledMerah, ref_frekMerah, et_ledMerah);
        controlPWMledyellow(ref_pwmKuning, seekBar_Kuning, tv_sb_ledKuning, ref_frekKuning, et_ledKuning);
        controlPWMledgreen(ref_pwmHijau, seekBar_Hijau, tv_sb_ledHijau, ref_frekHijau, et_ledHijau);
        controlPWMledblue(ref_pwmBiru, seekBar_Biru, tv_sb_ledBiru, ref_frekBiru, et_ledBiru);
    }

    private void controlPWMledred(final DatabaseReference ref_pwmMerah,
                                  final SeekBar seekBar_merah,
                                  final TextView tv_sb_ledMerah,
                                  final DatabaseReference ref_frekMerah,
                                  final EditText et_ledMerah) {
        seekBar_merah.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int bright, boolean b) {
                ref_pwmMerah.setValue(bright);
                tv_sb_ledMerah.setText(bright+"");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        ref_pwmMerah.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String bright = (String) dataSnapshot.getValue().toString();
                tv_sb_ledMerah.setText(bright);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ref_frekMerah.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String freq = dataSnapshot.getValue().toString();
                et_ledMerah.setText(freq);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    public void btn_red_clicked(View view) {
        String freq_ledred = et_ledMerah.getText().toString();
        ref_frekMerah.setValue(freq_ledred);
    }

    private void controlPWMledyellow(final DatabaseReference ref_pwmKuning,
                                     final SeekBar seekBar_kuning,
                                     final TextView tv_sb_ledKuning,
                                     final DatabaseReference ref_frekKuning,
                                     final EditText et_ledKuning) {
        seekBar_kuning.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int bright, boolean b) {
                ref_pwmKuning.setValue(bright);
                tv_sb_ledKuning.setText(bright+"");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        ref_pwmKuning.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String bright = (String) dataSnapshot.getValue().toString();
                tv_sb_ledKuning.setText(bright);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ref_frekKuning.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String freq = dataSnapshot.getValue().toString();
                et_ledKuning.setText(freq);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    public void btn_yellow_clicked(View view) {
        String freq_ledyellow = et_ledKuning.getText().toString();
        ref_frekKuning.setValue(freq_ledyellow);
    }

    private void controlPWMledgreen(final DatabaseReference ref_pwmHijau,
                                    final SeekBar seekBar_hijau,
                                    final TextView tv_sb_ledHijau,
                                    final DatabaseReference ref_frekHijau,
                                    final EditText et_ledHijau) {
        seekBar_hijau.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int bright, boolean b) {
                ref_pwmHijau.setValue(bright);
                tv_sb_ledHijau.setText(bright+"");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        ref_pwmHijau.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String bright = (String) dataSnapshot.getValue().toString();
                tv_sb_ledHijau.setText(bright);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ref_frekHijau.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String freq = dataSnapshot.getValue().toString();
                et_ledHijau.setText(freq);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    public void btn_green_clicked(View view) {
        String freq_ledgreen = et_ledHijau.getText().toString();
        ref_frekHijau.setValue(freq_ledgreen);
    }


    private void controlPWMledblue(final DatabaseReference ref_pwmBiru,
                                   final SeekBar seekBar_biru,
                                   final TextView tv_sb_ledBiru,
                                   final DatabaseReference ref_frekBiru,
                                   final EditText et_ledBiru) {
        seekBar_biru.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int bright, boolean b) {
                ref_pwmBiru.setValue(bright);
                tv_sb_ledBiru.setText(bright+"");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        ref_pwmBiru.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String bright = (String) dataSnapshot.getValue().toString();
                tv_sb_ledBiru.setText(bright);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ref_frekBiru.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String freq = dataSnapshot.getValue().toString();
                et_ledBiru.setText(freq);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    public void btn_blue_clicked(View view) {
        String freq_ledblue = et_ledBiru.getText().toString();
        ref_frekBiru.setValue(freq_ledblue);
    }

}
