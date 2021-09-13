package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_busca_api.R;

import java.util.List;
import models.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public PostAdapter(List<Post> todos){
        this.dados = todos;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        Post post = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvPostTitle);
        tv.setText(post.getTitle());
        tv = holder.view.findViewById(R.id.tvPostId);
        tv.setText(""+post.getId());
        tv = holder.view.findViewById(R.id.tvBodyPost);
        tv.setText(""+post.getBody());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
