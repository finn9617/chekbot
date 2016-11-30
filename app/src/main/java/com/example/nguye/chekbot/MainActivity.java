package com.example.nguye.chekbot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvName;
    private RadioButton rbLess;
    private RadioButton rbGay;
    private CheckBox cbMautim;
    private CheckBox cbMauhong;
    private CheckBox cbNoitam;
    private CheckBox cbMauca;
    private ImageButton ib;
    private Spinner sn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sologan ="";
                sologan=String.valueOf(tvName.getText());
                if(cbMautim.isChecked()){
                    sologan=sologan + cbMautim.getText() +"-";
                }

                if(cbMauhong.isChecked()){
                    sologan=sologan + cbMauhong.getText() +"-";
                }

                if(cbMauca.isChecked()){
                    sologan=sologan + cbMauca.getText() +"-";
                }

                if(cbNoitam.isChecked()){
                    sologan=sologan + cbNoitam.getText() +"-";
                }

                if(rbGay.isChecked()){
                    sologan=sologan + rbGay.getText() ;
                }else sologan=sologan + rbLess.getText() ;
                Toast.makeText(MainActivity.this,sologan,Toast.LENGTH_SHORT).show();
            }
        });
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Androi");
        list.add("C++");
        list.add("Ngur Lun");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        sn.setAdapter(adapter);

        sn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,sn.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    public void initWidget(){
        tvName = (TextView) findViewById(R.id.tv_name);
        rbLess = (RadioButton) findViewById(R.id.rd_less);
        rbGay= (RadioButton) findViewById(R.id.rd_gay);
        cbMautim= (CheckBox) findViewById(R.id.cb_mautim);
        cbMauca= (CheckBox) findViewById(R.id.cb_mauca);
        cbMauhong= (CheckBox) findViewById(R.id.cb_mahong);
        cbNoitam= (CheckBox) findViewById(R.id.cb_noitam);
        ib=(ImageButton) findViewById(R.id.ib);
        sn=(Spinner) findViewById(R.id.sn);
    }
}
