package com.ppc.tokokomputer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class AccountActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 101;
    private EditText etName, etPhone, etAddress;
    private ImageView ivProfile;
    private TextView tvMemberSince, tvTotalPurchase;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean isDarkMode = sharedPreferences.getBoolean("dark_mode", false);
        setTheme(isDarkMode ? R.style.Theme_TokoKomputer_Dark : R.style.Theme_TokoKomputer);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ivProfile = findViewById(R.id.iv_profile);
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etAddress = findViewById(R.id.et_address);
        tvMemberSince = findViewById(R.id.tv_member_since);
        tvTotalPurchase = findViewById(R.id.tv_total_purchase);

        loadData();

        // Fitur Ganti Foto: Klik pada Ikon/Foto Profil
        ivProfile.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        });

        findViewById(R.id.btn_save).setOnClickListener(v -> saveData());
    }

    private void loadData() {
        etName.setText(sharedPreferences.getString("user_name", ""));
        etPhone.setText(sharedPreferences.getString("user_phone", ""));
        etAddress.setText(sharedPreferences.getString("user_address", ""));

        // Menampilkan Tanggal Member (Data dari LoginActivity)
        String date = sharedPreferences.getString("member_since", "Baru Bergabung");
        tvMemberSince.setText("Member Sejak: " + date);

        // Menampilkan Total Item di Keranjang
        int cartCount = CartManager.getInstance(this).getCartItemCount();
        tvTotalPurchase.setText("Laptop di Keranjang: " + cartCount);

        // Load Foto Profil
        String imageUri = sharedPreferences.getString("profile_image", null);
        if (imageUri != null) {
            Glide.with(this).load(Uri.parse(imageUri)).circleCrop().into(ivProfile);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE_REQUEST && data != null) {
            Uri imageUri = data.getData();
            // Simpan URI foto ke SharedPreferences
            sharedPreferences.edit().putString("profile_image", imageUri.toString()).apply();
            // Tampilkan foto dengan Glide
            Glide.with(this).load(imageUri).circleCrop().into(ivProfile);
            Toast.makeText(this, "Foto profil diperbarui", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveData() {
        sharedPreferences.edit()
                .putString("user_name", etName.getText().toString())
                .putString("user_phone", etPhone.getText().toString())
                .putString("user_address", etAddress.getText().toString())
                .apply();
        Toast.makeText(this, "Profil disimpan!", Toast.LENGTH_SHORT).show();
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
}