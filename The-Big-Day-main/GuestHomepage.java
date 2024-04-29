package com.myfirstapplication.mobileproject;

import static com.myfirstapplication.mobileproject.DBHandler.a;
import static com.myfirstapplication.mobileproject.DBHandler.guest5;
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

public class GuestHomepage extends AppCompatActivity {
    public static int pos;
   String arr3[];
    String str = "";
    String str2 = "";
    String str3 = "";
    Button wed1;
    ListView wedList;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_homepage);

        dbHandler = new DBHandler(GuestHomepage.this);

       // wed1 = (Button) findViewById(R.id.Wed1);
        wedList = (ListView) findViewById(R.id.invitedWeds);

        for(int i=0;i<a.size();i++){
            Cursor c= dbHandler.getAllWeddings(a.get(i));
            if(c.moveToNext()){
                do{
                    DisplayWed(c);
                }while(c.moveToNext());
            }
        }
        wedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position,
                                    long arg3)
            {

                pos = position;
               /* Wedding b  = new Wedding();
                b.setdbHandler.getWeddingInfo(arr3[0])*/
                Intent intent = new Intent(GuestHomepage.this, InvitedWeddingDetail.class);
                startActivity(intent);


            }
        });



    }
    public void DisplayWed(Cursor c){
        ArrayList<String> arr =new ArrayList<String>();

        String arrx[],arry[];

        str += c.getString(2) +"\n";
        str2 += c.getString(3) +"\n";
        str3 += c.getString(0) +"\n";

        arrx=str.split("\n");   //  keeps name
        arry=str2.split("\n");  //  keeps partner name
        arr3=str3.split("\n");  //  keeps id's
        int a=arrx.length;
        String arrz[]=new String[a];  //will keeps name & partner name

        for(int i =0;i< arrx.length;i++){
            arrz[i]=arrx[i]+" & "+ arry[i];
            arr.add(arrz[i]);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr);
        wedList.setAdapter(arrayAdapter);

    }

}