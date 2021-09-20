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
import com.example.android_busca_api.ui.Albuns;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import adapters.AlbumAdapter;
import models.Album;

public class AlbumPresenter  implements Response.Listener<JSONArray>, Response.ErrorListener {
    private List<Album> albuns = new ArrayList<>();
    Albuns albunsActivity;

    public AlbumPresenter(Albuns albunsActivity){
        this.albunsActivity = albunsActivity;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(albunsActivity.getApplicationContext(), "erro: " + error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        albuns.clear();
        try {
            for (int i =0; i < response.length(); i++){
                albuns.add(new Album(response.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AlbumAdapter adapter = new AlbumAdapter(albuns);
        albunsActivity.preparaRecicleView(adapter);
    }

    public void  getAPIAlbuns(){
        RequestQueue queue = Volley.newRequestQueue(albunsActivity.getApplicationContext());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/albums", null,
                this, this);
        queue.add(request);
    };
}
