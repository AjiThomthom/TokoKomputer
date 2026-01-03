package com.ppc.tokokomputer;

import java.util.ArrayList;

public class LaptopData {
    public static ArrayList<Laptop> getLaptopList() {
        ArrayList<Laptop> laptops = new ArrayList<>();

        // ========== LENOVO (4 LAPTOP) ==========
        laptops.add(new Laptop(
                "Lenovo",
                "ThinkPad X1 Carbon Gen 10",
                4.7,
                28500000,
                12,
                "Laptop bisnis premium dengan bodi serat karbon yang ultra-ringan. Dilengkapi dengan processor Intel vPro dan keamanan tingkat enterprise.",
                "Intel Core i7-1280P (14 core, 20 thread)",
                "32GB LPDDR5 5200MHz",
                "1TB PCIe Gen4 SSD",
                "14\" 4K UHD (3840x2400) HDR 500nit",
                "Intel Iris Xe Graphics",
                "Windows 11 Pro",
                "57Wh (hingga 15 jam)",
                "1.12 kg",
                "2023",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.1, 3.5mm jack",
                "Wi-Fi 6E, Bluetooth 5.2, 4G/LTE (opsional)"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "Legion 5 Pro (16IAH7H)",
                4.8,
                23500000,
                8,
                "Laptop gaming dengan layar 16:10 WQXGA dan refresh rate 165Hz. Dilengkapi cooling system Legion Coldfront 4.0.",
                "Intel Core i7-12700H (14 core, 20 thread)",
                "16GB DDR5 4800MHz",
                "1TB NVMe PCIe 4.0 SSD",
                "16\" WQXGA (2560x1600) 165Hz 500nit",
                "NVIDIA GeForce RTX 3070 Ti 8GB GDDR6",
                "Windows 11 Home",
                "80Wh (hingga 8 jam gaming)",
                "2.49 kg",
                "2023",
                "4x USB-A 3.2, 2x USB-C (1x Thunderbolt 4), HDMI 2.1, Ethernet",
                "Wi-Fi 6E, Bluetooth 5.1, Killer Gaming Network"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "Yoga Slim 7i Pro X",
                4.5,
                18900000,
                15,
                "Laptop ultrabook dengan layar 3K 90Hz dan bodi aluminum premium. Cocok untuk creative professional.",
                "Intel Core i5-12500H (12 core, 16 thread)",
                "16GB LPDDR5 6000MHz",
                "512GB PCIe 4.0 SSD",
                "14.5\" 3K (3072x1920) 90Hz 400nit",
                "Intel Iris Xe Graphics",
                "Windows 11 Home",
                "70Wh (hingga 14 jam)",
                "1.45 kg",
                "2023",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.0, Audio Jack",
                "Wi-Fi 6E, Bluetooth 5.2"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "IdeaPad Gaming 3",
                4.3,
                12500000,
                20,
                "Laptop gaming entry-level dengan performa solid untuk gaming 1080p. Dilengkapi dengan keyboard gaming full-size.",
                "AMD Ryzen 5 6600H (6 core, 12 thread)",
                "8GB DDR5 4800MHz",
                "512GB PCIe 3.0 SSD",
                "15.6\" FHD (1920x1080) 120Hz 250nit",
                "NVIDIA GeForce RTX 3050 4GB GDDR6",
                "Windows 11 Home",
                "45Wh (hingga 6 jam)",
                "2.25 kg",
                "2023",
                "3x USB-A 3.2, 1x USB-C 3.2, HDMI 2.0, Ethernet",
                "Wi-Fi 6, Bluetooth 5.1"
        ));

        // ========== ASUS (4 LAPTOP) ==========
        laptops.add(new Laptop(
                "ASUS",
                "ROG Zephyrus G14 (GA402RJ)",
                4.9,
                27900000,
                6,
                "Laptop gaming 14-inch paling powerful dengan desain compact. Dilengkapi AniMe Matrix LED display pada cover.",
                "AMD Ryzen 9 6900HS (8 core, 16 thread)",
                "32GB DDR5 4800MHz",
                "1TB PCIe 4.0 SSD",
                "14\" QHD (2560x1600) 120Hz 500nit",
                "AMD Radeon RX 6700S 8GB GDDR6",
                "Windows 11 Home",
                "76Wh (hingga 10 jam)",
                "1.65 kg",
                "2023",
                "2x USB-C 3.2, 2x USB-A 3.2, HDMI 2.0b, MicroSD",
                "Wi-Fi 6E, Bluetooth 5.2, 1080p Webcam"
        ));

        laptops.add(new Laptop(
                "ASUS",
                "ZenBook 14X OLED (UX5401)",
                4.6,
                18900000,
                18,
                "Laptop ultrabook dengan layar OLED 2.8K 90Hz. Bodi magnesium-aluminum dengan ErgoLift hinge.",
                "Intel Core i7-12700H (14 core, 20 thread)",
                "16GB LPDDR5 4800MHz",
                "1TB PCIe 4.0 SSD",
                "14.5\" 2.8K OLED (2880x1800) 90Hz 550nit",
                "Intel Iris Xe Graphics",
                "Windows 11 Home",
                "63Wh (hingga 12 jam)",
                "1.4 kg",
                "2023",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.0, MicroSD",
                "Wi-Fi 6E, Bluetooth 5.2, IR Camera with Windows Hello"
        ));

        // ========== APPLE (4 LAPTOP) ==========
        laptops.add(new Laptop(
                "Apple",
                "MacBook Air M2 (2022)",
                4.8,
                18900000,
                25,
                "MacBook Air terbaru dengan chip Apple M2, desain baru yang lebih tipis, dan MagSafe charging.",
                "Apple M2 (8-core CPU, 10-core GPU)",
                "8GB Unified Memory",
                "512GB SSD",
                "13.6\" Liquid Retina (2560x1664) 500nit",
                "Apple 10-core GPU",
                "macOS Ventura",
                "52.6Wh (hingga 18 jam)",
                "1.24 kg",
                "2022",
                "2x Thunderbolt 4 / USB 4, MagSafe 3, 3.5mm jack",
                "Wi-Fi 6, Bluetooth 5.0, 1080p FaceTime HD camera"
        ));

        laptops.add(new Laptop(
                "Apple",
                "MacBook Pro 16\" M2 Max",
                4.9,
                52900000,
                3,
                "MacBook Pro paling powerful dengan chip M2 Max untuk profesional kreatif. Layar Liquid Retina XDR dengan ProMotion.",
                "Apple M2 Max (12-core CPU, 38-core GPU)",
                "64GB Unified Memory",
                "2TB SSD",
                "16.2\" Liquid Retina XDR (3456x2234) 120Hz 1600nit",
                "Apple 38-core GPU",
                "macOS Ventura",
                "100Wh (hingga 22 jam)",
                "2.15 kg",
                "2023",
                "3x Thunderbolt 4, HDMI, SDXC, MagSafe 3, 3.5mm jack",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p FaceTime HD camera"
        ));

        // ========== DELL (4 LAPTOP) ==========
        laptops.add(new Laptop(
                "Dell",
                "XPS 13 Plus (9320)",
                4.7,
                24900000,
                10,
                "XPS dengan desain futuristik: keyboard edge-to-edge, capacitive touch function row, dan invisible haptic touchpad.",
                "Intel Core i7-1280P (14 core, 20 thread)",
                "32GB LPDDR5 5200MHz",
                "1TB PCIe 4.0 SSD",
                "13.4\" 4K UHD+ (3840x2400) Touch 500nit",
                "Intel Iris Xe Graphics",
                "Windows 11 Pro",
                "55Wh (hingga 12 jam)",
                "1.26 kg",
                "2023",
                "2x Thunderbolt 4, 3.5mm jack",
                "Wi-Fi 6E, Bluetooth 5.2, 720p Webcam"
        ));

        laptops.add(new Laptop(
                "Dell",
                "Alienware m18 R1",
                4.8,
                45900000,
                4,
                "Laptop gaming 18-inch dengan performa ekstrem dan cooling system Cryo-Tech. Untuk gamers hardcore.",
                "Intel Core i9-13900HX (24 core, 32 thread)",
                "64GB DDR5 4800MHz",
                "4TB RAID 0 SSD (2x 2TB)",
                "18\" QHD+ (2560x1600) 165Hz 300nit",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "97Wh (hingga 6 jam gaming)",
                "3.21 kg",
                "2023",
                "4x USB-A 3.2, 1x USB-C 3.2, 2x Thunderbolt 4, HDMI 2.1, MiniDP, Ethernet",
                "Killer Wi-Fi 6E, Bluetooth 5.3, Alienware Graphics Amplifier"
        ));

        // ========== HP (4 LAPTOP) ==========
        laptops.add(new Laptop(
                "HP",
                "Spectre x360 14 (2023)",
                4.6,
                21900000,
                12,
                "Laptop convertible premium dengan layar OLED 2.8K. Desain gem-cut dengan diamond-cut edges.",
                "Intel Core i7-1355U (10 core, 12 thread)",
                "16GB LPDDR4x 4267MHz",
                "1TB PCIe 4.0 SSD",
                "13.5\" 3K2K OLED (3000x2000) 400nit",
                "Intel Iris Xe Graphics",
                "Windows 11 Home",
                "66Wh (hingga 13.5 jam)",
                "1.37 kg",
                "2023",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 6E, Bluetooth 5.3, 5MP IR camera"
        ));

        laptops.add(new Laptop(
                "HP",
                "Omen 16 (2023)",
                4.7,
                23900000,
                8,
                "Laptop gaming dengan desain baru yang lebih minimalis. Dilengkapi dengan Omen Gaming Hub untuk optimasi performa.",
                "AMD Ryzen 7 7840HS (8 core, 16 thread)",
                "32GB DDR5 5600MHz",
                "2TB PCIe 4.0 SSD",
                "16.1\" QHD (2560x1440) 240Hz 300nit",
                "NVIDIA GeForce RTX 4070 8GB GDDR6",
                "Windows 11 Home",
                "83Wh (hingga 9 jam)",
                "2.32 kg",
                "2023",
                "3x USB-A 3.2, 1x USB-C 3.2, HDMI 2.1, MiniDP, Ethernet",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p Webcam"
        ));

        // ========== ACER (4 LAPTOP) ==========
        laptops.add(new Laptop(
                "Acer",
                "Predator Helios 16 (PH16-71)",
                4.7,
                28900000,
                7,
                "Laptop gaming dengan layar Mini LED 240Hz dan cooling system 5th Gen AeroBlade 3D Fan.",
                "Intel Core i9-13900HX (24 core, 32 thread)",
                "32GB DDR5 5600MHz",
                "2TB RAID 0 SSD",
                "16\" Mini LED (2560x1600) 240Hz 1000nit",
                "NVIDIA GeForce RTX 4080 12GB GDDR6",
                "Windows 11 Home",
                "90Wh (hingga 7 jam)",
                "2.6 kg",
                "2023",
                "3x USB-A 3.2, 2x Thunderbolt 4, HDMI 2.1, Ethernet, Kensington Lock",
                "Killer Wi-Fi 6E, Bluetooth 5.2, 1080p Webcam"
        ));

        laptops.add(new Laptop(
                "Acer",
                "Swift Go 14 (SFG14-71)",
                4.4,
                14900000,
                22,
                "Laptop ultrabook dengan AI features melalui Acer PurifiedVoice dan Acer PurifiedView.",
                "Intel Core i5-13500H (12 core, 16 thread)",
                "16GB LPDDR5 4800MHz",
                "1TB PCIe 4.0 SSD",
                "14\" 2.8K OLED (2880x1800) 90Hz 500nit",
                "Intel Iris Xe Graphics",
                "Windows 11 Home",
                "65Wh (hingga 9.5 jam)",
                "1.3 kg",
                "2023",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 6E, Bluetooth 5.2, 1440p QHD Webcam"
        ));

        // ========== MSI (4 LAPTOP) ==========
        laptops.add(new Laptop(
                "MSI",
                "Stealth 14 Studio (A13V)",
                4.8,
                29900000,
                5,
                "Laptop creator/gaming hybrid dengan performa workstation dalam bodi 14-inch. Dilengkapi dengan Cooler Boost Trinity+.",
                "Intel Core i9-13900H (14 core, 20 thread)",
                "32GB DDR5 5200MHz",
                "2TB PCIe 4.0 SSD",
                "14\" QHD+ (2560x1600) 240Hz 400nit",
                "NVIDIA GeForce RTX 4070 8GB GDDR6",
                "Windows 11 Pro",
                "72Wh (hingga 8 jam)",
                "1.7 kg",
                "2023",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.1, SD Card Reader",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p Webcam"
        ));

        laptops.add(new Laptop(
                "MSI",
                "Katana 15 (B13VFK)",
                4.5,
                15900000,
                15,
                "Laptop gaming value-for-money dengan desain katana-inspired dan Mystic Light RGB keyboard.",
                "Intel Core i7-13620H (10 core, 16 thread)",
                "16GB DDR5 4800MHz",
                "1TB PCIe 4.0 SSD",
                "15.6\" FHD (1920x1080) 144Hz 144Hz",
                "NVIDIA GeForce RTX 4060 8GB GDDR6",
                "Windows 11 Home",
                "53.5Wh (hingga 6 jam)",
                "2.25 kg",
                "2023",
                "2x USB-A 3.2, 1x USB-C 3.2, 1x USB-A 2.0, HDMI 2.1, Ethernet",
                "Wi-Fi 6, Bluetooth 5.2, 720p Webcam"
        ));

        // ========== MICROSOFT (2 LAPTOP) ==========
        laptops.add(new Laptop(
                "Microsoft",
                "Surface Laptop Studio 2",
                4.7,
                38900000,
                6,
                "Laptop convertible dengan dynamic woven hinge yang bisa diubah menjadi tablet, studio, atau canvas.",
                "Intel Core i7-13700H (14 core, 20 thread)",
                "32GB LPDDR5x 6400MHz",
                "1TB PCIe 4.0 SSD",
                "14.4\" PixelSense Flow (2400x1600) 120Hz Touch",
                "NVIDIA GeForce RTX 4060 8GB GDDR6",
                "Windows 11 Pro",
                "58Wh (hingga 18 jam)",
                "1.98 kg",
                "2023",
                "2x Thunderbolt 4, 1x USB-A 3.2, Surface Connect",
                "Wi-Fi 6E, Bluetooth 5.1, 1080p Windows Hello camera"
        ));

        // ========== RAZER (2 LAPTOP) ==========
        laptops.add(new Laptop(
                "Razer",
                "Blade 16 (2023)",
                4.9,
                45900000,
                3,
                "Laptop gaming dengan dual-mode Mini LED display yang bisa beralih antara 4K 120Hz dan FHD 240Hz.",
                "Intel Core i9-13950HX (24 core, 32 thread)",
                "32GB DDR5 5600MHz",
                "2TB PCIe 4.0 SSD",
                "16\" Dual-mode Mini LED (3840x2400/1920x1200) 120Hz/240Hz",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "95.2Wh (hingga 7 hours)",
                "2.45 kg",
                "2023",
                "3x USB-A 3.2, 2x Thunderbolt 4, HDMI 2.1, SD Card Reader, Kensington Lock",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p Webcam with Windows Hello"
        ));

        // ========== GIGABYTE (2 LAPTOP) ==========
        laptops.add(new Laptop(
                "Gigabyte",
                "AORUS 17X (2023)",
                4.6,
                42900000,
                4,
                "Laptop gaming dengan WINDFORCE Infinity cooling system dan mekanical keyboard per-key RGB.",
                "Intel Core i9-13980HX (24 core, 32 thread)",
                "64GB DDR5 5600MHz",
                "4TB SSD (2x 2TB RAID 0)",
                "17.3\" QHD (2560x1440) 240Hz 300nit",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Pro",
                "99Wh (hingga 5 hours gaming)",
                "3.2 kg",
                "2023",
                "3x USB-A 3.2, 1x Thunderbolt 4, 1x USB-C 3.2, HDMI 2.1, MiniDP, Ethernet",
                "Killer Wi-Fi 6E, Bluetooth 5.2, 1080p Webcam"
        ));

        return laptops;
    }

