package com.example.jinhwan.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    ImageView image ;
    TextView menu1,menu2,menu3,tel,homepage,date;
    Information info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        Intent intent = getIntent();
        info = intent.getParcelableExtra("show");
        setInfo();
    }
    public void init(){
        image = (ImageView)findViewById(R.id.imgno);
        menu1 = (TextView)findViewById(R.id.etmenu1);
        menu2 = (TextView)findViewById(R.id.etmenu2);
        menu3 = (TextView)findViewById(R.id.etmenu3);
        tel = (TextView)findViewById(R.id.tvTel);
        homepage = (TextView)findViewById(R.id.tvURL);
        date = (TextView)findViewById(R.id.tvRegdate);

    }
    public void onClick(View v){
        if(v.getId()==R.id.btnback){
            finish();
        }else if(v.getId()==R.id.imageView2){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:/"+info.call));
            startActivity(intent);
        }else if(v.getId()==R.id.imageView3){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(info.homepage));
            startActivity(intent);
        }
    }
    public void setInfo(){
        menu1.setText(info.menu[0]);
        menu2.setText(info.menu[1]);
        menu3.setText(info.menu[2]);
        tel.setText(info.call);
        homepage.setText(info.homepage);
        date.setText(info.date);
        if(info.category == 1)
            image.setImageResource(R.drawable.chicken);
        else if(info.category==2)
            image.setImageResource(R.drawable.pizza);
        else
            image.setImageResource(R.drawable.hamburger);
    }
}
