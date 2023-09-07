/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.entity;

/**
 *
 * @author arochman.aryanta
 */
public class KasMasukDetail {
    private Integer id;
    private String kode_rekening;
    private Integer jumlah;
    private String header_nomor;
    
    private Perkiraan perkiraan;

    public KasMasukDetail() {
        this.perkiraan = new Perkiraan();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode_rekening() {
        return kode_rekening;
    }

    public void setKode_rekening(String kode_rekening) {
        this.kode_rekening = kode_rekening;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getHeader_nomor() {
        return header_nomor;
    }

    public void setHeader_nomor(String header_nomor) {
        this.header_nomor = header_nomor;
    }

    public Perkiraan getPerkiraan() {
        return perkiraan;
    }

    public void setPerkiraan(Perkiraan perkiraan) {
        this.perkiraan = perkiraan;
    }
    
}
