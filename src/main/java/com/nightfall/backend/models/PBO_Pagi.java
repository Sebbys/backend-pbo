package com.nightfall.backend.models;

import java.math.BigDecimal;

public class PBO_Pagi {
    private Long id;
    private String nama;
    private String alamat;
    private BigDecimal telepon;

    public PBO_Pagi(Long id, String nama, String alamat, BigDecimal telepon) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public BigDecimal getTelepon() {
        return telepon;
    }

    public void setTelepon(BigDecimal telepon) {
        this.telepon = telepon;
    }
}
