package com.linhco.AppManga.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.linhco.AppManga.R;

import java.util.prefs.PreferenceChangeEvent;

public class Info extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btnSaveInfo;
    EditText nameInfo, phoneInfo, emailInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("THÔNG TIN TÀI KHOẢN"); // đổi tên thanh bar
        String title = actionBar.getTitle().toString();
        actionBar.setDisplayHomeAsUpEnabled(true);

        initPreference();

        nameInfo = findViewById(R.id.edt_nameInfo);
        phoneInfo = findViewById(R.id.edt_phoneInfo);
        emailInfo = findViewById(R.id.edt_emailInfo);
        btnSaveInfo = findViewById(R.id.btn_saveInfo);

        String saveName = sharedPreferences.getString("NAME", "");
        String savePhone = sharedPreferences.getString("PHONE", "");
        String saveEmail = sharedPreferences.getString("EMAIL", "");

        nameInfo.setText(saveName);
        phoneInfo.setText(savePhone);
        emailInfo.setText(saveEmail);

        btnSaveInfo.setOnClickListener(this);
    }

    private void initPreference(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == btnSaveInfo){
            // Nếu click vào nút Save, ta sẽ lưu dữ liệu lại.
            String name = nameInfo.getText().toString();
            editor.putString("NAME", name);

            String phone = phoneInfo.getText().toString();
            editor.putString("PHONE", phone);

            String email = emailInfo.getText().toString();
            editor.putString("EMAIL", email);

            editor.commit();

            Toast.makeText(Info.this, "Đã lưu thông tin", Toast.LENGTH_SHORT).show();
        }
    }
}
