/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.entity;


/**
 *
 * @author arochman aryanta
 */
public class Perkiraan {
    private String kode;
    private String nama;
    private Integer kelompok;
    private String tipe;
    private Double saldo_akhir;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getKelompok() {
        return kelompok;
    }

    public void setKelompok(Integer kelompok) {
        this.kelompok = kelompok;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public Double getSaldo_akhir() {
        return saldo_akhir;
    }

    public void setSaldo_akhir(Double saldo_akhir) {
        this.saldo_akhir = saldo_akhir;
    }

    

    
}
