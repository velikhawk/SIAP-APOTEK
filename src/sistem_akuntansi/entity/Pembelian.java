package sistem_akuntansi.entity;

import java.util.Date;

/**
 *
 * @author VELIK
 */
public class Pembelian {
    private String nofaktur;
    private Date tanggal;
    private String kode_pbf;
    private Integer total;

    public String getNofaktur() {
        return nofaktur;
    }

    public void setNofaktur(String nofaktur) {
        this.nofaktur = nofaktur;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKode_pbf() {
        return kode_pbf;
    }

    public void setKode_pbf(String kode_pbf) {
        this.kode_pbf = kode_pbf;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
}
