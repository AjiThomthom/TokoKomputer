package com.ppc.tokokomputer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LaptopData {
    public static ArrayList<Laptop> getLaptopList() {
        ArrayList<Laptop> laptops = new ArrayList<>();

        // ========== LENOVO (12 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "Lenovo",
                "ThinkPad X1 Carbon Gen 11 (2024)",
                4.8,
                28990000,
                15,
                "Laptop bisnis premium terbaru dengan Intel Core Ultra, layar OLED 2.8K, dan bodi serat karbon. Dilengkapi dengan AI capabilities untuk produktivitas maksimal.",
                "Intel Core Ultra 7 155H (16 core, 22 thread)",
                "32GB LPDDR5x 6400MHz",
                "1TB PCIe Gen4 NVMe SSD",
                "14\" 2.8K OLED (2880x1800) 90Hz HDR 400nit",
                "Intel Arc Graphics (8 Xe cores)",
                "Windows 11 Pro",
                "57Wh (hingga 18 jam)",
                "1.09 kg",
                "2024",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.1, 3.5mm jack",
                "Wi-Fi 7, Bluetooth 5.4, 5G/LTE, FHD IR camera dengan AI",
                "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=800&auto=format&fit=crop" // Laptop image
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "Legion Pro 7i (16IRX9H)",
                4.9,
                35990000,
                8,
                "Laptop gaming flagship dengan processor Intel Core i9-14900HX dan GPU RTX 4090. Cooling system Legion Coldfront 5.0 dengan vapor chamber.",
                "Intel Core i9-14900HX (24 core, 32 thread)",
                "64GB DDR5 5600MHz",
                "4TB NVMe PCIe 4.0 SSD (Dual SSD)",
                "16\" Mini LED (2560x1600) 240Hz 1200nit HDR",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "99.9Wh (hingga 8 jam gaming)",
                "2.8 kg",
                "2024",
                "3x USB-A 3.2, 2x USB-C (Thunderbolt 4), HDMI 2.1, Ethernet 2.5G",
                "Killer Wi-Fi 7, Bluetooth 5.3, 1080p FHD camera",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "Yoga 9i Gen 9 (14IRP9)",
                4.7,
                24990000,
                18,
                "Laptop convertible premium dengan rotating soundbar, layar OLED 4K, dan chassis aluminum. Cocok untuk creative professional.",
                "Intel Core Ultra 9 185H (16 core, 22 thread)",
                "32GB LPDDR5x 7467MHz",
                "2TB PCIe 4.0 SSD",
                "14\" 4K OLED (3840x2400) 90Hz Touch 400nit",
                "Intel Arc Graphics (8 Xe cores)",
                "Windows 11 Home",
                "75Wh (hingga 15 jam)",
                "1.42 kg",
                "2024",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 7, Bluetooth 5.4, 4K webcam dengan Studio Effects",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "ThinkBook 16p Gen 5",
                4.6,
                21990000,
                12,
                "Laptop workstation mobile dengan performa tinggi untuk content creator. Mendukung NVIDIA Studio drivers dan color accuracy 100% DCI-P3.",
                "AMD Ryzen 9 7940HS (8 core, 16 thread)",
                "32GB DDR5 5600MHz",
                "2TB PCIe 4.0 SSD",
                "16\" 3.2K IPS (3200x2000) 165Hz 430nit",
                "NVIDIA GeForce RTX 4060 8GB GDDR6",
                "Windows 11 Pro",
                "90Wh (hingga 10 jam)",
                "2.1 kg",
                "2024",
                "2x USB-C 4.0, 2x USB-A 3.2, HDMI 2.1, SD card reader",
                "Wi-Fi 6E, Bluetooth 5.3, FHD IR camera",
                "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "IdeaPad Slim 5i Gen 9",
                4.4,
                12990000,
                25,
                "Laptop ultrabook tipis dengan performa solid dan baterai tahan lama. Dilengkapi dengan smart features melalui Lenovo AI Engine.",
                "Intel Core Ultra 5 125H (14 core, 18 thread)",
                "16GB LPDDR5x 6400MHz",
                "1TB PCIe 4.0 SSD",
                "14\" 2.8K OLED (2880x1800) 90Hz 400nit",
                "Intel Arc Graphics (7 Xe cores)",
                "Windows 11 Home",
                "75Wh (hingga 14 jam)",
                "1.32 kg",
                "2024",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.0, SD card reader",
                "Wi-Fi 6E, Bluetooth 5.3, FHD camera dengan privacy shutter",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "LOQ 15IRX9",
                4.5,
                14990000,
                20,
                "Laptop gaming entry-level dengan performa value for money. Dilengkapi dengan MUX switch dan cooling system dual fan.",
                "Intel Core i7-13650HX (14 core, 20 thread)",
                "16GB DDR5 4800MHz",
                "1TB PCIe 4.0 SSD",
                "15.6\" WQHD (2560x1440) 165Hz 350nit",
                "NVIDIA GeForce RTX 4050 6GB GDDR6",
                "Windows 11 Home",
                "60Wh (hingga 6 jam gaming)",
                "2.4 kg",
                "2024",
                "3x USB-A 3.2, 1x USB-C 3.2, HDMI 2.1, Ethernet",
                "Wi-Fi 6, Bluetooth 5.2, 720p HD camera",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "ThinkPad Z16 Gen 2",
                4.7,
                32990000,
                10,
                "Laptop bisnis premium dengan desain modern, material recycled aluminum, dan performa AMD Ryzen PRO untuk enterprise.",
                "AMD Ryzen 9 PRO 7940HS (8 core, 16 thread)",
                "64GB LPDDR5x 6400MHz",
                "2TB PCIe 4.0 SSD",
                "16\" 4K OLED (3840x2400) Touch HDR 500nit",
                "AMD Radeon 780M Graphics",
                "Windows 11 Pro",
                "72Wh (hingga 16 jam)",
                "1.88 kg",
                "2024",
                "3x USB-C 4.0, 1x USB-A 3.2, HDMI 2.1, Smart card reader",
                "Wi-Fi 7, Bluetooth 5.4, 5G/LTE, FHD+IR camera dengan Computer Vision",
                "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "Legion Slim 5 Gen 9",
                4.6,
                18990000,
                15,
                "Laptop gaming slim dengan performa solid dalam bodi tipis. Ideal untuk gaming dan productivity.",
                "AMD Ryzen 7 7840HS (8 core, 16 thread)",
                "32GB DDR5 5600MHz",
                "1TB PCIe 4.0 SSD",
                "16\" WQXGA (2560x1600) 240Hz 500nit",
                "NVIDIA GeForce RTX 4060 8GB GDDR6",
                "Windows 11 Home",
                "80Wh (hingga 9 jam)",
                "2.3 kg",
                "2024",
                "2x USB-C 4.0, 2x USB-A 3.2, HDMI 2.1, SD card reader",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p FHD camera",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "ThinkPad P16s Gen 2",
                4.6,
                27990000,
                8,
                "Mobile workstation dengan sertifikasi ISV untuk aplikasi profesional seperti AutoCAD, Revit, dan SolidWorks.",
                "Intel Core i7-13800H (14 core, 20 thread)",
                "64GB DDR5 5200MHz",
                "2TB PCIe 4.0 SSD",
                "16\" 4K IPS (3840x2400) 600nit HDR",
                "NVIDIA RTX 2000 Ada 8GB GDDR6",
                "Windows 11 Pro",
                "86Wh (hingga 12 jam)",
                "2.2 kg",
                "2024",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.1, Ethernet",
                "Wi-Fi 6E, Bluetooth 5.3, FHD IR camera dengan Human Presence Detection",
                "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "IdeaPad Gaming 3i Gen 8",
                4.3,
                11990000,
                22,
                "Laptop gaming budget-friendly dengan performa gaming 1080p yang solid. Keyboard dengan 4-zone RGB.",
                "Intel Core i5-13450HX (10 core, 16 thread)",
                "16GB DDR5 4800MHz",
                "512GB PCIe 4.0 SSD",
                "15.6\" FHD (1920x1080) 144Hz 250nit",
                "NVIDIA GeForce RTX 3050 6GB GDDR6",
                "Windows 11 Home",
                "45Wh (hingga 5 jam gaming)",
                "2.25 kg",
                "2024",
                "3x USB-A 3.2, 1x USB-C 3.2, HDMI 2.0, Ethernet",
                "Wi-Fi 6, Bluetooth 5.1, 720p HD camera",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Lenovo",
                "Yoga Air 14s",
                4.7,
                19990000,
                16,
                "Laptop ultraportable dengan bodi magnesium-aluminum hanya 1.2kg. Layar 2.8K 120Hz dengan Dolby Vision.",
                "AMD Ryzen 7 7840U (8 core, 16 thread)",
                "32GB LPDDR5x 6400MHz",
                "1TB PCIe 4.0 SSD",
                "14.5\" 2.8K OLED (2880x1800) 120Hz 400nit",
                "AMD Radeon 780M Graphics",
                "Windows 11 Home",
                "70Wh (hingga 15 jam)",
                "1.2 kg",
                "2024",
                "2x USB-C 4.0, 1x USB-A 3.2, HDMI 2.1",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p FHD camera dengan Windows Hello",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        // ========== APPLE (12 MACBOOK TERLARIS) ==========
        laptops.add(new Laptop(
                "Apple",
                "MacBook Air 13\" M3 (2024)",
                4.8,
                18990000,
                30,
                "MacBook Air terbaru dengan chip Apple M3, lebih cepat 20% dari M2. Desain tipis tanpa kipas, ideal untuk pekerja mobile.",
                "Apple M3 (8-core CPU, 10-core GPU)",
                "8GB Unified Memory",
                "512GB SSD",
                "13.6\" Liquid Retina (2560x1664) 500nit",
                "Apple 10-core GPU",
                "macOS Sonoma",
                "52.6Wh (hingga 18 jam)",
                "1.24 kg",
                "2024",
                "2x Thunderbolt 4 / USB 4, MagSafe 3, 3.5mm jack",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p FaceTime HD camera",
                "https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Apple",
                "MacBook Air 15\" M3 (2024)",
                4.9,
                22990000,
                25,
                "MacBook Air 15-inch dengan layar lebih luas namun tetap tipis. Performa M3 untuk multitasking dan creative work.",
                "Apple M3 (8-core CPU, 10-core GPU)",
                "16GB Unified Memory",
                "512GB SSD",
                "15.3\" Liquid Retina (2880x1864) 500nit",
                "Apple 10-core GPU",
                "macOS Sonoma",
                "66.5Wh (hingga 18 jam)",
                "1.51 kg",
                "2024",
                "2x Thunderbolt 4 / USB 4, MagSafe 3, 3.5mm jack",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p FaceTime HD camera",
                "https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Apple",
                "MacBook Pro 14\" M3 Pro",
                4.9,
                32990000,
                15,
                "MacBook Pro untuk profesional dengan chip M3 Pro. Layar Liquid Retina XDR dengan ProMotion 120Hz.",
                "Apple M3 Pro (12-core CPU, 18-core GPU)",
                "18GB Unified Memory",
                "1TB SSD",
                "14.2\" Liquid Retina XDR (3024x1964) 120Hz 1600nit",
                "Apple 18-core GPU",
                "macOS Sonoma",
                "70Wh (hingga 22 jam)",
                "1.61 kg",
                "2024",
                "3x Thunderbolt 4, HDMI, SDXC, MagSafe 3, 3.5mm jack",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p FaceTime HD camera",
                "https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Apple",
                "MacBook Pro 16\" M3 Max",
                5.0,
                62990000,
                8,
                "MacBook Pro paling powerful dengan chip M3 Max untuk profesional kreatif ekstrem. Mendukung external display hingga 4 monitor.",
                "Apple M3 Max (16-core CPU, 40-core GPU)",
                "96GB Unified Memory",
                "4TB SSD",
                "16.2\" Liquid Retina XDR (3456x2234) 120Hz 1600nit",
                "Apple 40-core GPU",
                "macOS Sonoma",
                "100Wh (hingga 22 jam)",
                "2.15 kg",
                "2024",
                "3x Thunderbolt 4, HDMI, SDXC, MagSafe 3, 3.5mm jack",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p FaceTime HD camera dengan Studio mic array",
                "https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Apple",
                "MacBook Pro 14\" M3 Max",
                4.9,
                48990000,
                10,
                "Power maksimal dalam bodi 14-inch. Untuk video editor, 3D artist, dan developer yang butuh portabilitas.",
                "Apple M3 Max (14-core CPU, 30-core GPU)",
                "36GB Unified Memory",
                "2TB SSD",
                "14.2\" Liquid Retina XDR (3024x1964) 120Hz 1600nit",
                "Apple 30-core GPU",
                "macOS Sonoma",
                "70Wh (hingga 18 jam)",
                "1.61 kg",
                "2024",
                "3x Thunderbolt 4, HDMI, SDXC, MagSafe 3, 3.5mm jack",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p FaceTime HD camera",
                "https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Apple",
                "MacBook Air 13\" M2 (2023)",
                4.7,
                15990000,
                35,
                "MacBook Air dengan chip M2, masih sangat relevan dan harga lebih terjangkau. Desain baru dengan MagSafe.",
                "Apple M2 (8-core CPU, 10-core GPU)",
                "8GB Unified Memory",
                "256GB SSD",
                "13.6\" Liquid Retina (2560x1664) 500nit",
                "Apple 10-core GPU",
                "macOS Ventura",
                "52.6Wh (hingga 18 jam)",
                "1.24 kg",
                "2023",
                "2x Thunderbolt 4 / USB 4, MagSafe 3, 3.5mm jack",
                "Wi-Fi 6, Bluetooth 5.0, 1080p FaceTime HD camera",
                "https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Apple",
                "MacBook Pro 13\" M2 (2023)",
                4.6,
                19990000,
                20,
                "MacBook Pro 13-inch dengan chip M2 dan Touch Bar. Untuk yang masih suka form factor klasik.",
                "Apple M2 (8-core CPU, 10-core GPU)",
                "8GB Unified Memory",
                "512GB SSD",
                "13.3\" Retina (2560x1600) 500nit",
                "Apple 10-core GPU",
                "macOS Ventura",
                "58.2Wh (hingga 20 jam)",
                "1.4 kg",
                "2023",
                "2x Thunderbolt 4 / USB 4, 3.5mm jack",
                "Wi-Fi 6, Bluetooth 5.0, 720p FaceTime HD camera",
                "https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Apple",
                "MacBook Pro 16\" M2 Pro",
                4.8,
                37990000,
                12,
                "MacBook Pro dengan chip M2 Pro, performa excellent untuk creative professional dengan harga lebih terjangkau dari M3.",
                "Apple M2 Pro (12-core CPU, 19-core GPU)",
                "16GB Unified Memory",
                "1TB SSD",
                "16.2\" Liquid Retina XDR (3456x2234) 120Hz 1600nit",
                "Apple 19-core GPU",
                "macOS Ventura",
                "100Wh (hingga 21 jam)",
                "2.15 kg",
                "2023",
                "3x Thunderbolt 4, HDMI, SDXC, MagSafe 3, 3.5mm jack",
                "Wi-Fi 6E, Bluetooth 5.3, 1080p FaceTime HD camera",
                "https://images.unsplash.com/photo-1541807084-5c52b6b3adef?w=800&auto=format&fit=crop"
        ));

        // ========== ASUS (12 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "ASUS",
                "ROG Zephyrus G16 (2024)",
                4.9,
                32990000,
                10,
                "Laptop gaming ultraportable dengan desain baru Slash Lighting dan performa maksimal. AniMe Matrix LED customizable.",
                "Intel Core Ultra 9 185H (16 core, 22 thread)",
                "32GB LPDDR5x 7467MHz",
                "2TB PCIe 4.0 SSD",
                "16\" Nebula HDR Display (2560x1600) 240Hz 1100nit",
                "NVIDIA GeForce RTX 4080 12GB GDDR6",
                "Windows 11 Home",
                "90Wh (hingga 10 jam)",
                "1.85 kg",
                "2024",
                "2x USB-C (Thunderbolt 4), 2x USB-A 3.2, HDMI 2.1, SD card reader",
                "Wi-Fi 7, Bluetooth 5.4, 1080p FHD camera dengan Windows Hello",
                "https://images.unsplash.com/photo-1602080858428-57174f9431cf?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "ASUS",
                "Zenbook 14 OLED (UX3405)",
                4.7,
                17990000,
                22,
                "Laptop ultrabook dengan layar OLED 3K 120Hz dan AI features melalui ASUS AiSense. Desain premium dengan ErgoLift hinge.",
                "Intel Core Ultra 7 155H (16 core, 22 thread)",
                "32GB LPDDR5x 6400MHz",
                "1TB PCIe 4.0 SSD",
                "14\" 3K OLED (2880x1800) 120Hz 600nit",
                "Intel Arc Graphics (8 Xe cores)",
                "Windows 11 Home",
                "75Wh (hingga 15 jam)",
                "1.2 kg",
                "2024",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 6E, Bluetooth 5.3, FHD camera dengan AI noise cancellation",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "ASUS",
                "ROG Strix G18 (2024)",
                4.8,
                29990000,
                12,
                "Laptop gaming 18-inch dengan performa ekstrem dan cooling system Tri-Fan. Layar ROG Nebula HDR dengan 1100nit peak brightness.",
                "Intel Core i9-14900HX (24 core, 32 thread)",
                "64GB DDR5 5600MHz",
                "4TB PCIe 4.0 SSD (Dual SSD RAID 0)",
                "18\" ROG Nebula HDR (2560x1600) 240Hz 1100nit",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "90Wh (hingga 7 jam gaming)",
                "3.1 kg",
                "2024",
                "2x USB-C (Thunderbolt 4), 3x USB-A 3.2, HDMI 2.1, Ethernet",
                "Wi-Fi 7, Bluetooth 5.4, 720p HD camera",
                "https://images.unsplash.com/photo-1602080858428-57174f9431cf?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "ASUS",
                "TUF Gaming A16 (2024)",
                4.6,
                16990000,
                18,
                "Laptop gaming dengan performa AMD Ryzen dan GPU Radeon. Military-grade durability dengan sertifikasi MIL-STD-810H.",
                "AMD Ryzen 9 7940HS (8 core, 16 thread)",
                "32GB DDR5 5600MHz",
                "2TB PCIe 4.0 SSD",
                "16\" IPS (2560x1600) 240Hz 500nit",
                "AMD Radeon RX 7700S 8GB GDDR6",
                "Windows 11 Home",
                "90Wh (hingga 12 jam)",
                "2.3 kg",
                "2024",
                "2x USB-C 4.0, 2x USB-A 3.2, HDMI 2.1, Ethernet",
                "Wi-Fi 6E, Bluetooth 5.3, 720p HD camera",
                "https://images.unsplash.com/photo-1602080858428-57174f9431cf?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "ASUS",
                "ProArt Studiobook 16",
                4.8,
                44990000,
                6,
                "Laptop workstation untuk creative professional dengan color accuracy 100% DCI-P3 dan sertifikasi Calman Verified.",
                "Intel Core i9-13980HX (24 core, 32 thread)",
                "64GB DDR5 5600MHz",
                "4TB PCIe 4.0 SSD",
                "16\" 4K OLED (3840x2400) 120Hz 550nit",
                "NVIDIA RTX 4000 Ada 12GB GDDR6",
                "Windows 11 Pro",
                "90Wh (hingga 8 jam)",
                "2.4 kg",
                "2024",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.1, SD Express card reader",
                "Wi-Fi 6E, Bluetooth 5.3, FHD IR camera",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "ASUS",
                "Vivobook S 14 OLED",
                4.5,
                12990000,
                25,
                "Laptop everyday dengan layar OLED 2.8K dan performa solid untuk work & entertainment. Desain stylish dengan multiple color options.",
                "AMD Ryzen 7 7735HS (8 core, 16 thread)",
                "16GB LPDDR5 6400MHz",
                "1TB PCIe 4.0 SSD",
                "14\" 2.8K OLED (2880x1800) 90Hz 600nit",
                "AMD Radeon 680M Graphics",
                "Windows 11 Home",
                "70Wh (hingga 13 jam)",
                "1.3 kg",
                "2024",
                "2x USB-C 4.0, 2x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 6E, Bluetooth 5.2, FHD camera dengan privacy shutter",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "ASUS",
                "ROG Flow Z13 (2024)",
                4.7,
                23990000,
                10,
                "Gaming tablet dengan keyboard detachable. Performa gaming penuh dalam form factor tablet dengan GPU external support.",
                "Intel Core Ultra 9 185H (16 core, 22 thread)",
                "32GB LPDDR5x 7467MHz",
                "2TB PCIe 4.0 SSD",
                "13.4\" Nebula HDR Display (2560x1600) 165Hz 1100nit",
                "NVIDIA GeForce RTX 4060 8GB GDDR6",
                "Windows 11 Home",
                "56Wh (hingga 8 jam)",
                "1.18 kg",
                "2024",
                "1x USB-C (Thunderbolt 4), 1x USB-C 3.2, microSD, XG Mobile Interface",
                "Wi-Fi 7, Bluetooth 5.4, 5MP front camera",
                "https://images.unsplash.com/photo-1602080858428-57174f9431cf?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "ASUS",
                "ExpertBook B9",
                4.6,
                25990000,
                15,
                "Laptop bisnis premium dengan bodi magnesium-lithium hanya 880g. Dilengkapi dengan security features enterprise-grade.",
                "Intel Core i7-1365U (10 core, 12 thread)",
                "32GB LPDDR5 5200MHz",
                "2TB PCIe 4.0 SSD",
                "14\" OLED (2880x1800) 90Hz 400nit",
                "Intel Iris Xe Graphics",
                "Windows 11 Pro",
                "66Wh (hingga 16 jam)",
                "0.88 kg",
                "2024",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.1, Smart card reader",
                "Wi-Fi 6E, Bluetooth 5.3, FHD IR camera dengan TPM 2.0",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        // ========== DELL (12 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "Dell",
                "XPS 13 Plus (9340)",
                4.8,
                25990000,
                18,
                "XPS dengan desain futuristik: capacitive touch function row, invisible haptic touchpad, dan keyboard edge-to-edge.",
                "Intel Core Ultra 7 155H (16 core, 22 thread)",
                "32GB LPDDR5x 6400MHz",
                "2TB PCIe 4.0 SSD",
                "13.4\" 4K OLED Touch (3840x2400) 400nit",
                "Intel Arc Graphics (8 Xe cores)",
                "Windows 11 Pro",
                "55Wh (hingga 14 jam)",
                "1.26 kg",
                "2024",
                "2x Thunderbolt 4, 3.5mm jack",
                "Wi-Fi 7, Bluetooth 5.4, 1080p FHD camera",
                "https://images.unsplash.com/photo-1593640408182-31c70c8268f5?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Dell",
                "Alienware m18 R2",
                4.9,
                45990000,
                6,
                "Laptop gaming 18-inch dengan performa ekstrem. Dilengkapi dengan Alienware Cryo-Tech cooling dan per-key RGB keyboard.",
                "Intel Core i9-14900HX (24 core, 32 thread)",
                "64GB DDR5 5600MHz",
                "8TB SSD (Dual 4TB RAID 0)",
                "18\" QHD+ (2560x1600) 165Hz 300nit",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "97Wh (hingga 6 jam gaming)",
                "3.21 kg",
                "2024",
                "4x USB-A 3.2, 2x Thunderbolt 4, HDMI 2.1, Mini DisplayPort",
                "Killer Wi-Fi 7, Bluetooth 5.4, FHD camera dengan Windows Hello",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Dell",
                "Inspiron 14 Plus (7440)",
                4.5,
                14990000,
                20,
                "Laptop all-rounder dengan performa solid untuk work & play. Dilengkapi dengan Dell ComfortView Plus untuk eye comfort.",
                "Intel Core Ultra 7 155H (16 core, 22 thread)",
                "16GB LPDDR5x 6400MHz",
                "1TB PCIe 4.0 SSD",
                "14\" 2.8K OLED (2880x1800) 90Hz 400nit",
                "Intel Arc Graphics (8 Xe cores)",
                "Windows 11 Home",
                "64Wh (hingga 12 jam)",
                "1.6 kg",
                "2024",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.1, SD card reader",
                "Wi-Fi 6E, Bluetooth 5.3, FHD camera",
                "https://images.unsplash.com/photo-1593640408182-31c70c8268f5?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Dell",
                "Latitude 9450 2-in-1",
                4.7,
                27990000,
                12,
                "Laptop convertible premium untuk bisnis dengan security features lengkap. Dilengkapi dengan Dell SafeShutter dan ExpressSign-in.",
                "Intel Core Ultra 7 165U (12 core, 14 thread)",
                "32GB LPDDR5x 6400MHz",
                "2TB PCIe 4.0 SSD",
                "14\" QHD+ (2560x1600) Touch 500nit",
                "Intel Arc Graphics (8 Xe cores)",
                "Windows 11 Pro",
                "78Wh (hingga 20 jam)",
                "1.45 kg",
                "2024",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.1, Smart card reader",
                "Wi-Fi 7, Bluetooth 5.4, 5MP camera dengan Computer Vision",
                "https://images.unsplash.com/photo-1593640408182-31c70c8268f5?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Dell",
                "G15 Gaming (5530)",
                4.6,
                16990000,
                15,
                "Laptop gaming dengan desain baru dan performa solid. Dilengkapi dengan Alienware Command Center untuk game optimization.",
                "Intel Core i7-13650HX (14 core, 20 thread)",
                "16GB DDR5 4800MHz",
                "1TB PCIe 4.0 SSD",
                "15.6\" QHD (2560x1440) 240Hz 400nit",
                "NVIDIA GeForce RTX 4060 8GB GDDR6",
                "Windows 11 Home",
                "86Wh (hingga 8 jam gaming)",
                "2.65 kg",
                "2024",
                "3x USB-A 3.2, 1x USB-C 3.2, HDMI 2.1, Ethernet",
                "Killer Wi-Fi 6E, Bluetooth 5.3, HD camera",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Dell",
                "Precision 5680",
                4.8,
                42990000,
                8,
                "Mobile workstation dengan sertifikasi ISV untuk aplikasi profesional. Dilengkapi dengan NVIDIA RTX GPU professional series.",
                "Intel Core i9-13900HX (24 core, 32 thread)",
                "128GB DDR5 5600MHz",
                "8TB SSD (Dual 4TB RAID 0)",
                "16\" 4K OLED Touch (3840x2400) 120Hz 400nit",
                "NVIDIA RTX 5000 Ada 16GB GDDR6",
                "Windows 11 Pro",
                "96Wh (hingga 10 jam)",
                "2.3 kg",
                "2024",
                "4x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.1, Smart card reader",
                "Wi-Fi 7, Bluetooth 5.4, FHD IR camera",
                "https://images.unsplash.com/photo-1593640408182-31c70c8268f5?w=800&auto=format&fit=crop"
        ));

        // ========== HP (12 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "HP",
                "Spectre x360 14 (2024)",
                4.8,
                23990000,
                16,
                "Laptop convertible premium dengan layar OLED 2.8K. Desain gem-cut dengan diamond-cut edges dan security features lengkap.",
                "Intel Core Ultra 7 155H (16 core, 22 thread)",
                "32GB LPDDR5x 7467MHz",
                "2TB PCIe 4.0 SSD",
                "14\" 2.8K OLED (2880x1800) 120Hz 400nit",
                "Intel Arc Graphics (8 Xe cores)",
                "Windows 11 Home",
                "66Wh (hingga 16 jam)",
                "1.37 kg",
                "2024",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 7, Bluetooth 5.4, 5MP IR camera dengan privacy shutter",
                "https://images.unsplash.com/photo-1499951360447-b19be8fe80f5?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "HP",
                "Omen Transcend 16 (2024)",
                4.9,
                29990000,
                10,
                "Laptop gaming dengan layar Mini LED 240Hz dan performa ekstrem. Desain minimalis dengan RGB lighting subtle.",
                "Intel Core i9-14900HX (24 core, 32 thread)",
                "32GB DDR5 5600MHz",
                "2TB PCIe 4.0 SSD",
                "16\" Mini LED (2560x1600) 240Hz 1200nit",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "97Wh (hingga 9 jam)",
                "2.1 kg",
                "2024",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.1, Mini DisplayPort",
                "Wi-Fi 7, Bluetooth 5.4, FHD camera dengan temporal noise reduction",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "HP",
                "Envy x360 15 (2024)",
                4.6,
                18990000,
                18,
                "Laptop convertible dengan layar besar 15.6-inch dan stylus support. Ideal untuk digital note taking dan creative work.",
                "AMD Ryzen 7 8840HS (8 core, 16 thread)",
                "16GB LPDDR5x 6400MHz",
                "1TB PCIe 4.0 SSD",
                "15.6\" 4K OLED Touch (3840x2160) 60Hz 400nit",
                "AMD Radeon 780M Graphics",
                "Windows 11 Home",
                "83Wh (hingga 14 jam)",
                "1.78 kg",
                "2024",
                "2x USB-C 4.0, 2x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 6E, Bluetooth 5.3, FHD camera dengan HP Presence",
                "https://images.unsplash.com/photo-1499951360447-b19be8fe80f5?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "HP",
                "Victus 16 (2024)",
                4.5,
                13990000,
                22,
                "Laptop gaming entry-level dengan desain modern dan performa solid untuk gaming 1080p. Keyboard dengan backlight green.",
                "AMD Ryzen 5 7640HS (6 core, 12 thread)",
                "16GB DDR5 5600MHz",
                "1TB PCIe 4.0 SSD",
                "16.1\" FHD (1920x1080) 144Hz 250nit",
                "NVIDIA GeForce RTX 4050 6GB GDDR6",
                "Windows 11 Home",
                "70Wh (hingga 8 jam gaming)",
                "2.46 kg",
                "2024",
                "2x USB-A 3.2, 1x USB-C 3.2, HDMI 2.1, Ethernet",
                "Wi-Fi 6E, Bluetooth 5.3, 720p HD camera",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "HP",
                "ZBook Firefly 14 G10",
                4.7,
                24990000,
                14,
                "Mobile workstation dengan performa solid dan portabilitas tinggi. Sertifikasi ISV untuk aplikasi profesional.",
                "Intel Core i7-1370P (14 core, 20 thread)",
                "32GB DDR5 5200MHz",
                "2TB PCIe 4.0 SSD",
                "14\" 4K OLED (3840x2400) 400nit",
                "NVIDIA RTX 2000 Ada 8GB GDDR6",
                "Windows 11 Pro",
                "64Wh (hingga 14 jam)",
                "1.44 kg",
                "2024",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.1, Smart card reader",
                "Wi-Fi 6E, Bluetooth 5.3, FHD IR camera",
                "https://images.unsplash.com/photo-1499951360447-b19be8fe80f5?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "HP",
                "Pavilion Plus 14",
                4.4,
                11990000,
                28,
                "Laptop everyday dengan layar OLED 2.8K dan performa cukup untuk productivity. Desain stylish dengan multiple color options.",
                "AMD Ryzen 5 7640U (6 core, 12 thread)",
                "16GB LPDDR5x 6400MHz",
                "512GB PCIe 4.0 SSD",
                "14\" 2.8K OLED (2880x1800) 90Hz 400nit",
                "AMD Radeon 760M Graphics",
                "Windows 11 Home",
                "51Wh (hingga 10 jam)",
                "1.4 kg",
                "2024",
                "2x USB-C 4.0, 2x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 6E, Bluetooth 5.3, FHD camera",
                "https://images.unsplash.com/photo-1499951360447-b19be8fe80f5?w=800&auto=format&fit=crop"
        ));

        // ========== ACER (10 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "Acer",
                "Predator Helios 18 (2024)",
                4.8,
                32990000,
                9,
                "Laptop gaming 18-inch dengan layar Mini LED 250Hz. Cooling system 5th Gen AeroBlade 3D Fan dengan liquid metal thermal compound.",
                "Intel Core i9-14900HX (24 core, 32 thread)",
                "32GB DDR5 5600MHz",
                "4TB PCIe 4.0 SSD (RAID 0)",
                "18\" Mini LED (2560x1600) 250Hz 1000nit",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "90Wh (hingga 6 jam gaming)",
                "3.0 kg",
                "2024",
                "3x USB-A 3.2, 2x Thunderbolt 4, HDMI 2.1, Ethernet",
                "Killer Wi-Fi 7, Bluetooth 5.3, FHD camera",
                "https://images.unsplash.com/photo-1606293459205-7cd73e0a2c4d?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Acer",
                "Swift Edge 16 (2024)",
                4.6,
                16990000,
                16,
                "Laptop ultrabook 16-inch dengan bodi magnesium-aluminum hanya 1.23kg. Layar OLED 4K dengan color accuracy tinggi.",
                "AMD Ryzen 7 8840U (8 core, 16 thread)",
                "32GB LPDDR5 6400MHz",
                "2TB PCIe 4.0 SSD",
                "16\" 4K OLED (3840x2400) 120Hz 500nit",
                "AMD Radeon 780M Graphics",
                "Windows 11 Home",
                "54Wh (hingga 12 jam)",
                "1.23 kg",
                "2024",
                "2x USB-C 4.0, 2x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 7, Bluetooth 5.3, FHD camera dengan Acer PurifiedVoice",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Acer",
                "Nitro 16 (2024)",
                4.5,
                14990000,
                20,
                "Laptop gaming dengan performa value for money. Dilengkapi dengan NitroSense untuk performance monitoring dan control.",
                "AMD Ryzen 7 7840HS (8 core, 16 thread)",
                "16GB DDR5 5600MHz",
                "1TB PCIe 4.0 SSD",
                "16\" QHD (2560x1600) 165Hz 500nit",
                "NVIDIA GeForce RTX 4060 8GB GDDR6",
                "Windows 11 Home",
                "90Wh (hingga 8 jam gaming)",
                "2.5 kg",
                "2024",
                "2x USB-A 3.2, 1x USB-C 3.2, HDMI 2.1, Ethernet",
                "Killer Wi-Fi 6E, Bluetooth 5.2, HD camera",
                "https://images.unsplash.com/photo-1606293459205-7cd73e0a2c4d?w=800&auto=format&fit=crop"
        ));

        // ========== MSI (10 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "MSI",
                "Raider GE78 HX (2024)",
                4.9,
                41990000,
                7,
                "Laptop gaming flagship dengan layar Mini LED 240Hz dan mechanical keyboard per-key RGB. Cooling system Cooler Boost Titan.",
                "Intel Core i9-14900HX (24 core, 32 thread)",
                "64GB DDR5 5600MHz",
                "4TB NVMe SSD (Dual 2TB RAID 0)",
                "17\" Mini LED (2560x1600) 240Hz 1000nit",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "99.9Wh (hingga 7 jam gaming)",
                "3.0 kg",
                "2024",
                "3x USB-A 3.2, 2x Thunderbolt 4, HDMI 2.1, Ethernet",
                "Killer Wi-Fi 7, Bluetooth 5.4, FHD camera",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "MSI",
                "Stealth 16 Studio (2024)",
                4.7,
                27990000,
                12,
                "Laptop creator/gaming hybrid dengan desain professional dan performa tinggi. Dilengkapi dengan MSI True Color technology.",
                "Intel Core Ultra 9 185H (16 core, 22 thread)",
                "32GB LPDDR5x 6400MHz",
                "2TB PCIe 5.0 SSD",
                "16\" QHD+ (2560x1600) 240Hz 500nit",
                "NVIDIA GeForce RTX 4070 8GB GDDR6",
                "Windows 11 Pro",
                "99.9Wh (hingga 10 jam)",
                "1.99 kg",
                "2024",
                "2x Thunderbolt 4, 2x USB-A 3.2, HDMI 2.1, SD card reader",
                "Wi-Fi 7, Bluetooth 5.4, FHD camera dengan Windows Hello",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        // ========== RAZER (8 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "Razer",
                "Blade 18 (2024)",
                4.9,
                52990000,
                5,
                "Laptop gaming 18-inch dengan layar Dual Mode 4K/1080p. Build quality premium dengan chassis CNC aluminum.",
                "Intel Core i9-14900HX (24 core, 32 thread)",
                "64GB DDR5 5600MHz",
                "4TB SSD (Dual 2TB NVMe)",
                "18\" Dual Mode Mini LED (3840x2400/1920x1200) 120Hz/240Hz",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "95.2Wh (hingga 6 jam gaming)",
                "2.86 kg",
                "2024",
                "3x USB-A 3.2, 2x Thunderbolt 4, HDMI 2.1, SD card reader",
                "Wi-Fi 7, Bluetooth 5.4, FHD camera dengan Windows Hello",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        laptops.add(new Laptop(
                "Razer",
                "Blade 14 (2024)",
                4.8,
                32990000,
                10,
                "Laptop gaming 14-inch dengan performa maksimal dalam form factor compact. Dilengkapi dengan vapor chamber cooling.",
                "AMD Ryzen 9 8945HS (8 core, 16 thread)",
                "32GB DDR5 5600MHz",
                "2TB PCIe 4.0 SSD",
                "14\" QHD (2560x1600) 240Hz 500nit",
                "NVIDIA GeForce RTX 4070 8GB GDDR6",
                "Windows 11 Home",
                "68.1Wh (hingga 10 jam)",
                "1.84 kg",
                "2024",
                "2x USB-C 4.0, 2x USB-A 3.2, HDMI 2.1, SD card reader",
                "Wi-Fi 7, Bluetooth 5.4, FHD camera",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        // ========== GIGABYTE/AORUS (8 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "Gigabyte",
                "AORUS 17X (2024)",
                4.8,
                44990000,
                6,
                "Laptop gaming dengan cooling system WINDFORCE Infinity dan mechanical keyboard. Performa ekstrem untuk hardcore gamers.",
                "Intel Core i9-14900HX (24 core, 32 thread)",
                "64GB DDR5 5600MHz",
                "4TB SSD (Dual 2TB NVMe RAID 0)",
                "17.3\" QHD (2560x1440) 240Hz 300nit",
                "NVIDIA GeForce RTX 4090 16GB GDDR6",
                "Windows 11 Home",
                "99Wh (hingga 5 jam gaming)",
                "3.2 kg",
                "2024",
                "3x USB-A 3.2, 1x Thunderbolt 4, 1x USB-C 3.2, HDMI 2.1, Ethernet",
                "Killer Wi-Fi 7, Bluetooth 5.4, FHD camera",
                "https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&auto=format&fit=crop"
        ));

        // ========== MICROSOFT SURFACE (6 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "Microsoft",
                "Surface Laptop Studio 2",
                4.7,
                38990000,
                10,
                "Laptop convertible dengan dynamic woven hinge untuk mode laptop, studio, dan canvas. Ideal untuk creative professional.",
                "Intel Core i7-13700H (14 core, 20 thread)",
                "64GB LPDDR5x 6400MHz",
                "2TB PCIe 4.0 SSD",
                "14.4\" PixelSense Flow (2400x1600) 120Hz Touch",
                "NVIDIA GeForce RTX 4060 8GB GDDR6",
                "Windows 11 Pro",
                "58Wh (hingga 18 jam)",
                "1.98 kg",
                "2024",
                "2x Thunderbolt 4, 1x USB-A 3.2, Surface Connect",
                "Wi-Fi 6E, Bluetooth 5.1, 1080p Windows Hello camera",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
        ));

        // ========== SAMSUNG (6 LAPTOP TERLARIS) ==========
        laptops.add(new Laptop(
                "Samsung",
                "Galaxy Book4 Ultra",
                4.7,
                27990000,
                12,
                "Laptop premium dengan ecosystem integration Samsung Galaxy. Layar Dynamic AMOLED 2X dengan color accuracy tinggi.",
                "Intel Core Ultra 7 155H (16 core, 22 thread)",
                "32GB LPDDR5x 7467MHz",
                "1TB PCIe 4.0 SSD",
                "16\" Dynamic AMOLED 2X (2880x1800) 120Hz 400nit",
                "NVIDIA GeForce RTX 4050 6GB GDDR6",
                "Windows 11 Home",
                "76Wh (hingga 17 jam)",
                "1.86 kg",
                "2024",
                "2x Thunderbolt 4, 1x USB-A 3.2, HDMI 2.1, MicroSD",
                "Wi-Fi 6E, Bluetooth 5.3, FHD camera",
                "https://images.unsplash.com/photo-1547082299-de196ea013d6?w=800&auto=format&fit=crop"
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

    public static ArrayList<Laptop> getBestSellingLaptops() {
        ArrayList<Laptop> allLaptops = getLaptopList();
        ArrayList<Laptop> bestSellers = new ArrayList<>();

        // Filter laptop dengan rating >= 4.7 dan stock > 5
        for (Laptop laptop : allLaptops) {
            if (laptop.getRating() >= 4.7 && laptop.getStock() > 5) {
                bestSellers.add(laptop);
            }
        }

        // Urutkan berdasarkan rating (descending) dan harga (ascending)
        Collections.sort(bestSellers, new Comparator<Laptop>() {
            @Override
            public int compare(Laptop l1, Laptop l2) {
                // Pertama urutkan rating descending
                int ratingCompare = Double.compare(l2.getRating(), l1.getRating());
                if (ratingCompare != 0) return ratingCompare;

                // Jika rating sama, urutkan harga ascending
                return Integer.compare(l1.getPrice(), l2.getPrice());
            }
        });

        // Ambil maksimal 8 laptop terbaik
        int maxItems = Math.min(8, bestSellers.size());
        return new ArrayList<>(bestSellers.subList(0, maxItems));
    }

    public static ArrayList<String> getAllBrands() {
        ArrayList<String> brands = new ArrayList<>();
        brands.add("Lenovo");
        brands.add("Apple");
        brands.add("ASUS");
        brands.add("Dell");
        brands.add("HP");
        brands.add("Acer");
        brands.add("MSI");
        brands.add("Razer");
        brands.add("Gigabyte");
        brands.add("Microsoft");
        brands.add("Samsung");
        return brands;
    }
}