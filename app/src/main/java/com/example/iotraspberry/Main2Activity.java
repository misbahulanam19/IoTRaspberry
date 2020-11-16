package com.example.iotraspberry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    public CardView menu1, menu2, menu3, menu4,
                    menu5, menu6, menu7, menu8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        menu1 = findViewById(R.id.btn_menuLed);
        menu2 = findViewById(R.id.btn_menuLedBtn);
        menu3 = findViewById(R.id.btn_menuLcd);
        menu4 = findViewById(R.id.btn_menuBuzzer);
        menu5 = findViewById(R.id.btn_menuSuhu);
        menu6 = findViewById(R.id.btn_menuJarak);
        menu7 = findViewById(R.id.btn_menuStatus);
        menu8 = findViewById(R.id.btn_menuPwm);

        menu1.setOnClickListener(this);
        menu2.setOnClickListener(this);
        menu3.setOnClickListener(this);
        menu4.setOnClickListener(this);
        menu5.setOnClickListener(this);
        menu6.setOnClickListener(this);
        menu7.setOnClickListener(this);
        menu8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.btn_menuLed :
                intent = new Intent(this, LedActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_menuLedBtn :
                intent = new Intent(this, LedBtnActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_menuLcd :
                intent = new Intent(this, LcdActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_menuBuzzer :
                intent = new Intent(this, BuzzerActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_menuSuhu :
                intent = new Intent(this, Dht11Activity.class);
                startActivity(intent);
                break;

            case R.id.btn_menuJarak :
                intent = new Intent(this, UltrasonikActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_menuStatus :
                intent = new Intent(this, PirActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_menuPwm :
                intent = new Intent(this, PwmActivity.class);
                startActivity(intent);
                break;
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.iot_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.item1:
//                return true;
//            case R.id.item2:
//                return true;
//            case R.id.item3:
//                return true;
//            case R.id.item4:
//                return true;
//            case R.id.item5:
//                return true;
//            case R.id.item6:
//                return true;
//            case R.id.item7:
//                return true;
//            case R.id.item8:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    public void PindahLed(MenuItem item){
//        Intent intent = new Intent(Main2Activity.this, LedActivity.class);
//        startActivity(intent);
//    }
//
//    public void PindahBtn(MenuItem item){
//        Intent intent = new Intent(Main2Activity.this, LedBtnActivity.class);
//        startActivity(intent);
//    }
//
//    public void PindahLcd(MenuItem item){
//        Intent intent = new Intent(Main2Activity.this, LcdActivity.class);
//        startActivity(intent);
//    }
//
//    public void PindahBuzzer(MenuItem item){
//        Intent intent = new Intent(Main2Activity.this, BuzzerActivity.class);
//        startActivity(intent);
//    }
//
//    public void PindahSuhu(MenuItem item){
//        Intent intent = new Intent(Main2Activity.this, Dht11Activity.class);
//        startActivity(intent);
//    }
//
//    public void PindahJarak(MenuItem item){
//        Intent intent = new Intent(Main2Activity.this, UltrasonikActivity.class);
//        startActivity(intent);
//    }
//
//    public void PindahStatus(MenuItem item){
//        Intent intent = new Intent(Main2Activity.this, PirActivity.class);
//        startActivity(intent);
//    }
//
//    public void PindahPwm(MenuItem item){
//        Intent intent = new Intent(Main2Activity.this, PwmActivity.class);
//        startActivity(intent);
//    }

}
