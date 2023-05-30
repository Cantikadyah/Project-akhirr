/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Model {
  private String id_transaksi;
  private String nama_customer;
  private String jenis_layanan;
  private String jumlah_berat;
  private String harga_perkilo;
  private String total_harga;

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getJenis_layanan() {
        return jenis_layanan;
    }

    public void setJenis_layanan(String jenis_layanan) {
        this.jenis_layanan = jenis_layanan;
    }

    public String getJumlah_berat() {
        return jumlah_berat;
    }

    public void setJumlah_berat(String jumlah_berat) {
        this.jumlah_berat = jumlah_berat;
    }

    public String getHarga_perkilo() {
        return harga_perkilo;
    }

    public void setHarga_perkilo(String harga_perkilo) {
        this.harga_perkilo = harga_perkilo;
    }

    public String getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(String total_harga) {
        this.total_harga = total_harga;
    }
  
}
