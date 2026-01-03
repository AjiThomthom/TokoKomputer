package com.ppc.tokokomputer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etPhone, etName;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Cek jika sudah login
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }

        // Inisialisasi view
        etPhone = findViewById(R.id.et_phone);
        etName = findViewById(R.id.et_name);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> {
            String phone = etPhone.getText().toString().trim();
            String name = etName.getText().toString().trim();

            if (phone.isEmpty() || name.isEmpty()) {
                Toast.makeText(this, "Harap isi nomor HP dan nama lengkap", Toast.LENGTH_SHORT).show();
            } else if (phone.length() < 10) {
                Toast.makeText(this, "Nomor HP minimal 10 digit", Toast.LENGTH_SHORT).show();
            } else {
                // Simpan data ke SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user_name", name);
                editor.putString("user_phone", phone);
                editor.putBoolean("isLoggedIn", true);
                editor.apply();

                // Pindah ke MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}