package com.ppc.tokokomputer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.Locale;

public class LaptopDetailActivity extends AppCompatActivity {
    private ImageView ivLaptopDetail;
    private TextView tvDetailVendor, tvDetailModel, tvRatingDetail, tvStockDetail, tvDetailPrice;
    private TextView tvProcessor, tvRam, tvStorage, tvDisplay, tvGraphics, tvOs, tvBattery;
    private TextView tvWeight, tvYear, tvPort, tvConnectivity, tvDetailDescription;
    private RatingBar ratingBarDetail;
    private Button btnAddToCart, btnBuyNow;
    private Laptop laptop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_detail);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Dapatkan data laptop dari intent
        laptop = (Laptop) getIntent().getSerializableExtra("laptop");

        if (laptop == null) {
            Toast.makeText(this, "Data laptop tidak ditemukan", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Inisialisasi semua view
        initViews();

        // Tampilkan data laptop
        displayLaptopData();

        // Setup button listeners
        setupButtonListeners();
    }

    private void initViews() {
        ivLaptopDetail = findViewById(R.id.iv_laptop_detail);
        tvDetailVendor = findViewById(R.id.tv_detail_vendor);
        tvDetailModel = findViewById(R.id.tv_detail_model);
        ratingBarDetail = findViewById(R.id.rating_bar_detail);
        tvRatingDetail = findViewById(R.id.tv_rating_detail);
        tvStockDetail = findViewById(R.id.tv_stock_detail);
        tvDetailPrice = findViewById(R.id.tv_detail_price);

        // Spesifikasi
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

        // Buttons
        btnAddToCart = findViewById(R.id.btn_add_to_cart);
        btnBuyNow = findViewById(R.id.btn_buy_now);
    }

    private void displayLaptopData() {
        // Format harga ke Rupiah
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String harga = formatRupiah.format(laptop.getPrice());

        // Set data dasar
        tvDetailVendor.setText(laptop.getVendor());
        tvDetailModel.setText(laptop.getModel());
        ratingBarDetail.setRating((float) laptop.getRating());
        tvRatingDetail.setText(String.format("%.1f/5.0", laptop.getRating()));
        tvStockDetail.setText("Stok: " + laptop.getStock());
        tvDetailPrice.setText(harga);

        // Set spesifikasi
        tvProcessor.setText(laptop.getProcessor());
        tvRam.setText(laptop.getRam());
        tvStorage.setText(laptop.getStorage());
        tvDisplay.setText(laptop.getDisplay());
        tvGraphics.setText(laptop.getGraphics());
        tvOs.setText(laptop.getOs());
        tvBattery.setText(laptop.getBattery());
        tvWeight.setText(laptop.getWeight());
        tvYear.setText(laptop.getYear());
        tvPort.setText(laptop.getPort());
        tvConnectivity.setText(laptop.getConnectivity());
        tvDetailDescription.setText(laptop.getDescription());

        // Load gambar
        Glide.with(this)
                .load(R.drawable.ic_laptop_placeholder)
                .placeholder(R.drawable.ic_laptop_placeholder)
                .error(R.drawable.ic_error)
                .into(ivLaptopDetail);
    }

    private void setupButtonListeners() {
        btnAddToCart.setOnClickListener(v -> {
            Toast.makeText(this, laptop.getModel() + " ditambahkan ke keranjang", Toast.LENGTH_SHORT).show();
        });

        btnBuyNow.setOnClickListener(v -> {
            Toast.makeText(this, "Membeli " + laptop.getModel(), Toast.LENGTH_SHORT).show();
            // Di sini bisa diarahkan ke halaman checkout
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}