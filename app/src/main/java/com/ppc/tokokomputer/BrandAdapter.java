package com.ppc.tokokomputer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandViewHolder> {

    private Context context;
    private List<Brand> brandList;
    private OnBrandClickListener listener;

    public interface OnBrandClickListener {
        void onBrandClick(String brandName);
    }

    public BrandAdapter(Context context, List<Brand> brandList, OnBrandClickListener listener) {
        this.context = context;
        this.brandList = brandList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_brand, parent, false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        Brand brand = brandList.get(position);

        // Set logo brand
        holder.ivBrandLogo.setImageResource(brand.getLogoResId());

        // Set nama brand
        holder.tvBrandName.setText(brand.getName());

        // Set background color card
        holder.cardView.setCardBackgroundColor(brand.getBackgroundColor());

        // Set text color berdasarkan kecerahan background
        setTextColorBasedOnBackground(holder.tvBrandName, brand.getBackgroundColor());

        // Click listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onBrandClick(brand.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return brandList != null ? brandList.size() : 0;
    }

    /**
     * Method untuk menentukan warna text berdasarkan kecerahan background
     * agar selalu kontras
     */
    private void setTextColorBasedOnBackground(TextView textView, int backgroundColor) {
        // Konversi warna ke HSL untuk mendapatkan lightness
        float[] hsv = new float[3];
        Color.colorToHSV(backgroundColor, hsv);
        float lightness = hsv[2]; // Value component (0-1)

        // Jika background terang, gunakan warna gelap
        // Jika background gelap, gunakan warna terang
        if (lightness > 0.5f) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.black));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.white));
        }
    }

    public static class BrandViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBrandLogo;
        TextView tvBrandName;
        com.google.android.material.card.MaterialCardView cardView;

        public BrandViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBrandLogo = itemView.findViewById(R.id.iv_brand_logo);
            tvBrandName = itemView.findViewById(R.id.tv_brand_name);
            cardView = (com.google.android.material.card.MaterialCardView) itemView;
        }
    }
}