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

public class Posts extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{
    private List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        getSupportActionBar().hide();
        getAPI("posts");
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), "erro: " + error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        posts.clear();
        try {
            for (int i =0; i < response.length(); i++){
                posts.add(new Post(response.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView rvPost = findViewById(R.id.rvPost);
        PostAdapter adapter = new PostAdapter(posts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvPost.setLayoutManager(linearLayoutManager);
        rvPost.setAdapter(adapter);
    }

    private  void  getAPI(String metodo){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/" + metodo, null,
                this, this);
        queue.add(request);
    };
}