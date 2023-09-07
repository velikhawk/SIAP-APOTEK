package sistem_akuntansi.entity;

import java.util.Date;

/**
 *
 * @author VELIK
 */
public class Penjualan {
    private String nomor;
    private String kode_pelanggan;
    private Date tanggal;
    private Integer total;
    
    private PenjualanDetail penjualanDetail;

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getKode_pelanggan() {
        return kode_pelanggan;
    }

    public void setKode_pelanggan(String kode_pelanggan) {
        this.kode_pelanggan = kode_pelanggan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public PenjualanDetail getPenjualanDetail() {
        return penjualanDetail;
    }

    public void setPenjualanDetail(PenjualanDetail penjualanDetail) {
        this.penjualanDetail = penjualanDetail;
    }

}
