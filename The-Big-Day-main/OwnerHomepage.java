package com.myfirstapplication.mobileproject;

import static com.myfirstapplication.mobileproject.DBHandler.tempId;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class OwnerHomepage extends AppCompatActivity {

    TextView owner,place,date,hour,quote;
    Button edit,guestList;
    private DBHandler dbHandler;
    RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_homepage);


        mQueue = Volley.newRequestQueue(OwnerHomepage.this);
        jsonParse();

        dbHandler = new DBHandler(OwnerHomepage.this);

        edit = (Button) findViewById(R.id.edit);
        guestList = (Button) findViewById(R.id.guestShow);
        owner = (TextView) findViewById(R.id.wedOwner);
        place = (TextView) findViewById(R.id.wedPlace);
        date = (TextView) findViewById(R.id.wedDate);
        hour = (TextView) findViewById(R.id.wedHour);
        quote = (TextView) findViewById(R.id.quote);

        owner.setText((dbHandler.getWeddingInfo(tempId)).getCoupleName());
        place.setText((dbHandler.getWeddingInfo(tempId)).getLocation());
        date.setText((dbHandler.getWeddingInfo(tempId)).getDate());
        hour.setText((dbHandler.getWeddingInfo(tempId)).getHour());



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerHomepage.this, EditWedding.class);
                startActivity(intent);

            }
        });
        guestList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnerHomepage.this, GuestList.class);
                startActivity(intent);

            }
        });

    }

    private void jsonParse(){
        String url = "https://api.jsonserve.com/_viOO3";
        String result = "";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("messages");
                            Random rand = new Random();

                            int rand_int1 = rand.nextInt(4);

                            JSONObject value = jsonArray.getJSONObject(rand_int1);
                            String temp = value.getString("message");
                            quote.setText(temp);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }



}