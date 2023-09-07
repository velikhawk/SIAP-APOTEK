/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.entity;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author arochman.aryanta
 */
public class KasMasuk {
    private String nomor;
    private Date tanggal;
    private String keterangan;
    private String kode_rekening_kas;
    private Integer total;
    
    private Perkiraan perkiraan;
    private Vector<KasMasukDetail> kasMasukDetail;
    
    public KasMasuk() {
        this.perkiraan = new Perkiraan();
        this.kasMasukDetail = new Vector<KasMasukDetail>();
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKode_rekening_kas() {
        return kode_rekening_kas;
    }

    public void setKode_rekening_kas(String kode_rekening_kas) {
        this.kode_rekening_kas = kode_rekening_kas;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Perkiraan getPerkiraan() {
        return perkiraan;
    }

    public void setPerkiraan(Perkiraan perkiraan) {
        this.perkiraan = perkiraan;
    }

    public Vector<KasMasukDetail> getKasMasukDetail() {
        return kasMasukDetail;
    }

    public void setKasMasukDetail(Vector<KasMasukDetail> kasMasukDetail) {
        this.kasMasukDetail = kasMasukDetail;
    }
    
    
}
