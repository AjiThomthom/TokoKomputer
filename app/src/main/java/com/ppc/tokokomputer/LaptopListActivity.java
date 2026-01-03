package com.ppc.tokokomputer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class LaptopListActivity extends AppCompatActivity {
    private RecyclerView rvLaptops;
    private LaptopAdapter laptopAdapter;
    private ArrayList<Laptop> laptopList;
    private String brandFilter;
    private boolean isDarkMode;
    private Spinner spinnerSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 1. Ambil data tema dan terapkan SEBELUM super.onCreate
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        isDarkMode = sharedPreferences.getBoolean("dark_mode", false);
        setTheme(isDarkMode ? R.style.Theme_TokoKomputer_Dark : R.style.Theme_TokoKomputer);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop_list);

        // 2. Inisialisasi Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // 3. Inisialisasi View
        TextView tvTitle = findViewById(R.id.tv_title);
        rvLaptops = findViewById(R.id.rv_laptops);
        spinnerSort = findViewById(R.id.spinner_sort);

        // 4. Logika Filter Brand (Fitur Lihat Semua)
        brandFilter = getIntent().getStringExtra("brand");
        if (brandFilter != null && !brandFilter.isEmpty()) {
            tvTitle.setText("Laptop " + brandFilter);
            laptopList = new ArrayList<>(LaptopData.getLaptopsByBrand(brandFilter));
        } else {
            tvTitle.setText("Semua Laptop");
            laptopList = new ArrayList<>(LaptopData.getLaptopList());
        }

        // 5. Setup RecyclerView
        setupRecyclerView();

        // 6. Setup Spinner dengan Fix Kontras Teks
        setupSortingSpinner();
    }

    private void setupRecyclerView() {
        rvLaptops.setLayoutManager(new GridLayoutManager(this, 2));
        laptopAdapter = new LaptopAdapter(this, laptopList, laptop -> {
            Intent intent = new Intent(this, LaptopDetailActivity.class);
            intent.putExtra("laptop", laptop);
            startActivity(intent);
        });
        rvLaptops.setAdapter(laptopAdapter);
    }

    private void setupSortingSpinner() {
        String[] options = {"Urutkan: Terbaru", "Harga: Rendah - Tinggi", "Harga: Tinggi - Rendah", "Rating Tertinggi", "Stok Terbanyak"};

        // Custom Adapter untuk memperbaiki warna teks di Mode Gelap
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view;
                // Teks yang tampil sebelum diklik
                tv.setTextColor(isDarkMode ? 0xFFFFFFFF : 0xFF000000);
                return view;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                // Teks di dalam daftar dropdown
                tv.setTextColor(isDarkMode ? 0xFFFFFFFF : 0xFF000000);
                // Background dropdown agar terlihat
                view.setBackgroundColor(isDarkMode ? 0xFF1E1E1E : 0xFFFFFFFF);
                return view;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adapter);

        // Listener fitur Sorting
        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                applySort(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void applySort(int position) {
        if (laptopList == null || laptopList.isEmpty()) return;

        switch (position) {
            case 1: // Harga: Rendah - Tinggi
                Collections.sort(laptopList, (l1, l2) -> Integer.compare(l1.getPrice(), l2.getPrice()));
                break;
            case 2: // Harga: Tinggi - Rendah
                Collections.sort(laptopList, (l1, l2) -> Integer.compare(l2.getPrice(), l1.getPrice()));
                break;
            case 3: // Rating
                Collections.sort(laptopList, (l1, l2) -> Double.compare(l2.getRating(), l1.getRating()));
                break;
            case 4: // Stok
                Collections.sort(laptopList, (l1, l2) -> Integer.compare(l2.getStock(), l1.getStock()));
                break;
            default: // Default/Terbaru
                // Tidak perlu sort
                break;
        }
        laptopAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}