package com.ppc.tokokomputer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

public class AccountActivity extends AppCompatActivity {
    private EditText etName, etPhone, etAddress;
    private MaterialButton btnSave;
    private ImageView ivProfile;
    private SharedPreferences sharedPreferences;
    private TextView tvMemberSince, tvTotalPurchase, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        // Inisialisasi view
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etAddress = findViewById(R.id.et_address);
        btnSave = findViewById(R.id.btn_save);
        ivProfile = findViewById(R.id.iv_profile);

        // Temukan TextView untuk info akun
        tvMemberSince = findViewById(R.id.tv_member_since);
        tvTotalPurchase = findViewById(R.id.tv_total_purchase);
        tvStatus = findViewById(R.id.tv_status);

        // Load data user
        loadUserData();

        // Setup button listeners
        btnSave.setOnClickListener(v -> saveUserData());

        // Tombol ubah foto
        findViewById(R.id.btn_change_photo).setOnClickListener(v -> {
            Toast.makeText(this, "Fitur ubah foto akan datang", Toast.LENGTH_SHORT).show();
        });

        // Load gambar profil
        Glide.with(this)
                .load(R.drawable.ic_account)
                .circleCrop()
                .into(ivProfile);
    }

    private void loadUserData() {
        String name = sharedPreferences.getString("user_name", "");
        String phone = sharedPreferences.getString("user_phone", "");
        String address = sharedPreferences.getString("user_address", "Belum diisi");

        etName.setText(name);
        etPhone.setText(phone);
        etAddress.setText(address);

        // Set info akun
        if (tvMemberSince != null && tvTotalPurchase != null && tvStatus != null) {
            tvMemberSince.setText("Member Sejak: Januari 2024");
            tvTotalPurchase.setText("Total Pembelian: 5 Laptop");
            tvStatus.setText("Status: Member Gold");
        }
    }

    private void saveUserData() {
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        if (name.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Nama dan nomor HP wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phone.length() < 10) {
            Toast.makeText(this, "Nomor HP minimal 10 digit", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simpan ke SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_name", name);
        editor.putString("user_phone", phone);
        editor.putString("user_address", address);
        editor.apply();

        Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
    }

    // Method untuk tombol back di XML
    public void onBackClick(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}