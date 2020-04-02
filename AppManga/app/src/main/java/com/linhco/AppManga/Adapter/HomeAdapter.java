package com.linhco.AppManga.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linhco.AppManga.Activity.Home;
import com.linhco.AppManga.Object.Manga;
import com.linhco.AppManga.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Manga> listManga;

    public HomeAdapter(List<Manga> listMangga) {
        this.listManga = listMangga;
    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manga, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder( HomeAdapter.ViewHolder holder, int position) {
        Manga manga = listManga.get(position);
        holder.ivManga.setImageResource(manga.getId());
        holder.tvName.setText(manga.getName());
        holder.tvDescription.setText(manga.getDescription());
    }

    @Override
    public int getItemCount() {
        return listManga.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivManga;
        TextView tvName, tvDescription;
        Button btnRead, btnFollow;

        public ViewHolder(final View itemView) {
            super(itemView);
            ivManga = itemView.findViewById(R.id.iv_bia);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            btnRead = itemView.findViewById(R.id.btn_read);
            btnFollow = itemView.findViewById(R.id.btn_follow);

            btnRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Read", Toast.LENGTH_SHORT).show();
                }
            });

            btnFollow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Da Luu",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