    public static ArrayList<Laptop> getLaptopsByBrand(String brand) {
        ArrayList<Laptop> allLaptops = getLaptopList();
        ArrayList<Laptop> filteredLaptops = new ArrayList<>();

        for (Laptop laptop : allLaptops) {
            if (laptop.getVendor().equalsIgnoreCase(brand)) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }

    public static ArrayList<Laptop> getPromoLaptops() {
        ArrayList<Laptop> allLaptops = getLaptopList();
        // Ambil 4 laptop terbaik sebagai promo
        ArrayList<Laptop> promoList = new ArrayList<>();
        promoList.add(allLaptops.get(0));  // Lenovo ThinkPad
        promoList.add(allLaptops.get(4));  // ASUS ROG Zephyrus
        promoList.add(allLaptops.get(6));  // Apple MacBook Air M2
        promoList.add(allLaptops.get(8));  // Dell XPS 13 Plus

        return promoList;
    }

    public static ArrayList<String> getAllBrands() {
        ArrayList<String> brands = new ArrayList<>();
        brands.add("Lenovo");
        brands.add("ASUS");
        brands.add("Apple");
        brands.add("Dell");
        brands.add("HP");
        brands.add("Acer");
        brands.add("MSI");
        brands.add("Microsoft");
        brands.add("Razer");
        brands.add("Gigabyte");
        return brands;
    }
}