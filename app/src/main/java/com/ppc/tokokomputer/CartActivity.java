package com.ppc.tokokomputer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import android.view.View;

public class CartActivity extends AppCompatActivity implements CartAdapter.CartUpdateListener {
    private RecyclerView rvCartItems;
    private LinearLayout emptyState, cartContent;
    private TextView tvSubtotal, tvTax, tvTotal, tvItemCount;
    private CartAdapter cartAdapter;
    private ArrayList<CartItem> cartItems;
    private CartManager cartManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Initialize views
        initViews();

        // Initialize cart manager
        cartManager = CartManager.getInstance(this);
        cartItems = cartManager.getCartItems();

        // Setup RecyclerView
        setupRecyclerView();

        // Update cart summary
        updateCartSummary();

        // Check empty state
        checkEmptyState();

        // Setup checkout button
        findViewById(R.id.btn_checkout).setOnClickListener(v -> {
            if (cartItems.isEmpty()) {
                Toast.makeText(this, "Keranjang masih kosong", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Fitur checkout akan segera hadir!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        rvCartItems = findViewById(R.id.rv_cart_items);
        emptyState = findViewById(R.id.empty_state);
        cartContent = findViewById(R.id.cart_content);
        tvSubtotal = findViewById(R.id.tv_subtotal);
        tvTax = findViewById(R.id.tv_tax);
        tvTotal = findViewById(R.id.tv_total);

        // Setup empty state - langsung set click listener ke emptyState
        emptyState.setOnClickListener(v -> {
            finish(); // Kembali ke halaman sebelumnya
        });
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvCartItems.setLayoutManager(layoutManager);

        cartAdapter = new CartAdapter(this, cartItems, this);
        rvCartItems.setAdapter(cartAdapter);
    }

    private void updateCartSummary() {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        int subtotal = cartManager.getCartTotalPrice();
        double tax = subtotal * 0.11; // 11% PPN
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
        updateCartSummary();
        checkEmptyState();
    }

    @Override
    public void onItemRemoved(int position) {
        // Item already removed in adapter
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh cart data
        cartItems = cartManager.getCartItems();
        cartAdapter = new CartAdapter(this, cartItems, this);
        rvCartItems.setAdapter(cartAdapter);
        updateCartSummary();
        checkEmptyState();
    }
}