package com.ppc.tokokomputer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private RecyclerView rvPromo;
    private TextView tvUserName;
    private LaptopAdapter promoAdapter;
    private ArrayList<Laptop> promoList;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cek login status
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        if (!sharedPreferences.getBoolean("isLoggedIn", false)) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        // Inisialisasi view
        initViews();

        // Setup toolbar
        setupToolbar();

        // Setup drawer
        setupDrawer();

        // Set nama user
        setupUserInfo();

        // Setup RecyclerView untuk promo
        setupPromoRecyclerView();

        // Setup click listener untuk brand cards
        setupBrandCards();
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        rvPromo = findViewById(R.id.rv_promo);
        tvUserName = findViewById(R.id.tv_user_name_main);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Toko Laptop PPC");
        }
    }

    private void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Update header dengan data user
        View headerView = navigationView.getHeaderView(0);
        TextView tvNavName = headerView.findViewById(R.id.tv_user_name);
        TextView tvNavPhone = headerView.findViewById(R.id.tv_user_phone);

        String userName = sharedPreferences.getString("user_name", "User Name");
        String userPhone = sharedPreferences.getString("user_phone", "0812-3456-7890");

        tvNavName.setText(userName);
        tvNavPhone.setText(userPhone);
    }

    private void setupUserInfo() {
        String userName = sharedPreferences.getString("user_name", "Pengguna");
        tvUserName.setText("Halo, " + userName + "!");
    }

    private void setupPromoRecyclerView() {
        // Ambil data promo
        promoList = LaptopData.getPromoLaptops();

        // Setup layout manager horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        rvPromo.setLayoutManager(layoutManager);

        // Setup adapter
        promoAdapter = new LaptopAdapter(this, promoList, laptop -> {
            Intent intent = new Intent(MainActivity.this, LaptopDetailActivity.class);
            intent.putExtra("laptop", laptop);
            startActivity(intent);
        });

        rvPromo.setAdapter(promoAdapter);
    }

    private void setupBrandCards() {
        // Setup click listener untuk setiap brand card
        int[] brandCardIds = {
                R.id.card_lenovo, R.id.card_asus, R.id.card_acer,
                R.id.card_dell, R.id.card_hp, R.id.card_apple
        };

        String[] brands = {
                "Lenovo", "ASUS", "Acer", "Dell", "HP", "Apple"
        };

        for (int i = 0; i < brandCardIds.length; i++) {
            final String brand = brands[i];
            findViewById(brandCardIds[i]).setOnClickListener(v -> {
                openLaptopListByBrand(brand);
            });
        }
    }

    private void openLaptopListByBrand(String brand) {
        Intent intent = new Intent(this, LaptopListActivity.class);
        intent.putExtra("brand", brand);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_cart) {
            startActivity(new Intent(this, CartActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_account_info) {
            startActivity(new Intent(this, AccountActivity.class));
        } else if (id == R.id.nav_cart) {
            startActivity(new Intent(this, CartActivity.class));
        } else if (id == R.id.nav_theme) {
            Toast.makeText(this, "Fitur ubah tema akan datang", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            logoutUser();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logoutUser() {
        // Clear shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        // Kembali ke login
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}