/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.entity;

import java.util.Date;

/**
 *
 * @author VELIK
 */
public class MutasiObat {
    private Integer id;
    private Date tanggal;
    private String nomor_bukti;
    private String keterangan;
    private String kode_obat;
    private Integer masuk_kuantiti;
    private Integer masuk_jumlah;
    private Integer keluar_kuantiti;
    private Integer keluar_jumlah;
    
    private Barang barang;

    public MutasiObat() {
        this.barang = new Barang();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getNomor_bukti() {
        return nomor_bukti;
    }

    public void setNomor_bukti(String nomor_bukti) {
        this.nomor_bukti = nomor_bukti;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKode_obat() {
        return kode_obat;
    }

    public void setKode_obat(String kode_obat) {
        this.kode_obat = kode_obat;
    }

    public Integer getMasuk_kuantiti() {
        return masuk_kuantiti;
    }

    public void setMasuk_kuantiti(Integer masuk_kuantiti) {
        this.masuk_kuantiti = masuk_kuantiti;
    }

    public Integer getMasuk_jumlah() {
        return masuk_jumlah;
    }

    public void setMasuk_jumlah(Integer masuk_jumlah) {
        this.masuk_jumlah = masuk_jumlah;
    }

    public Integer getKeluar_kuantiti() {
        return keluar_kuantiti;
    }

    public void setKeluar_kuantiti(Integer keluar_kuantiti) {
        this.keluar_kuantiti = keluar_kuantiti;
    }

    public Integer getKeluar_jumlah() {
        return keluar_jumlah;
    }

    public void setKeluar_jumlah(Integer keluar_jumlah) {
        this.keluar_jumlah = keluar_jumlah;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }
    
}
