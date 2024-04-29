package com.myfirstapplication.mobileproject;

import static com.myfirstapplication.mobileproject.DBHandler.tempId;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateWedding extends AppCompatActivity {
    Button create;
    EditText yournameEt,partnernameEt,placeEt,dateEt,hourEt;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_wedding);

        create = (Button) findViewById(R.id.createWedding);
        yournameEt =(EditText) findViewById(R.id.yournameEt);
        partnernameEt =(EditText) findViewById(R.id.partnernameEt);
        placeEt =(EditText) findViewById(R.id.placeEt);
        dateEt =(EditText) findViewById(R.id.dateEt);
        hourEt =(EditText) findViewById(R.id.hourEt);

        dbHandler = new DBHandler(CreateWedding.this);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = yournameEt.getText().toString();
                String partnerName = partnernameEt.getText().toString();
                String place = placeEt.getText().toString();
                String date =dateEt.getText().toString();
                String hour =hourEt.getText().toString();


                // validating if the text fields are empty or not.
                if (name.isEmpty() && partnerName.isEmpty() && place.isEmpty() && date.isEmpty()&& hour.isEmpty()) {
                    Toast.makeText(CreateWedding.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.createWedding(name, partnerName, place, date,hour,tempId);

                Toast.makeText(CreateWedding.this, "Wedding has been created.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CreateWedding.this, OwnerHomepage.class);
                startActivity(intent);

            }
   });
    }
}