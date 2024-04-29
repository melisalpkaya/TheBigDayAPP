package com.myfirstapplication.mobileproject;

import static com.myfirstapplication.mobileproject.DBHandler.tempId;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddGuest extends AppCompatActivity {
    Button addGuest;
    EditText guestName,guestSurname,guestEmail,guestPhoneNum;
    RadioGroup radioGroup;
    RadioButton oneRB,twoRB;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_guest);


        addGuest = (Button) findViewById(R.id.addGuestButton);
        guestName =(EditText) findViewById(R.id.guestName);
        guestSurname =(EditText) findViewById(R.id.guestSurname);
        guestEmail =(EditText) findViewById(R.id.guestEmail);
        guestPhoneNum =(EditText) findViewById(R.id.guestPhoneNum);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        oneRB = (RadioButton) findViewById(R.id.oneRB);
        twoRB = (RadioButton) findViewById(R.id.twoRB);

        dbHandler = new DBHandler(AddGuest.this);

        addGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = guestName.getText().toString();
                String surname = guestSurname.getText().toString();
                String email = guestEmail.getText().toString();
                String phone =guestPhoneNum.getText().toString();
                String numberOfGuest;
                if(oneRB.isChecked()){
                    numberOfGuest = String.valueOf(1);
                }else{
                    numberOfGuest = String.valueOf(2);
                }
                // validating if the text fields are empty or not.
                if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || phone.isEmpty() || numberOfGuest.isEmpty()) {
                    Toast.makeText(AddGuest.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    dbHandler.addGuest(name, surname, email, phone,numberOfGuest,"true",tempId);

                    Toast.makeText(getApplicationContext(),"Successfully added!",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(AddGuest.this, GuestList.class);
                startActivity(intent);


            }
     });
}
}