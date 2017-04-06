package com.example.jinhwan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.DateFormat;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    EditText name, tel, homepage,menu1,menu2,menu3;
    RadioButton categoryChick,categoryPiz,categoryHam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    public void init(){
        name = (EditText)findViewById(R.id.etname);
        tel = (EditText)findViewById(R.id.ettel);
        homepage = (EditText)findViewById(R.id.etaddr);
        menu1 = (EditText)findViewById(R.id.etmenu1);
        menu2 = (EditText)findViewById(R.id.etmenu1);
        menu3 = (EditText)findViewById(R.id.etmenu1);
        categoryChick = (RadioButton)findViewById(R.id.radio1);
        categoryPiz = (RadioButton)findViewById(R.id.radio2);
        categoryHam = (RadioButton)findViewById(R.id.radio3);
    }
    public String changeToString(EditText edit){
        return edit.getText().toString();
    }
    public int returnCategory(){
        if(categoryChick.isChecked())
            return 1;
        else if(categoryPiz.isChecked())
            return 2;
        else
            return 3;
    }

    public void onClick(View v){
        if(v.getId() == R.id.btnAdd){
            String[] menu = {changeToString(menu1),changeToString(menu2),changeToString(menu3)};
            String date = DateFormat.getDateTimeInstance().format(new Date());
            Intent intent = new Intent();
            Information info = new Information(changeToString(name),changeToString(tel),menu,changeToString(homepage),
                    date,returnCategory());
            intent.putExtra("add",info);
            setResult(RESULT_OK,intent);
            finish();
        }else if(v.getId() == R.id.btnCancel){
            finish();
        }
    }


}
