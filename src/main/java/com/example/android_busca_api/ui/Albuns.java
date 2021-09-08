package com.example.android_busca_api.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.android_busca_api.R;

import org.json.JSONArray;

public class Albuns extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albuns);
        getSupportActionBar().hide();
        getAPI("albums");
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), "erro: " + error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        TextView tv = findViewById(R.id.conteudoAlbuns);
        tv.setText(response.toString());
    }

    private  void  getAPI(String metodo){
        RequestQueue queue = Volley.newRequestQueue(this);
        //
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/" + metodo, null,
                this, this);
        queue.add(request);
    };
}