package presenters;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.android_busca_api.R;
import com.example.android_busca_api.ui.Posts;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import adapters.PostAdapter;
import models.Post;

public class PostPresenter  implements Response.Listener<JSONArray>, Response.ErrorListener{
    private List<Post> posts = new ArrayList<>();
    private Posts postsActivity;

    public PostPresenter(Posts postsActivity){
        this.postsActivity = postsActivity;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(postsActivity.getApplicationContext(), "erro: " + error.toString(), Toast.LENGTH_LONG).show();
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

        PostAdapter adapter = new PostAdapter(posts);
        postsActivity.preparaRecicleView(adapter);
    }

    public void  getAPIPosts(){
        RequestQueue queue = Volley.newRequestQueue(postsActivity.getApplicationContext());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/posts", null,
                this, this);
        queue.add(request);
    };
}
