package com.myfirstapplication.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuestStartPage extends AppCompatActivity {
    Button join;
    EditText phone;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_start_page);

        join = (Button) findViewById(R.id.joinButton);
        phone = (EditText) findViewById(R.id.phone);
        dbHandler = new DBHandler(GuestStartPage.this);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String key = String.valueOf(phone.getText());
                if(dbHandler.hasGuest(key)){

                    Intent intent = new Intent(GuestStartPage.this, GuestHomepage.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(),"You are not invited to any wedding!",Toast.LENGTH_SHORT).show();

            }
        });




    }
}