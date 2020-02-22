package com.tae.myapplication.entity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MotoPojo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("engineVolume")
    @Expose
    private Integer engineVolume;
    @SerializedName("idDriver")
    @Expose
    private Object idDriver;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Integer engineVolume) {
        this.engineVolume = engineVolume;
    }

    public Object getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Object idDriver) {
        this.idDriver = idDriver;
    }

}