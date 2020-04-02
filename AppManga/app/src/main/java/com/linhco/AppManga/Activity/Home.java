package com.linhco.AppManga.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.linhco.AppManga.Adapter.HomeAdapter;
import com.linhco.AppManga.Object.Manga;
import com.linhco.AppManga.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private RecyclerView manga;
    private HomeAdapter adapter;
    private List<Manga> listManga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("DANH SÁCH TRUYỆN"); // đổi tên thanh bar

        initView();
    }

    private void initView() {
        listManga = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            listManga.add(new Manga("Dragon ball", "Một cậu bé có đuôi khỉ tên là Goku được tìm thấy bởi một ông lão sống một mình trong rừng",R.drawable.aa));
            listManga.add(new Manga("Dragon Ball Super", "Câu chuyện của Dragon Ball Super diễn ra ngay sau khi chiến đấu với Ma Nhân Bư",R.drawable.bb));
            listManga.add(new Manga("Naruto","Naruto là một cậu bé có mơ ước trở thành hokage của làng Konoha",R.drawable.cc));
            listManga.add(new Manga("one piece", "One Piece xoay quanh 1 nhóm cướp biển được gọi là Băng Hải tặc Mũ Rơm - Straw Hat Pirates ", R.drawable.dd));
            listManga.add(new Manga("nu hong ai cap", "",R.drawable.ee));
        }

        manga = findViewById(R.id.rcv_list_manga); //anh xa
        manga.setHasFixedSize(true);
        manga.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HomeAdapter(listManga);
        manga.setAdapter(adapter);
    }
}