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
import com.example.android_busca_api.ui.Home;
import com.example.android_busca_api.ui.Todos;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import adapters.TodoAdapter;
import models.Todo;

public class TodoPresenter  implements Response.Listener<JSONArray>, Response.ErrorListener {
    private List<Todo> todos = new ArrayList<>();
    private Todos todosActivity;

    public TodoPresenter(Todos activity){
        this.todosActivity = activity;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(todosActivity.getApplicationContext(), "erro: " + error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        todos.clear();
        try {
            for (int i =0; i < response.length(); i++){
                todos.add(new Todo(response.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TodoAdapter adapter = new TodoAdapter(todos);
        todosActivity.preparaRecyclerView(adapter);
    }

    public void  getAPITodos(){
        RequestQueue queue = Volley.newRequestQueue(todosActivity.getApplicationContext());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos", null,
                this, this);
        queue.add(request);
    };
}
