package com.myfirstapplication.mobileproject;

import static com.myfirstapplication.mobileproject.DBHandler.a;
import static com.myfirstapplication.mobileproject.DBHandler.tempGuestName;
import static com.myfirstapplication.mobileproject.DBHandler.tempId;
import static com.myfirstapplication.mobileproject.GuestHomepage.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InvitedWeddingDetail extends AppCompatActivity {
    Button save;
    TextView coupleName, place, date,hour;
    RadioGroup radioGroup2,radioGroup3;
    RadioButton willJoin,cantJoin,one,two;
    private DBHandler dbHandler;
    String myStatus;
    String numberOfGuest;
    LinearLayout lyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invited_wedding_detail);

        dbHandler = new DBHandler(InvitedWeddingDetail.this);
        coupleName = (TextView) findViewById(R.id.coupleName);
        place = (TextView) findViewById(R.id.place);
        date = (TextView) findViewById(R.id.date);
        hour = (TextView) findViewById(R.id.hour);
        save = (Button) findViewById(R.id.detailSave);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        willJoin = (RadioButton) findViewById(R.id.willJoin);
        cantJoin = (RadioButton) findViewById(R.id.cantJoin);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        one = (RadioButton) findViewById(R.id.one);
        two = (RadioButton) findViewById(R.id.two);
        lyt= (LinearLayout) findViewById(R.id.section2);

        coupleName.setText((dbHandler.getWeddingInfo(a.get(pos))).getCoupleName());
        place.setText((dbHandler.getWeddingInfo(a.get(pos))).getLocation());
        date.setText((dbHandler.getWeddingInfo(a.get(pos))).getDate());
        hour.setText((dbHandler.getWeddingInfo(a.get(pos))).getHour());

        RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroup2);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radio.findViewById(checkedId);
                int index = radio.indexOfChild(radioButton);

                // Add logic here

                switch (index) {
                    case 0: // first button
                        myStatus = "true";
                        lyt.setVisibility(View.VISIBLE);
                        if(one.isChecked()){
                            numberOfGuest = String.valueOf(1);
                        }else{
                            numberOfGuest = String.valueOf(2);
                        }
                        Toast.makeText(getApplicationContext(), "I will join selected",Toast.LENGTH_SHORT).show();
                        break;
                    case 1: // secondbutton
                        myStatus = "false";
                        numberOfGuest = String.valueOf(0);
                        lyt.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), "I can't join selected",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Boolean a = dbHandler.updateGuestInfo(myStatus,numberOfGuest,tempGuestName);
                    Toast.makeText(getApplicationContext(),String.valueOf(a),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(InvitedWeddingDetail.this, GuestHomepage.class);
                    startActivity(intent);

                    /*if(status){
                        Toast.makeText(getApplicationContext(),"Successfully added!",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(InvitedWeddingDetail.this, GuestHomepage.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();

                    }*/
                }


        });


    }
}