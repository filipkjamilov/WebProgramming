package com.example.emt.web.view;

import com.example.emt.models.*;
import com.example.emt.models.exceptions.CategoryNotFound;
import com.example.emt.models.exceptions.ManufacturerNotFoundException;
import com.example.emt.models.exceptions.ProductNotFoundException;
import com.example.emt.service.*;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class webController {


    private final ProductService productService;

    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;
    private final TransactionService transactionService;

    public webController(ProductService productService, ManufacturerService manufacturerService, CategoryService categoryService, TransactionService transactionService) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
        this.categoryService = categoryService;
        this.transactionService = transactionService;
    }


        @PostConstruct
        public void init(){

        productService.deleteAll();
        categoryService.deleteAll();
        manufacturerService.deleteAll();


        Category smart_phone = categoryService.save(new Category("Smart phone"));
        Category tablet = categoryService.save(new Category("Tablet"));
        Category laptop = categoryService.save(new Category("Laptop"));


        Manufacturer Alcatel = manufacturerService.save(new Manufacturer("Alcatel", "Macedonia"));
        Manufacturer Google = manufacturerService.save(new Manufacturer("Google", "Macedonia"));
        Manufacturer Apple = manufacturerService.save(new Manufacturer("Apple","Macedonia"));
        Manufacturer CAT = manufacturerService.save(new Manufacturer("CAT","Macedonia"));
        Manufacturer Honor = manufacturerService.save(new Manufacturer("Honor","Macedonia"));
        Manufacturer HTC = manufacturerService.save(new Manufacturer("HTC","Macedonia"));
        Manufacturer Huawei = manufacturerService.save(new Manufacturer("Huawei","Macedonia"));
        Manufacturer Lenovo = manufacturerService.save(new Manufacturer("Lenovo","Macedonia"));
        Manufacturer Motorola = manufacturerService.save(new Manufacturer("Motorola","Macedonia"));
        Manufacturer Nokia = manufacturerService.save(new Manufacturer("Nokia","Macedonia"));
        Manufacturer Samsung = manufacturerService.save(new Manufacturer("Samsung","Macedonia"));
        Manufacturer Sony = manufacturerService.save(new Manufacturer("Sony Mobile","Macedonia"));
        Manufacturer Xiaomi = manufacturerService.save(new Manufacturer("Xiaomi","Macedonia"));


        productService.save(new Product("Samsung Galaxy M31","Samsung Galaxy M31","GSM / HSPA / LTE", "2020, February 25", "159.2 x 75.1 x 8.9 mm (6.27 x 2.96 x 0.35 in)", "191 g (6.74 oz)", "Glass front (Gorilla Glass 3), plastic back, plastic frame", "Android 10.0; One UI 2.0", "Exynos 9611 (10nm)", "Octa-core (4x2.3 GHz Cortex-A73 & 4x1.7 GHz Cortex-A53)", "Mali-G72 MP3", "64 MP, f/1.8, 26mm (wide), 1/1.72\", 0.8µm, PDAF // 8 MP, f/2.2, 12mm (ultrawide), 1/4.0\", 1.12µm // 5 MP, f/2.4, 25mm (macro), 1/5.0\", 1.12µm // 5 MP, f/2.2, (depth) // LED flash, panorama, HDR // 2160p@30fps, 1080p@30fps, gyro-EIS", "32 MP, f/2.0, 26mm (wide), 1/2.8\", 0.8µm // 2160p@30fps, 1080p@30fps", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", "5.0, A2DP, LE", true,true,true, "Fingerprint (rear-mounted), accelerometer, gyro, proximity, compass", "Non-removable Li-Po 6000 mAh battery", "Fast charging 15W", "https://tinyurl.com/sumckc2", 280, smart_phone, Samsung));
            productService.save(new Product("Samsung Galaxy S20","Samsung Galaxy S20","GSM / CDMA / HSPA / EVDO / LTE / 5G", "2020, February 11", "166.9 x 76 x 8.8 mm (6.57 x 2.99 x 0.35 in)", "222 g (7.83 oz)", "Glass front (Gorilla Glass 6), glass back (Gorilla Glass 6), aluminum frame", "Android 10.0; One UI 2", "Exynos 990 (7 nm+) - Global", "Octa-core (2x2.73 GHz Mongoose M5 & 2x2.50 GHz Cortex-A76 & 4x2.0 GHz Cortex-A55) - Global" +
                    "Octa-core (1x2.84 GHz Kryo 585 & 3x2.42 GHz Kryo 585 & 4x1.8 GHz Kryo 585) - USA", "Mali-G77 MP11 - Global" +
                    "Adreno 650 - USA", "108 MP, f/1.8, 26mm (wide), 1/1.33\", 0.8µm, PDAF, OIS // Periscope 48 MP, f/3.5, 103mm (telephoto), 1/2.0\", 0.8µm, PDAF, OIS, 10x hybrid optical zoom // 12 MP, f/2.2, 13mm (ultrawide), 1.4µm, Super Steady video // 0.3 MP, TOF 3D, f/1.0, (depth)", "40 MP, f/2.2, 26mm (wide), 0.7µm, PDAF // Dual video call, Auto-HDR" +
                    "2160p@30/60fps, 1080p@30fps", "Wi-Fi 802.11 a/b/g/n/ac/ax, dual-band, Wi-Fi Direct, hotspot", "5.0, A2DP, LE", true,true,true, "Fingerprint (under display, ultrasonic), accelerometer, gyro, proximity, compass, barometer // ANT+ // Bixby natural language commands and dictation // Samsung DeX (desktop experience support)", "Non-removable Li-Po 5000 mAh battery // Fast charging 45W // USB Power Delivery 3.0 // Fast Qi/PMA wireless charging 15W // Power bank/Reverse wireless charging 9W", "Endurance rating 87h", "https://tinyurl.com/tucvjmf", 1400, smart_phone, Samsung));
            productService.save(new Product("Samsung Galaxy S20+","Samsung Galaxy S20+","GSM / CDMA / HSPA / EVDO / LTE / 5G", "2020, February 11", "161.9 x 73.7 x 7.8 mm (6.37 x 2.90 x 0.31 in)", "188 g (6.63 oz)", "Glass front (Gorilla Glass 6), glass back (Gorilla Glass 6), aluminum frame", "Android 10.0; One UI 2", "Exynos 990 (7 nm+) - Global // Qualcomm SM8250 Snapdragon 865 (7 nm+) - USA", "Octa-core (2x2.73 GHz Mongoose M5 & 2x2.50 GHz Cortex-A76 & 4x2.0 GHz Cortex-A55) - Global // Octa-core (1x2.84 GHz Kryo 585 & 3x2.42 GHz Kryo 585 & 4x1.8 GHz Kryo 585) - USA", "Mali-G77 MP11 - Global // Adreno 650 - USA", "12 MP, f/1.8, 26mm (wide), 1/1.76\", 1.8µm, Dual Pixel PDAF, OIS // 64 MP, f/2.0, (telephoto), 1/1.72\", 0.8µm, PDAF, OIS, 3x hybrid optical zoom", "10 MP, f/2.2, 26mm (wide), 1/3.2\", 1.22µm, Dual Pixel PDAF // Dual video call, Auto-HDR // 2160p@30/60fps, 1080p@30fps", "Wi-Fi 802.11 a/b/g/n/ac/ax, dual-band, Wi-Fi Direct, hotspot", "5.0, A2DP, LE", true,true,true, "Fingerprint (under display, ultrasonic), accelerometer, gyro, proximity, compass, barometer // ANT+ // Bixby natural language commands and dictation // Samsung DeX (desktop experience support)", "Non-removable Li-Po 4500 mAh battery // Fast charging 25W // USB Power Delivery 3.0 // Fast Qi/PMA wireless charging 15W // Power bank/Reverse wireless charging 9W", "Around 55h", "https://tinyurl.com/scd9nds", 930, smart_phone, Samsung));
            productService.save(new Product("Samsung Galaxy Z Flip","Samsung Galaxy Z Flip","GSM / HSPA / LTE", "2020, February 11", "Unfolded: 167.3 x 73.6 x 7.2 mm // Folded: 87.4 x 73.6 x 17.3 mm", "183 g (6.46 oz)", "Plastic front, glass back (Gorilla Glass 6), aluminum frame", "Android 10.0; One UI 2", "Qualcomm SM8150 Snapdragon 855+ (7 nm)", "Octa-core (1x2.95 GHz Kryo 485 & 3x2.41 GHz Kryo 485 & 4x1.78 GHz Kryo 485)", "Adreno 640 (700 MHz)", "12 MP, f/1.8, 27mm (wide), 1/2.55\", 1.4µm, Dual Pixel PDAF, OIS // 12 MP, f/2.2, 12mm (ultrawide), 1.12µm ", "10 MP, f/2.4, 26mm (wide), 1.22µm // HDR // 2160p@30fps", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", "5.0, A2DP, LE", true,true,false, "Fingerprint (side-mounted), accelerometer, gyro, proximity, compass, barometer", "Non-removable Li-Po 3300 mAh battery // Fast charging 15W // Wireless charging", "Around 84h", "https://tinyurl.com/w2j9r7u", 1330, smart_phone, Samsung));
            productService.save(new Product("Samsung Galaxy A71","Samsung Galaxy A71","GSM / HSPA / LTE", "2019, December", "163.6 x 76 x 7.7 mm (6.44 x 2.99 x 0.30 in)", "179 g (6.31 oz)", "Glass front (Gorilla Glass 3), plastic back, plastic frame", "Android 10.0; One UI 2", "Qualcomm SDM730 Snapdragon 730 (8 nm) - Global // Qualcomm SDM730 Snapdragon 730G (8 nm) - Philippines", "Octa-core (2x2.2 GHz Kryo 470 Gold & 6x1.8 GHz Kryo 470 Silver)", "Adreno 618", "64 MP, f/1.8, 26mm (wide), 1/1.72\", 0.8µm, PDAF // 12 MP, f/2.2, 12mm (ultrawide) // 5 MP, f/2.4, 25mm (macro), 1/5.0\", 1.12µm // 5 MP, f/2.2, (depth)", "32 MP, f/2.2, 26mm (wide), 1/2.8\", 0.8µm // HDR // 1080p@30fp", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", "5.0, A2DP, LE", true,true,true, "Fingerprint (under display, optical), accelerometer, gyro, proximity, compass // ANT+", "Non-removable Li-Po 4500 mAh battery // Fast charging 25W", "Endurance rating 102h", "https://tinyurl.com/seovcb6", 385, smart_phone, Samsung));
            productService.save(new Product("Apple iPad Pro 12.9","Apple iPad Pro 12.9","GSM / CDMA / HSPA / EVDO / LTE", "2020, March 18", "280.6 x 214.9 x 5.9 mm (11.05 x 8.46 x 0.23 in)", "641 g (Wi-Fi), 643 g (LTE) (1.41 lb)", "Glass front, aluminum back, aluminum frame", "iPadOS 13.4", "Apple A12Z Bionic", "Octa-core", "Apple GPU", "12 MP, f/1.8, (wide), 1/3\", 1.22µm, dual pixel PDAF // 10 MP, f/2.4, 11mm (ultrawide) // TOF 3D LiDAR scanner (depth)", "7 MP, f/2.2 // Face detection, HDR, panorama // 1080p@30/60fps", "Wi-Fi 802.11 a/b/g/n/ac/ax, dual-band, hotspot", "5.0, A2DP, LE, EDR", true,false,false, "Face ID, accelerometer, gyro, proximity, barometer // Siri natural language commands and dictation", "Non-removable Li-Po 9720 mAh battery (36.71 Wh) // Power Bank/Reverse charging // Fast charging 18W", "Around 260h", "https://tinyurl.com/w6dsdek", 1000, tablet, Apple));
            productService.save(new Product("Apple iPad Pro 11","Apple iPad Pro 11","GSM / CDMA / HSPA / EVDO / LTE", "2020, March 18", "247.6 x 178.5 x 5.9 mm (9.75 x 7.03 x 0.23 in)", "471 g (Wi-Fi), 473 g (LTE) (1.04 lb)", "Glass front, aluminum back, aluminum frame", "iPadOS 13.4", "Apple A12Z Bionic", "Octa-core", "Apple GPU", "12 MP, f/1.8, (wide), 1/3\", 1.22µm, dual pixel PDAF // 10 MP, f/2.4, 11mm (ultrawide) // TOF 3D LiDAR scanner (depth)", "7 MP, f/2.2 // Face detection, HDR, panorama // 1080p@30/60fps", "Wi-Fi 802.11 a/b/g/n/ac/ax, dual-band, hotspot", "5.0, A2DP, LE, EDR", true,false,false, "Face ID, accelerometer, gyro, proximity, barometer // Siri natural language commands and dictation", "Non-removable Li-Po 9720 mAh battery (36.71 Wh) // Power Bank/Reverse charging // Fast charging 18W", "Around 260h", "https://tinyurl.com/usk3ep6", 800, tablet, Apple));

            productService.save(new Product("Apple iPhone 11 Pro M","Apple iPhone 11 Pro Max","GSM / CDMA / HSPA / EVDO / LTE", "2019, September", "158 x 77.8 x 8.1 mm (6.22 x 3.06 x 0.32 in)", "226 g (7.97 oz)", "Glass front (Gorilla Glass), glass back (Gorilla Glass), stainless steel frame", "iOS 13, upgradable to iOS 13.4", "Apple A13 Bionic (7 nm+)", "Hexa-core (2x2.65 GHz Lightning + 4x1.8 GHz Thunder)", "Apple GPU (4-core graphics)", "12 MP, f/1.8, 26mm (wide), 1/2.55\", 1.4µm, dual pixel PDAF, OIS // 12 MP, f/2.0, 52mm (telephoto), 1/3.4\", 1.0µm, PDAF, OIS, 2x optical zoom // 12 MP, f/2.4, 13mm (ultrawide)", "12 MP, f/2.2, 23mm (wide) // SL 3D, (depth/biometrics sensor) // HDR // 2160p@24/30/60fps, 1080p@30/60/120fps, gyro-EIS", "Wi-Fi 802.11 a/b/g/n/ac/ax, dual-band, hotspot", "5.0, A2DP, LE", true,true,false, "Face ID, accelerometer, gyro, proximity, compass, barometer. Siri natural language commands and dictation", "Non-removable Li-Ion 3969 mAh battery (15.04 Wh). Charging: Fast charging 18W, 50% in 30 min (advertised) // USB Power Delivery 2.0 // Qi wireless charging // Talk time:Up to 20 h (multimedia) // Music play:Up to 80 h", "Endurance rating 102h", "https://tinyurl.com/vclr9wq", 1099, smart_phone, Apple));
            productService.save(new Product("Apple iPhone 11 Pro","Apple iPhone 11 Pro","GSM / CDMA / HSPA / EVDO / LTE", "2019, September", "144 x 71.4 x 8.1 mm (5.67 x 2.81 x 0.32 in)", "188 g (6.63 oz)", "Glass front (Gorilla Glass), glass back (Gorilla Glass), stainless steel frame", "iOS 13, upgradable to iOS 13.4", "Apple A13 Bionic (7 nm+)", "Hexa-core (2x2.65 GHz Lightning + 4x1.8 GHz Thunder)", "Apple GPU (4-core graphics)", "12 MP, f/1.8, 26mm (wide), 1/2.55\", 1.4µm, dual pixel PDAF, OIS // 12 MP, f/2.0, 52mm (telephoto), 1/3.4\", 1.0µm, PDAF, OIS, 2x optical zoom // 12 MP, f/2.4, 13mm (ultrawide)", "12 MP, f/2.2, 23mm (wide) // SL 3D, (depth/biometrics sensor) // HDR // 2160p@24/30/60fps, 1080p@30/60/120fps, gyro-EIS", "Wi-Fi 802.11 a/b/g/n/ac/ax, dual-band, hotspot", "5.0, A2DP, LE", true,true,false, "Face ID, accelerometer, gyro, proximity, compass, barometer. Siri natural language commands and dictation", "\t \tNon-removable Li-Ion 3046 mAh battery (11.67 Wh). Charging:Fast charging 18W, 50% in 30 min (advertised). USB Power Delivery 2.0 // Talk time:Up to 18 h (multimedia) // Music play:Up to 65 h", "Endurance rating 86h", "https://tinyurl.com/wqqnpce", 999, smart_phone, Apple));
            productService.save(new Product("Apple iPhone 11","Apple iPhone 11","GSM / CDMA / HSPA / EVDO / LTE", "2019, September", "150.9 x 75.7 x 8.3 mm (5.94 x 2.98 x 0.33 in)", "194 g (6.84 oz)", "Glass front (Gorilla Glass), glass back (Gorilla Glass), aluminum frame (7000 series)", "iOS 13, upgradable to iOS 13.4", "Apple A13 Bionic (7 nm+)", "Hexa-core (2x2.65 GHz Lightning + 4x1.8 GHz Thunder)", "Apple GPU (4-core graphics)", "12 MP, f/1.8, 26mm (wide), 1/2.55\", 1.4µm, dual pixel PDAF, OIS // 12 MP, f/2.4, 13mm (ultrawide)", "12 MP, f/2.2, 23mm (wide) // SL 3D, (depth/biometrics sensor)", "Wi-Fi 802.11 a/b/g/n/ac/ax, dual-band, hotspot", "5.0, A2DP, LE", true,true,false, "Face ID, accelerometer, gyro, proximity, compass, barometer // Siri natural language commands and dictation", "Non-removable Li-Ion 3110 mAh battery (11.91 Wh) // Charging:Fast charging 18W, 50% in 30 min (advertised) // USB Power Delivery 2.0 // Qi wireless charging // Talk time:Up to 17 h (multimedia) // Music play:Up to 65 h", "Endurance rating 94h", "https://tinyurl.com/yxbzt2ds", 699, smart_phone, Apple));
            productService.save(new Product("Xiaomi Redmi K30 Pro","Xiaomi Redmi K30 Pro","GSM / HSPA / LTE / 5G", "2020, March 24", "163.3 x 75.4 x 8.9 mm (6.43 x 2.97 x 0.35 in)", "218 g (7.69 oz)", "Glass front (Gorilla Glass 5), glass back (Gorilla Glass 5), aluminum frame", "Android 10.0; MIUI 11", "Qualcomm SM8250 Snapdragon 865 (7 nm+)", "Octa-core (1x2.84 GHz Kryo 585 & 3x2.42 GHz Kryo 585 & 4x1.80 GHz Kryo 585)", "Adreno 650", "64 MP, 26mm (wide), 1/1.72\", 0.8µm, PDAF // 5 MP, 50mm (telephoto macro), AF // 13 MP, 13mm (ultrawide) // 2 MP, (depth)", "Motorized pop-up 20 MP, (wide), 1/3.4\", 0.8µm", "Wi-Fi 802.11 a/b/g/n/ac/ax, dual-band, Wi-Fi Direct, hotspot", "5.1, A2DP, LE, aptX HD, aptX Adaptive", true,true,true, "Fingerprint (under display, optical), accelerometer, gyro, proximity, compass, barometer", "Non-removable Li-Po 4700 mAh battery // Charging:Fast charging 33W, 100% in 63 min (advertised) // USB Power Delivery // Quick Charge 4+", "Endurance rating 94h", "https://tinyurl.com/td7y4pf", 569, smart_phone, Xiaomi));
            productService.save(new Product("Xiaomi Mi Mix Alpha","Xiaomi Mi Mix Alpha","GSM / CDMA / HSPA / LTE / 5G", "2019, September", "154.4 x 72.3 x 10.4 mm (6.08 x 2.85 x 0.41 in)", "241 g (8.50 oz)", "Glass front, ceramic/glass back, titanium alloy frame (TC4)", "Android 10.0; MIUI 11", "Qualcomm SM8150 Snapdragon 855+ (7 nm)", "Octa-core (1x2.96 GHz Kryo 485 & 3x2.42 GHz Kryo 485 & 4x1.8 GHz Kryo 485)", "Adreno 640 (700 MHz)", "108 MP, f/1.7, (wide), 1/1.33\", 0.8µm, PDAF, Laser AF // 12 MP, f/2.0, 54mm (telephoto), 1/2.55\", 1.4µm, Dual Pixel PDAF, Laser AF, 2x optical zoom", "No - uses main camera", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, DLNA, hotspot", "5.0, A2DP, LE, aptX HD", true,false,false, "Fingerprint (under display, optical), accelerometer, gyro, proximity, compass, barometer", "Non-removable Li-Po 4050 mAh battery. Fast charging 40W", "Endurance rating 44h", "https://tinyurl.com/whzzlh3", 2500, smart_phone, Apple));
            productService.save(new Product("Huawei P40 Pro+","Huawei P40 Pro+","GSM / HSPA / LTE / 5G", "2020, March 26", "158.2 x 72.6 x 9 mm (6.23 x 2.86 x 0.35 in)", "226 g (7.97 oz)", "Glass front, cerramic back, cerramic frame", "Android 10.0 (AOSP + HMS); EMUI 10.1", "HiSilicon Kirin 990 5G (7 nm+)", "Octa-core (2x2.86 GHz Cortex-A76 & 2x2.36 GHz Cortex-A76 & 4x1.95 GHz Cortex-A55)", "Mali-G76 MP16", "50 MP, f/1.9, 23mm (wide), 1/1.28\", 2.44µm, omnidirectional PDAF, OIS // Periscope 8 MP, f/4.4, 240mm (telephoto), PDAF, OIS, 10x optical zoom", "32 MP, f/2.2, 26mm (wide), 1/2.8\", 0.8µm, AF // IR TOF 3D, (depth/biometrics sensor)", "Wi-Fi 802.11 a/b/g/n/ac/ax, dual-band, Wi-Fi Direct, hotspot", "5.1, A2DP, LE", true,true,false, "Infrared face recognition, fingerprint (under display, optical), accelerometer, gyro, proximity, compass, color spectrum", "Non-removable Li-Po 4200 mAh battery // Charging:Fast charging 40W // Fast wireless charging 40W // Fast reverse wireless charging 27W", "Endurance rating 84h", "https://tinyurl.com/rae673r", 1400, smart_phone, Huawei));
            productService.save(new Product("Huawei MatePad Pro","Huawei MatePad Pro 5G","GSM / HSPA / LTE / 5G", "2020, February 24", "246 x 159 x 7.2 mm (9.69 x 6.26 x 0.28 in)", "460 g (1.01 lb)", "Glass front, aluminum back, aluminum frame", "Android 10.0; EMUI 10", "HiSilicon Kirin 990 5G (7 nm+)", "Octa-core (2x2.86 GHz Cortex-A76 & 2x2.36 GHz Cortex-A76 & 4x1.95 GHz Cortex-A55)", "Mali-G76 MP16", "13 MP, f/1.8, PDAF", "8 MP, f/2.0", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", "5.1, A2DP, LE", true,false,false, "Accelerometer, gyro, proximity, compass", "Non-removable Li-Po 7250 mAh battery // Charging:Fast charging 40W // Fast wireless charging 27W // Power bank/Reverse wireless charging 7.5W", "Endurance rating 54h", "https://tinyurl.com/r9a9xta", 550, tablet, Huawei));
            productService.save(new Product("Huawei Mate Xs","Huawei Mate Xs","GSM / HSPA / LTE / 5G", "2020, February 24", "Unfolded: 161.3 x 146.2 x 5.4 mm // Folded: 161.3 x 78.5 x 11 mm", "300 g (10.58 oz)", "Plastic front, aluminum back, aluminum frame", "Android 10.0; EMUI 10.0", "HiSilicon Kirin 990 5G (7 nm+)", "Octa-core (2x2.86 GHz Cortex-A76 & 2x2.36 GHz Cortex-A76 & 4x1.95 GHz Cortex-A55)", "Mali-G76 MP16", "40 MP, f/1.8, 27mm (wide), 1/1.7\", PDAF // 8 MP, f/2.4, 52mm (telephoto) // 16 MP, f/2.2, 17mm (ultrawide) // TOF 3D, (depth)", "No - uses main camera", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, hotspot", "No - uses main camera", true,true,false, "Fingerprint (side-mounted), accelerometer, gyro, proximity, compass, barometer", "Non-removable Li-Po 4500 mAh battery // Charging:Fast charging 55W, 85% in 30 min (advertised) // Huawei SuperCharge", "Endurance rating 54h", "https://tinyurl.com/tcpsckx", 2500, smart_phone, Huawei));
            productService.save(new Product("Google Pixel 4 XL","Google Pixel 4 XL","GSM / CDMA / HSPA / EVDO / LTE", "2019, October", "160.4 x 75.1 x 8.2 mm (6.31 x 2.96 x 0.32 in)", "193 g (6.81 oz)", "Glass front (Gorilla Glass 5), glass back (Gorilla Glass 5), aluminum frame", "Android 10.0", "Qualcomm SM8150 Snapdragon 855 (7 nm)", "Octa-core (1x2.84 GHz Kryo 485 & 3x2.42 GHz Kryo 485 & 4x1.78 GHz Kryo 485)", "Adreno 640", "12.2 MP, f/1.7, 27mm (wide), 1/2.55\", 1.4µm, dual pixel PDAF, OIS // 16 MP, f/2.4, 50mm (telephoto), 1/3.6\", 1.0µm, PDAF, OIS, 2x optical zoom", "8 MP, f/2.0, 22mm (wide), 1.22µm, no AF // TOF 3D, (depth/biometrics sensor)", "Wi-Fi 802.11 a/b/g/n/ac, dual-band, Wi-Fi Direct, DLNA, hotspot", "5.0, A2DP, LE, aptX HD", true,true,false, "Face ID, accelerometer, gyro, proximity, compass, barometer", "Non-removable Li-Po 3700 mAh battery // Charging:Fast charging 18W // USB Power Delivery 2.0 // QI wireless charging", "Endurance rating 73h", "https://tinyurl.com/sfke7jn", 479, smart_phone, Google));



    }



}
