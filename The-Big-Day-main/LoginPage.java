package com.myfirstapplication.mobileproject;

import static com.myfirstapplication.mobileproject.DBHandler.tempId;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    Button loginCont;
    EditText emailEt,pswEt;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginCont = (Button) findViewById(R.id.loginCont);
        Boolean flag = false;

        Owner owner;

        emailEt = (EditText) findViewById(R.id.emailEt);
        pswEt = (EditText) findViewById(R.id.PasswEt);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(LoginPage.this);


        loginCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailEt.getText().toString();
                String password =pswEt.getText().toString();

                Boolean temp = dbHandler.check(email,password);

                if(temp) {
                    //if user already created wedding
                    if(dbHandler.hasWedding(tempId)){
                        Intent intent = new Intent(LoginPage.this, OwnerHomepage.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(LoginPage.this, CreateWedding.class);
                        startActivity(intent);
                    }

                }
                else
                {
                    Toast.makeText(LoginPage.this, "Wrong username and password", Toast.LENGTH_SHORT).show();
                    emailEt.setText("");
                    pswEt.setText("");
                }






            }
        });




    }
}