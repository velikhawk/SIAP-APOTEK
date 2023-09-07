/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.entity;

import java.util.Date;

/**
 *
 * @author arochman.aryanta
 */
public class JurnalTransaksi {
    private Integer id;
    private Date tanggal;
    private String nomor_bukti;
    private String keterangan;
    private String kode_rekening;
    private String tipe;
    private Integer debet;
    private Integer kredit;
    
    private Perkiraan perkiraan;

    public JurnalTransaksi() {
        this.perkiraan = new Perkiraan();
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

    public String getKode_rekening() {
        return kode_rekening;
    }

    public void setKode_rekening(String kode_rekening) {
        this.kode_rekening = kode_rekening;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public Integer getDebet() {
        return debet;
    }

    public void setDebet(Integer debet) {
        this.debet = debet;
    }

    public Integer getKredit() {
        return kredit;
    }

    public void setKredit(Integer kredit) {
        this.kredit = kredit;
    }

    public Perkiraan getPerkiraan() {
        return perkiraan;
    }

    public void setPerkiraan(Perkiraan perkiraan) {
        this.perkiraan = perkiraan;
    }

    
}
