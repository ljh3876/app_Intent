package com.example.jinhwan.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int _ADD_MENU_CODE = 1;
    final int _SHOW_MENU_CODE = 2;
    TextView count ;
    ListView listView ;
    ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<Information> infoList = new ArrayList<Information>();
    ArrayAdapter<String> adapter;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = (TextView)findViewById(R.id.tv);
        setListView();
    }
    public void setListView(){
        listView = (ListView)findViewById(R.id.listview);
        //어댑터 만들기 (화면과 데이터 결정)
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameList);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("경고")
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                nameList.remove(position);
                                infoList.remove(position);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(getApplicationContext(),"삭제되었습니다.",Toast.LENGTH_SHORT).show();
                                i-=1;
                                count.setText("맛집 리스트("+i+"개)");
                            }
                        }).show();
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                intent.putExtra("show",infoList.get(position));
                startActivityForResult(intent,_SHOW_MENU_CODE);

            }
        });
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnAddList) {
            Intent intent = new Intent(this,Main2Activity.class);
            startActivityForResult(intent,_ADD_MENU_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == _ADD_MENU_CODE){
            if(resultCode == RESULT_OK){
                i+=1;
                count.setText("맛집 리스트("+i+"개)");
                Information temp = data.getParcelableExtra("add");
                infoList.add(temp);
                nameList.add(temp.name);
                adapter.notifyDataSetChanged();
            }
        }
            super.onActivityResult(requestCode, resultCode, data);
    }
}
