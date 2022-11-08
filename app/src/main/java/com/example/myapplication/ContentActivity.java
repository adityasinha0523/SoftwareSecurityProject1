package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentActivity extends AppCompatActivity {
    EditText editID,editName,editPhone;
    TextView display;
    Button btnDisplay,btnClearDisplay;
    //TableLayout tb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        editID=findViewById(R.id.editID);
        editName=findViewById(R.id.editName);
        editPhone=findViewById(R.id.editPhone);

        btnDisplay=(Button)findViewById(R.id.btnDisplay);
        btnClearDisplay=(Button) findViewById(R.id.button);
        ListView list=(ListView) findViewById(R.id.gridView1);

       // display=findViewById(R.id.display);
        btnClearDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Map<String,String>> data=new ArrayList<Map<String,String>>();
                //data.add(Map.of("id",id,"name",name,"phone",phone));
                Map<String,String> map=new HashMap<String,String>();
                map.put("id",null);
                map.put("name",null);
                map.put("phone",null);
                data.add(map);
                String[] from={"id","name","phone"};
                int[] to={R.id.studentID,R.id.studentName,R.id.studentPhoneNumber};
                SimpleAdapter adapter = new SimpleAdapter(ContentActivity.this, data, R.layout.gridlayout, from, to);
                list.setAdapter(adapter);
            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editID.getText().toString().isEmpty()||editName.getText().toString().isEmpty()){
                    Toast.makeText(ContentActivity.this,"Empty",Toast.LENGTH_SHORT).show();
                }else{
                    String id=editID.getText().toString();
                    String name=editName.getText().toString();
                    String phone=editPhone.getText().toString();
                    List<Map<String,String>> data=new ArrayList<Map<String,String>>();
                    //data.add(Map.of("id",id,"name",name,"phone",phone));
                    Map<String,String> map=new HashMap<String,String>();
                    map.put("id",id);
                    map.put("name",name);
                    map.put("phone",phone);
                    data.add(map);
                    String[] from={"id","name","phone"};
                    int[] to={R.id.studentID,R.id.studentName,R.id.studentPhoneNumber};
                    SimpleAdapter adapter = new SimpleAdapter(ContentActivity.this, data, R.layout.gridlayout, from, to);
                    list.setAdapter(adapter);
                    //display.setText(data.toString());
                    //display.setText(id+"\n"+name);
                }
            }
        });
    }
}