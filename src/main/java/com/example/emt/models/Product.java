package com.example.emt.models;

import javax.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String description;
    private String technology;
    private String announced;
    private String dimensions;
    private String weight;
    private String build;
    private String os;
    private String chipset;
    private String cpu;
    private String gpu;
    private String mainCamera;
    private String selfieCamera;
    private String wlan;
    private String bluetooth;
    private boolean gps;
    private boolean nfc;
    private boolean radio;
    private String sensors;
    private String batteryType;
    private String batteryLife;
    private String link;
    private Integer price;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Manufacturer manufacturer;


    public Product(String name, String description, String technology, String announced, String dimensions, String weight, String build, String os, String chipset, String cpu, String gpu, String mainCamera, String selfieCamera, String wlan, String bluetooth, boolean gps, boolean nfc, boolean radio, String sensors, String batteryType, String batteryLife, String link, Integer price, Category category, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.technology = technology;
        this.announced = announced;
        this.dimensions = dimensions;
        this.weight = weight;
        this.build = build;
        this.os = os;
        this.chipset = chipset;
        this.cpu = cpu;
        this.gpu = gpu;
        this.mainCamera = mainCamera;
        this.selfieCamera = selfieCamera;
        this.wlan = wlan;
        this.bluetooth = bluetooth;
        this.gps = gps;
        this.nfc = nfc;
        this.radio = radio;
        this.sensors = sensors;
        this.batteryType = batteryType;
        this.batteryLife = batteryLife;
        this.link = link;
        this.price = price;
        this.category = category;
        this.manufacturer = manufacturer;
    }

    public Product(){}

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getAnnounced() {
        return announced;
    }

    public void setAnnounced(String announced) {
        this.announced = announced;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(String mainCamera) {
        this.mainCamera = mainCamera;
    }

    public String getSelfieCamera() {
        return selfieCamera;
    }

    public void setSelfieCamera(String selfieCamera) {
        this.selfieCamera = selfieCamera;
    }

    public String getWlan() {
        return wlan;
    }

    public void setWlan(String wlan) {
        this.wlan = wlan;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isNfc() {
        return nfc;
    }

    public void setNfc(boolean nfc) {
        this.nfc = nfc;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public String getSensors() {
        return sensors;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }

    public String getbatteryType() {
        return batteryType;
    }

    public void setbatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getbatteryLife() {
        return batteryLife;
    }

    public void setbatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
