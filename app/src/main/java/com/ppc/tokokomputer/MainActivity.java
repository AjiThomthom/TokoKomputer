package com.ppc.tokokomputer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
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
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private RecyclerView rvBrands, rvBestSellers;
    private TextView tvUserName;
    private BrandAdapter brandAdapter;
    private LaptopAdapter bestSellerAdapter;
    private List<Brand> brandList;
    private ArrayList<Laptop> bestSellerList;
    private SharedPreferences sharedPreferences;
    private boolean isDarkMode = false;
    private MenuItem cartMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cek tema sebelum setContentView
        applyTheme();

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

        // Setup Brand RecyclerView
        setupBrandRecyclerView();

        // Setup Best Sellers RecyclerView
        setupBestSellersRecyclerView();

        findViewById(R.id.btn_see_all).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LaptopListActivity.class);
            intent.putExtra("brand", ""); // String kosong berarti "Semua"
            startActivity(intent);
        });
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        rvBrands = findViewById(R.id.rv_brands);
        rvBestSellers = findViewById(R.id.rv_best_sellers);
        tvUserName = findViewById(R.id.tv_user_name_main);
    }

    private void applyTheme() {
        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        isDarkMode = prefs.getBoolean("dark_mode", false);

        if (isDarkMode) {
            setTheme(R.style.Theme_TokoKomputer_Dark);
        } else {
            setTheme(R.style.Theme_TokoKomputer);
        }
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

    private void setupBrandRecyclerView() {
        // Inisialisasi data brand
        brandList = new ArrayList<>();

        // Tambahkan semua brand dengan logo dan warna
        brandList.add(new Brand("Lenovo", R.drawable.ic_lenovo_logo, getColorCompat(R.color.lenovo_color)));
        brandList.add(new Brand("ASUS", R.drawable.ic_asus_logo, getColorCompat(R.color.asus_color)));
        brandList.add(new Brand("Apple", R.drawable.ic_apple_logo, getColorCompat(R.color.apple_color)));
        brandList.add(new Brand("Dell", R.drawable.ic_dell_logo, getColorCompat(R.color.dell_color)));
        brandList.add(new Brand("HP", R.drawable.ic_hp_logo, getColorCompat(R.color.hp_color)));
        brandList.add(new Brand("Acer", R.drawable.ic_acer_logo, getColorCompat(R.color.acer_color)));
        brandList.add(new Brand("MSI", R.drawable.ic_msi_logo, getColorCompat(R.color.msi_color)));
        brandList.add(new Brand("Samsung", R.drawable.ic_samsung_logo, getColorCompat(R.color.samsung_color)));
        brandList.add(new Brand("Microsoft", R.drawable.ic_microsoft_logo, getColorCompat(R.color.microsoft_color)));
        brandList.add(new Brand("Razer", R.drawable.ic_razer_logo, getColorCompat(R.color.razer_color)));

        // Setup horizontal RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        rvBrands.setLayoutManager(layoutManager);

        // Setup adapter
        brandAdapter = new BrandAdapter(this, brandList, brandName -> {
            openLaptopListByBrand(brandName);
        });

        rvBrands.setAdapter(brandAdapter);

        // Tambahkan item decoration untuk spacing
        rvBrands.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view);
                int totalCount = parent.getAdapter().getItemCount();

                if (position == 0) {
                    outRect.left = 16;
                } else {
                    outRect.left = 8;
                }

                if (position == totalCount - 1) {
                    outRect.right = 16;
                } else {
                    outRect.right = 8;
                }

                outRect.top = 8;
                outRect.bottom = 8;
            }
        });
    }

    private void setupBestSellersRecyclerView() {
        // Ambil data laptop terlaris
        bestSellerList = LaptopData.getBestSellingLaptops();

        // Setup horizontal RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        rvBestSellers.setLayoutManager(layoutManager);

        // Setup adapter
        bestSellerAdapter = new LaptopAdapter(this, bestSellerList, laptop -> {
            // Navigate ke detail laptop
            Intent intent = new Intent(MainActivity.this, LaptopDetailActivity.class);
            intent.putExtra("laptop", laptop);
            startActivity(intent);
        });

        rvBestSellers.setAdapter(bestSellerAdapter);

        // Tambahkan item decoration untuk spacing
        rvBestSellers.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view);
                int totalCount = parent.getAdapter().getItemCount();

                if (position == 0) {
                    outRect.left = 16;
                } else {
                    outRect.left = 8;
                }

                if (position == totalCount - 1) {
                    outRect.right = 16;
                } else {
                    outRect.right = 8;
                }

                outRect.top = 8;
                outRect.bottom = 8;
            }
        });
    }

    // Helper method untuk get color compatible
    private int getColorCompat(int colorResId) {
        return getResources().getColor(colorResId, getTheme());
    }

    private void openLaptopListByBrand(String brand) {
        Intent intent = new Intent(this, LaptopListActivity.class);
        intent.putExtra("brand", brand);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        cartMenuItem = menu.findItem(R.id.menu_cart);

        // Update cart badge
        updateCartBadge();

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
            toggleDarkMode();
        } else if (id == R.id.nav_logout) {
            logoutUser();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void toggleDarkMode() {
        isDarkMode = !isDarkMode;

        // Simpan preferensi
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("dark_mode", isDarkMode);
        editor.apply();

        // Restart activity untuk apply theme
        recreate();
        Toast.makeText(this, isDarkMode ? "Mode Gelap Diaktifkan" : "Mode Terang Diaktifkan",
                Toast.LENGTH_SHORT).show();
    }

    private void updateCartBadge() {
        // Cara sederhana: update title dengan jumlah item
        int cartCount = CartManager.getInstance(this).getCartItemCount();
        if (cartCount > 0 && cartMenuItem != null) {
            cartMenuItem.setTitle("Keranjang (" + cartCount + ")");
        } else if (cartMenuItem != null) {
            cartMenuItem.setTitle("Keranjang");
        }
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
    protected void onResume() {
        super.onResume();
        // Update cart badge setiap kali kembali ke MainActivity
        updateCartBadge();
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