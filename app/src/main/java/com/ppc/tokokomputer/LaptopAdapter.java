package com.ppc.tokokomputer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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
        holder.tvVendor.setText(laptop.getVendor());
        holder.tvModel.setText(laptop.getModel());
        holder.ratingBar.setRating((float) laptop.getRating());
        holder.tvRating.setText(String.valueOf(laptop.getRating()));

        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        holder.tvPrice.setText(format.format(laptop.getPrice()));
        holder.tvStock.setText("Stok: " + laptop.getStock());

        // Panggil helper tunggal
        loadLaptopImage(holder.ivLaptop, laptop);

        // Click listener pada item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onItemClick(laptop);
        });
    }

    private void loadLaptopImage(ImageView imageView, Laptop laptop) {
        int backgroundColor = ImageHelper.getLaptopBackgroundColor(laptop.getVendor());
        imageView.setBackgroundColor(ContextCompat.getColor(context, backgroundColor));

        // HANYA panggil ImageHelper, jangan panggil Glide lagi di bawahnya!
        ImageHelper.loadLaptopImage(context, imageView, laptop);
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