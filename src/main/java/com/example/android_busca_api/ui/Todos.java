package com.example.android_busca_api.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.android_busca_api.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import adapters.TodoAdapter;
import models.Todo;
import presenters.TodoPresenter;

public class Todos extends AppCompatActivity{

    TodoPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        presenter = new TodoPresenter(this);
        getSupportActionBar().hide();

        presenter.getAPITodos();
    }

    public void preparaRecyclerView(TodoAdapter adapter){
        RecyclerView rvTodos = findViewById(R.id.rvTodos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvTodos.setLayoutManager(linearLayoutManager);
        rvTodos.setAdapter(adapter);
    }
}