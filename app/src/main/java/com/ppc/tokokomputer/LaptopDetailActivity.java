package com.ppc.tokokomputer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import java.text.NumberFormat;
import java.util.Locale;

public class LaptopDetailActivity extends AppCompatActivity {
    private ImageView ivLaptopDetail;
    private TextView tvDetailVendor, tvDetailModel, tvRatingDetail, tvStockDetail, tvDetailPrice;
    private TextView tvProcessor, tvRam, tvStorage, tvDisplay, tvGraphics, tvOs, tvBattery;
    private TextView tvWeight, tvYear, tvPort, tvConnectivity, tvDetailDescription;
    private RatingBar ratingBarDetail;
    private Button btnAddToCart, btnBuyNow;

    // Pastikan objek laptop ini terisi
    private Laptop laptop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 1. Cek Tema
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean isDarkMode = sharedPreferences.getBoolean("dark_mode", false);
        if (isDarkMode) {
            setTheme(R.style.Theme_TokoKomputer_Dark);
        } else {
            setTheme(R.style.Theme_TokoKomputer);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_detail);

        // 2. AMBIL DATA DARI INTENT (Penting agar data tidak nol)
        if (getIntent() != null) {
            laptop = getIntent().getParcelableExtra("laptop");
        }

        // 3. Inisialisasi Toolbar & Views
        setupToolbar();
        initializeViews();

        // 4. Tampilkan Data
        if (laptop != null) {
            displayLaptopDetails();
        } else {
            Toast.makeText(this, "Data laptop tidak ditemukan", Toast.LENGTH_SHORT).show();
            finish(); // Tutup activity jika data kosong
        }

        setupButtonListeners();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Detail Laptop");
        }
    }

    private void initializeViews() {
        ivLaptopDetail = findViewById(R.id.iv_laptop_detail);
        tvDetailVendor = findViewById(R.id.tv_detail_vendor);
        tvDetailModel = findViewById(R.id.tv_detail_model);
        tvRatingDetail = findViewById(R.id.tv_rating_detail);
        tvStockDetail = findViewById(R.id.tv_stock_detail);
        tvDetailPrice = findViewById(R.id.tv_detail_price);
        ratingBarDetail = findViewById(R.id.rating_bar_detail);

        tvProcessor = findViewById(R.id.tv_processor);
        tvRam = findViewById(R.id.tv_ram);
        tvStorage = findViewById(R.id.tv_storage);
        tvDisplay = findViewById(R.id.tv_display);
        tvGraphics = findViewById(R.id.tv_graphics);
        tvOs = findViewById(R.id.tv_os);
        tvBattery = findViewById(R.id.tv_battery);
        tvWeight = findViewById(R.id.tv_weight);
        tvYear = findViewById(R.id.tv_year);
        tvPort = findViewById(R.id.tv_port);
        tvConnectivity = findViewById(R.id.tv_connectivity);
        tvDetailDescription = findViewById(R.id.tv_detail_description);

        btnAddToCart = findViewById(R.id.btn_add_to_cart);
        btnBuyNow = findViewById(R.id.btn_buy_now);
    }

    private void displayLaptopDetails() {
        // Tampilkan Teks
        tvDetailVendor.setText(laptop.getVendor());
        tvDetailModel.setText(laptop.getModel());

        // Format Harga (Cek jika harga > 0)
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        tvDetailPrice.setText(format.format(laptop.getPrice()));

        tvRatingDetail.setText(String.valueOf(laptop.getRating()));
        ratingBarDetail.setRating((float) laptop.getRating());
        tvStockDetail.setText("Stok: " + laptop.getStock());

        // Deskripsi & Spek
        tvDetailDescription.setText(laptop.getDescription());
        tvProcessor.setText(laptop.getProcessor());
        tvRam.setText(laptop.getRam());
        tvStorage.setText(laptop.getStorage());
        tvDisplay.setText(laptop.getDisplay());
        tvGraphics.setText(laptop.getGraphics());
        tvOs.setText(laptop.getOs());
        tvBattery.setText(laptop.getBattery());
        tvWeight.setText(laptop.getWeight());
        tvYear.setText(String.valueOf(laptop.getYear()));
        tvPort.setText(laptop.getPort());
        tvConnectivity.setText(laptop.getConnectivity());

        // --- BAGIAN GAMBAR ---
        // Set warna background
        int backgroundColor = ImageHelper.getLaptopBackgroundColor(laptop.getVendor());
        ivLaptopDetail.setBackgroundColor(ContextCompat.getColor(this, backgroundColor));

        // Load Gambar via ImageHelper
        ImageHelper.loadLaptopImage(this, ivLaptopDetail, laptop);
    }

    private void setupButtonListeners() {
        btnAddToCart.setOnClickListener(v -> {
            if (laptop != null) {
                CartManager.getInstance(this).addToCart(laptop);
                Toast.makeText(this, laptop.getModel() + " ditambahkan ke keranjang", Toast.LENGTH_SHORT).show();
                AnimHelper.bounce(btnAddToCart);
            }
        });

        btnBuyNow.setOnClickListener(v -> {
            if (laptop != null) {
                CartManager.getInstance(this).addToCart(laptop);
                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}