package com.ppc.tokokomputer;

import android.content.Context;
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

    public interface CartUpdateListener {
        void onCartUpdated();
        void onItemRemoved(int position);
    }

    public CartAdapter(Context context, ArrayList<CartItem> cartItems, CartUpdateListener listener) {
        this.context = context;
        this.cartItems = cartItems;
        this.listener = listener;
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

        // Format harga
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String hargaSatuan = formatRupiah.format(laptop.getPrice());
        String hargaTotal = formatRupiah.format(cartItem.getTotalPrice());

        // Set data
        holder.tvVendor.setText(laptop.getVendor());
        holder.tvModel.setText(laptop.getModel());
        holder.tvPrice.setText(hargaSatuan + " × " + cartItem.getQuantity() + " = " + hargaTotal);
        holder.tvQuantity.setText(String.valueOf(cartItem.getQuantity()));

        // Load gambar
        Glide.with(context)
                .load(R.drawable.ic_laptop_placeholder)
                .placeholder(R.drawable.ic_laptop_placeholder)
                .error(R.drawable.ic_error)
                .into(holder.ivLaptop);

        // Quantity controls
        holder.btnIncrease.setOnClickListener(v -> {
            cartItem.increaseQuantity();
            holder.tvQuantity.setText(String.valueOf(cartItem.getQuantity()));
            holder.tvPrice.setText(hargaSatuan + " × " + cartItem.getQuantity() + " = " +
                    formatRupiah.format(cartItem.getTotalPrice()));

            // Update cart manager
            CartManager.getInstance(context).updateQuantity(position, cartItem.getQuantity());

            if (listener != null) {
                listener.onCartUpdated();
            }
        });

        holder.btnDecrease.setOnClickListener(v -> {
            if (cartItem.getQuantity() > 1) {
                cartItem.decreaseQuantity();
                holder.tvQuantity.setText(String.valueOf(cartItem.getQuantity()));
                holder.tvPrice.setText(hargaSatuan + " × " + cartItem.getQuantity() + " = " +
                        formatRupiah.format(cartItem.getTotalPrice()));

                // Update cart manager
                CartManager.getInstance(context).updateQuantity(position, cartItem.getQuantity());

                if (listener != null) {
                    listener.onCartUpdated();
                }
            }
        });

        // Delete button
        holder.btnDelete.setOnClickListener(v -> {
            CartManager.getInstance(context).removeFromCart(position);
            cartItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());

            if (listener != null) {
                listener.onItemRemoved(position);
                listener.onCartUpdated();
            }

            Toast.makeText(context, "Item dihapus dari keranjang", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLaptop, btnIncrease, btnDecrease, btnDelete;
        TextView tvVendor, tvModel, tvPrice, tvQuantity;

        public CartViewHolder(@NonNull View itemView) {
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