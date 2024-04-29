package com.myfirstapplication.mobileproject;

import static com.myfirstapplication.mobileproject.DBHandler.tempId;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GuestList extends AppCompatActivity {
    ListView list;
    Button add;
    String str = "";
    String str2 = "";
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_list);

        dbHandler = new DBHandler(GuestList.this);

        add = (Button) findViewById(R.id.addGuest);
        list = (ListView) findViewById(R.id.list);
        ArrayList<Guest> lastList = new ArrayList<>();


        Cursor c = dbHandler.getAllContacts(tempId);
        if(c.moveToNext()){
            do{
                DisplayGuest(c);
            }while(c.moveToNext());
        }

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View arg1, int position,
                                    long arg3)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(GuestList.this);
                if(dbHandler.getGuestsInfos(tempId).get(position).getStatus()){
                    builder.setTitle("Join.");
                }
                else{
                    builder.setTitle("Can't Join...");
                }
               // builder.setTitle(dbHandler.getGuestsInfos(tempId).get(position).getPhoneNum());
                builder.setMessage("Name: " + dbHandler.getGuestsInfos(tempId).get(position).getName()+" "+dbHandler.getGuestsInfos(tempId).get(position).getSurname()+"\n" + "Phone: " + dbHandler.getGuestsInfos(tempId).get(position).getPhoneNum() +"\n"+ "Email: " +  dbHandler.getGuestsInfos(tempId).get(position).getEmail() +"\n" + dbHandler.getGuestsInfos(tempId).get(position).getGuestNum()+ " person join.");
                builder.setNegativeButton("Ok", null);
                builder.show();
                return true;

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuestList.this, AddGuest.class);
                startActivity(intent);

            }
        });

    }
    public void DisplayGuest(Cursor c){
        ArrayList<String> arr =new ArrayList<String>();
        String arrx[],arry[];
        str += c.getString(1) +"\n";
        str2 += c.getString(2) +"\n";
        arrx=str.split("\n");   //  keeps names
        arry=str2.split("\n");  //  keeps surnames
        int a=arrx.length;
        String arrz[]=new String[a];  //will keeps names & surnames

        for(int i =0;i< arrx.length;i++){
            arrz[i]=arrx[i]+" "+ arry[i];
            arr.add(arrz[i]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr);
        list.setAdapter(arrayAdapter);
    }

}