package com.ppc.tokokomputer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class ImageHelper {

    private static final String TAG = "ImageHelper";

    /**
     * Mendapatkan resource logo brand sebagai placeholder/fallback.
     */
    @DrawableRes
    public static int getLaptopImage(String vendor, String model) {
        if (vendor == null) return R.drawable.ic_laptop_placeholder;

        String vendorLower = vendor.toLowerCase();
        switch (vendorLower) {
            case "lenovo": return R.drawable.ic_lenovo_logo;
            case "apple": return R.drawable.ic_apple_logo;
            case "asus": return R.drawable.ic_asus_logo;
            case "dell": return R.drawable.ic_dell_logo;
            case "hp": return R.drawable.ic_hp_logo;
            case "acer": return R.drawable.ic_acer_logo;
            case "msi": return R.drawable.ic_msi_logo;
            case "samsung": return R.drawable.ic_samsung_logo;
            case "microsoft": return R.drawable.ic_microsoft_logo;
            case "razer": return R.drawable.ic_razer_logo;
            default: return R.drawable.ic_laptop_placeholder;
        }
    }

    /**
     * Memuat gambar laptop dari URL dengan penanganan error yang baik.
     */
    public static void loadLaptopImage(Context context, ImageView imageView, Laptop laptop) {
        if (laptop == null) {
            imageView.setImageResource(R.drawable.ic_laptop_placeholder);
            return;
        }

        // Tentukan logo brand sebagai cadangan jika URL gagal dimuat
        int fallbackLogo = getLaptopImage(laptop.getVendor(), laptop.getModel());

        if (laptop.getImageUrl() != null && !laptop.getImageUrl().isEmpty()) {
            Glide.with(context)
                    .load(laptop.getImageUrl())
                    .placeholder(R.drawable.ic_laptop_placeholder) // Gambar saat loading
                    .error(fallbackLogo) // Jika internet error, tampilkan logo brand
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // Simpan cache agar hemat kuota
                    .transition(DrawableTransitionOptions.withCrossFade()) // Efek halus saat muncul
                    .centerInside()
                    .into(imageView);
        } else {
            // Jika tidak ada URL, langsung pakai logo brand
            imageView.setImageResource(fallbackLogo);
        }
    }

    /**
     * Mendapatkan warna tema background berdasarkan vendor.
     */
    public static int getLaptopBackgroundColor(String vendor) {
        if (vendor == null) return R.color.primary_color;

        String vendorLower = vendor.toLowerCase();
        switch (vendorLower) {
            case "lenovo": return R.color.lenovo_color;
            case "apple": return R.color.apple_color;
            case "asus": return R.color.asus_color;
            case "dell": return R.color.dell_color;
            case "hp": return R.color.hp_color;
            case "acer": return R.color.acer_color;
            case "msi": return R.color.msi_color;
            case "samsung": return R.color.samsung_color;
            case "microsoft": return R.color.microsoft_color;
            case "razer": return R.color.razer_color;
            default: return R.color.primary_color;
        }
    }
}