package com.ppc.tokokomputer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder> {
    private Context context;
    private ArrayList<Laptop> laptopList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Laptop laptop);
    }

    public LaptopAdapter(Context context, ArrayList<Laptop> laptopList, OnItemClickListener listener) {
        this.context = context;
        this.laptopList = laptopList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LaptopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_laptop, parent, false);
        return new LaptopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaptopViewHolder holder, int position) {
        Laptop laptop = laptopList.get(position);

        // Format harga ke Rupiah
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String harga = formatRupiah.format(laptop.getPrice());

        // Set data ke view
        holder.tvVendor.setText(laptop.getVendor());
        holder.tvModel.setText(laptop.getModel());
        holder.ratingBar.setRating((float) laptop.getRating());
        holder.tvRating.setText(String.format("%.1f", laptop.getRating()));
        holder.tvPrice.setText(harga);
        holder.tvStock.setText("Stok: " + laptop.getStock());

        // Load gambar dengan Glide
        Glide.with(context)
                .load(R.drawable.ic_laptop_placeholder)
                .placeholder(R.drawable.ic_laptop_placeholder)
                .error(R.drawable.ic_error)
                .into(holder.ivLaptop);

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(laptop);
            }
        });
    }

    @Override
    public int getItemCount() {
        return laptopList != null ? laptopList.size() : 0;
    }

    public void updateData(ArrayList<Laptop> newList) {
        laptopList = newList;
        notifyDataSetChanged();
    }

    public static class LaptopViewHolder extends RecyclerView.ViewHolder {
        ImageView ivLaptop;
        TextView tvVendor, tvModel, tvRating, tvPrice, tvStock;
        RatingBar ratingBar;

        public LaptopViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLaptop = itemView.findViewById(R.id.iv_laptop);
            tvVendor = itemView.findViewById(R.id.tv_vendor);
            tvModel = itemView.findViewById(R.id.tv_model);
            ratingBar = itemView.findViewById(R.id.rating_bar);
            tvRating = itemView.findViewById(R.id.tv_rating);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvStock = itemView.findViewById(R.id.tv_stock);
        }
    }
}