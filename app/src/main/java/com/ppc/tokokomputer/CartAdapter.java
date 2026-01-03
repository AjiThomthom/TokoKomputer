package com.ppc.tokokomputer;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    private ArrayList<CartItem> cartItems;
    private CartUpdateListener listener;
    private boolean isDarkMode;

    public interface CartUpdateListener {
        void onCartUpdated();
        void onItemRemoved(int position);
    }

    public CartAdapter(Context context, ArrayList<CartItem> cartItems, CartUpdateListener listener) {
        this.context = context;
        this.cartItems = cartItems;
        this.listener = listener;

        // Ambil status dark mode dari SharedPreferences
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        this.isDarkMode = sharedPref.getBoolean("dark_mode", false);
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        Laptop laptop = cartItem.getLaptop();

        // --- SOLUSI WARNA MERAH UNTUK KONTROL ---
        int redColor = Color.RED; // Warna merah solid
        int textColor = isDarkMode ? Color.WHITE : Color.BLACK;

        // Teks model tetap mengikuti tema (Putih/Hitam) agar rapi
        holder.tvModel.setTextColor(textColor);

        // MENGGANTI TOMBOL + , - DAN ANGKA MENJADI MERAH
        holder.tvQuantity.setTextColor(redColor);
        holder.btnIncrease.setColorFilter(redColor);
        holder.btnDecrease.setColorFilter(redColor);

        // Tombol hapus tetap merah (bisa gunakan warna merah yang berbeda jika ingin)
        holder.btnDelete.setColorFilter(Color.parseColor("#D32F2F"));

        // --- DATA BINDING ---
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String hargaSatuan = formatRupiah.format(laptop.getPrice());
        String hargaTotal = formatRupiah.format(cartItem.getTotalPrice());

        holder.tvVendor.setText(laptop.getVendor());
        holder.tvModel.setText(laptop.getModel());
        holder.tvPrice.setText(hargaSatuan + " × " + cartItem.getQuantity() + " = " + hargaTotal);
        holder.tvQuantity.setText(String.valueOf(cartItem.getQuantity()));

        // --- LOAD GAMBAR ---
        Glide.with(context)
                .load(laptop.getImageUrl())
                .placeholder(R.drawable.ic_laptop_placeholder)
                .error(R.drawable.ic_error)
                .into(holder.ivLaptop);

        // --- LOGIKA TOMBOL ---
        holder.btnIncrease.setOnClickListener(v -> {
            int currentPos = holder.getAdapterPosition();
            if (currentPos != RecyclerView.NO_POSITION) {
                CartItem item = cartItems.get(currentPos);
                item.increaseQuantity();

                holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
                holder.tvPrice.setText(hargaSatuan + " × " + item.getQuantity() + " = " +
                        formatRupiah.format(item.getTotalPrice()));

                CartManager.getInstance(context).updateQuantity(currentPos, item.getQuantity());
                if (listener != null) listener.onCartUpdated();
            }
        });

        holder.btnDecrease.setOnClickListener(v -> {
            int currentPos = holder.getAdapterPosition();
            if (currentPos != RecyclerView.NO_POSITION) {
                CartItem item = cartItems.get(currentPos);
                if (item.getQuantity() > 1) {
                    item.decreaseQuantity();

                    holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
                    holder.tvPrice.setText(hargaSatuan + " × " + item.getQuantity() + " = " +
                            formatRupiah.format(item.getTotalPrice()));

                    CartManager.getInstance(context).updateQuantity(currentPos, item.getQuantity());
                    if (listener != null) listener.onCartUpdated();
                }
            }
        });

        holder.btnDelete.setOnClickListener(v -> {
            int currentPos = holder.getAdapterPosition();
            if (currentPos != RecyclerView.NO_POSITION) {
                CartManager.getInstance(context).removeFromCart(currentPos);
                cartItems.remove(currentPos);
                notifyItemRemoved(currentPos);
                if (listener != null) {
                    listener.onItemRemoved(currentPos);
                    listener.onCartUpdated();
                }
                Toast.makeText(context, "Item dihapus", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public void updateCartItems(ArrayList<CartItem> newItems) {
        this.cartItems = newItems;
        notifyDataSetChanged();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLaptop, btnIncrease, btnDecrease, btnDelete;
        TextView tvVendor, tvModel, tvPrice, tvQuantity;

        public CartViewHolder(@NonNull View itemView) {
            // PERBAIKAN: Gunakan itemView, bukan view
            super(itemView);

            ivLaptop = itemView.findViewById(R.id.iv_laptop);
            btnIncrease = itemView.findViewById(R.id.btn_increase);
            btnDecrease = itemView.findViewById(R.id.btn_decrease);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            tvVendor = itemView.findViewById(R.id.tv_vendor);
            tvModel = itemView.findViewById(R.id.tv_model);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
        }
    }
}