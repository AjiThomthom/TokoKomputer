package com.ppc.tokokomputer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CartActivity extends AppCompatActivity implements CartAdapter.CartUpdateListener {
    private RecyclerView rvCartItems;
    private LinearLayout emptyState, cartContent;
    private TextView tvSubtotal, tvTax, tvTotal;
    private CartAdapter cartAdapter;
    private ArrayList<CartItem> cartItems;
    private CartManager cartManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Handle Tema
        SharedPreferences sharedPref = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean isDarkMode = sharedPref.getBoolean("dark_mode", false);
        setTheme(isDarkMode ? R.style.Theme_TokoKomputer_Dark : R.style.Theme_TokoKomputer);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initViews();

        cartManager = CartManager.getInstance(this);
        cartItems = new ArrayList<>(cartManager.getCartItems());

        rvCartItems.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this, cartItems, this);
        rvCartItems.setAdapter(cartAdapter);

        updateCartSummary();
        checkEmptyState();
    }

    private void initViews() {
        rvCartItems = findViewById(R.id.rv_cart_items);
        emptyState = findViewById(R.id.empty_state);
        cartContent = findViewById(R.id.cart_content);
        tvSubtotal = findViewById(R.id.tv_subtotal);
        tvTax = findViewById(R.id.tv_tax);
        tvTotal = findViewById(R.id.tv_total);

        // FITUR: Tombol Mulai Belanja
        MaterialButton btnShopNow = findViewById(R.id.btn_shop_now);
        if (btnShopNow != null) {
            btnShopNow.setOnClickListener(v -> {
                Intent intent = new Intent(CartActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("SHOW_WELCOME_MESSAGE", true);
                startActivity(intent);
                finish();
            });
        }

        findViewById(R.id.btn_checkout).setOnClickListener(v -> {
            Toast.makeText(this, "Pesanan Berhasil!", Toast.LENGTH_LONG).show();
        });
    }

    private void updateCartSummary() {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        int subtotal = cartManager.getCartTotalPrice();
        double tax = subtotal * 0.11;
        double total = subtotal + tax;

        tvSubtotal.setText(formatRupiah.format(subtotal));
        tvTax.setText(formatRupiah.format((int) tax));
        tvTotal.setText(formatRupiah.format((int) total));
    }

    private void checkEmptyState() {
        if (cartItems.isEmpty()) {
            emptyState.setVisibility(View.VISIBLE);
            cartContent.setVisibility(View.GONE);
        } else {
            emptyState.setVisibility(View.GONE);
            cartContent.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onCartUpdated() {
        cartItems = new ArrayList<>(cartManager.getCartItems());
        cartAdapter.updateCartItems(cartItems);
        updateCartSummary();
        checkEmptyState();
    }

    @Override
    public void onItemRemoved(int position) {}

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}