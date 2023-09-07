package sistem_akuntansi.entity;

import java.util.Date;

/**
 *
 * @author VELIK
 */
public class Barang {
    private String kode_obat;
    private String nama_obat;
    private String kode_jenis;
    private Date tanggal_kadaluwarsa;
    private Integer jumlah;
    private Integer harga_beli;
    private Integer harga_jual;

    public String getKode_obat() {
        return kode_obat;
    }

    public void setKode_obat(String kode_obat) {
        this.kode_obat = kode_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getKode_jenis() {
        return kode_jenis;
    }

    public void setKode_jenis(String kode_jenis) {
        this.kode_jenis = kode_jenis;
    }

    public Date getTanggal_kadaluwarsa() {
        return tanggal_kadaluwarsa;
    }

    public void setTanggal_kadaluwarsa(Date tanggal_kadaluwarsa) {
        this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(Integer harga_beli) {
        this.harga_beli = harga_beli;
    }

    public Integer getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(Integer harga_jual) {
        this.harga_jual = harga_jual;
    }

}
