package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_busca_api.R;

import java.util.List;

import models.Album;
import models.Todo;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private List<Album> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public AlbumAdapter(List<Album> todos){
        this.dados = todos;
    }

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_layout, parent, false);
        return new AlbumAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        Album album = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvAlbumTitle);
        tv.setText(album.getTitle());
        tv = holder.view.findViewById(R.id.tvAlbumId);
        tv.setText(""+album.getId());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
