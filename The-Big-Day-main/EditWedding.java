package com.myfirstapplication.mobileproject;

import static com.myfirstapplication.mobileproject.DBHandler.tempId;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditWedding extends AppCompatActivity {
    Button update;
    EditText place,date,hour;
    TextView ownerName;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_wedding);

        dbHandler = new DBHandler(EditWedding.this);


        update = (Button) findViewById(R.id.updateButton);
        ownerName = (TextView) findViewById(R.id.nameUpdate);
        place = (EditText) findViewById(R.id.placeUpdate);
        date = (EditText) findViewById(R.id.dateUpdate);
        hour = (EditText) findViewById(R.id.hourUpdate);

        ownerName.setText((dbHandler.getWeddingInfo(tempId)).getCoupleName());
        place.setText((dbHandler.getWeddingInfo(tempId)).getLocation());
        date.setText((dbHandler.getWeddingInfo(tempId)).getDate());
        hour.setText((dbHandler.getWeddingInfo(tempId)).getHour());


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean flag = dbHandler.updateWeddingInfo(String.valueOf(place.getText()),String.valueOf(date.getText()),String.valueOf(hour.getText()),tempId);
                if(flag){
                    Toast.makeText(getApplicationContext(),"Successfully updated!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(EditWedding.this, OwnerHomepage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"ERROR!",Toast.LENGTH_LONG).show();
                }


            }
        });



    }
}