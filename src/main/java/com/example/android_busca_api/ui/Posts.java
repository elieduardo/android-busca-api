package com.example.android_busca_api.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import adapters.AlbumAdapter;
import adapters.PostAdapter;
import models.Album;
import models.Post;
import presenters.PostPresenter;

public class Posts extends AppCompatActivity{

    PostPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        getSupportActionBar().hide();

        presenter = new PostPresenter(this);
        presenter.getAPIPosts();
    }

    public void preparaRecicleView(PostAdapter adapter){
        RecyclerView rvPost = findViewById(R.id.rvPost);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvPost.setLayoutManager(linearLayoutManager);
        rvPost.setAdapter(adapter);
    }

}