package com.myfirstapplication.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {
    Button registerCont;
    EditText nameEt,surnameEt,emailEt,pswEt;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        registerCont = (Button) findViewById(R.id.registerCont);
        nameEt = (EditText) findViewById(R.id.nameEt);
        surnameEt = (EditText) findViewById(R.id.surnameEt);
        emailEt = (EditText) findViewById(R.id.emailEt);
        pswEt = (EditText) findViewById(R.id.PasswEt);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(RegisterPage.this);

        registerCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameEt.getText().toString();
                String surname = surnameEt.getText().toString();
                String email = emailEt.getText().toString();
                String password =pswEt.getText().toString();


                // validating if the text fields are empty or not.
                if (name.isEmpty() && surname.isEmpty() && email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(RegisterPage.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewUser(name, surname, email, password);

                // after adding the data we are displaying a toast message.
                Toast.makeText(RegisterPage.this, "User has been added.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(intent);


/*

                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(intent);*/


            }
        });
    }
}