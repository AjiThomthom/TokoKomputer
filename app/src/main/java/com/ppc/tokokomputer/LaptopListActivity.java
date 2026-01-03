package com.ppc.tokokomputer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LaptopListActivity extends AppCompatActivity {
    private RecyclerView rvLaptops;
    private LaptopAdapter laptopAdapter;
    private ArrayList<Laptop> laptopList;
    private String brandFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_list);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Daftar Laptop");
        }

        // Ambil filter brand dari intent (jika ada)
        brandFilter = getIntent().getStringExtra("brand");

        // Inisialisasi view
        TextView tvTitle = findViewById(R.id.tv_title);
        rvLaptops = findViewById(R.id.rv_laptops);

        // Set judul
        if (brandFilter != null && !brandFilter.isEmpty()) {
            tvTitle.setText("Laptop " + brandFilter);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Laptop " + brandFilter);
            }
        } else {
            tvTitle.setText("Semua Laptop");
        }

        // Load data laptop
        loadLaptopData();

        // Setup RecyclerView dengan 2 kolom
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvLaptops.setLayoutManager(layoutManager);

        // Setup adapter
        laptopAdapter = new LaptopAdapter(this, laptopList, laptop -> {
            // Navigate ke detail laptop
            Intent intent = new Intent(LaptopListActivity.this, LaptopDetailActivity.class);
            intent.putExtra("laptop", laptop);
            startActivity(intent);
        });

        rvLaptops.setAdapter(laptopAdapter);
    }

    private void loadLaptopData() {
        if (brandFilter != null && !brandFilter.isEmpty()) {
            laptopList = LaptopData.getLaptopsByBrand(brandFilter);
        } else {
            laptopList = LaptopData.getLaptopList();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}