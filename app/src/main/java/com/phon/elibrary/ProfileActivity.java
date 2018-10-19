package com.phon.elibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {

    private TextView Name;
    private TextView Major;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        Name = findViewById(R.id.txt_name);
        Major = findViewById(R.id.txt_major);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url ="http://test.js-cambodia.com/ckcc/profile.php";

        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                //JsonObject jsonObject = null;

                try {
                    String name = response.getString("name");
                    String major = response.getString("major");
                    Name.setText(name);
                    Major.setText(major);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProfileActivity.this,"Error Loading data" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(request);

    }
}
