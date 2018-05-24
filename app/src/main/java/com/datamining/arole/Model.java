package com.datamining.arole;

public class Model {
    String barang;
    float support;

    public Model(String barang, float support) {
        this.barang = barang;
        this.support = support;
    }

    public Model(String barang) {
        this.barang = barang;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public float getSupport() {
        return support;
    }

    public void setSupport(float support) {
        this.support = support;
    }
}
