package com.example.android_busca_api.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.android_busca_api.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        Button botaoBuscarTodo = findViewById(R.id.buscarTODO);
        botaoBuscarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getAPI("todos");
                Intent intent = new Intent(v.getContext(), Todos.class);
                startActivity(intent);
            }
        });

        Button botaoBuscarAlbuns = findViewById(R.id.buscarAlbuns);
        botaoBuscarAlbuns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Albuns.class);
                startActivity(intent);
            }
        });

        Button botaoBuscarPosts = findViewById(R.id.buscarPosts);
        botaoBuscarPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Posts.class);
                startActivity(intent);
            }
        });
    }
}