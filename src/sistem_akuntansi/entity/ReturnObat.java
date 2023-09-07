package sistem_akuntansi.entity;

import java.util.Date;

/**
 *
 * @author VELIK
 */
public class ReturnObat {
    private String nomor;
    private Date tanggal_return;
    private String kode_pbf;
    private String nofaktur;
    private Integer total;

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    

    public Date getTanggal_return() {
        return tanggal_return;
    }

    public void setTanggal_return(Date tanggal_return) {
        this.tanggal_return = tanggal_return;
    }

    public String getKode_pbf() {
        return kode_pbf;
    }

    public void setKode_pbf(String kode_pbf) {
        this.kode_pbf = kode_pbf;
    }

    public String getNofaktur() {
        return nofaktur;
    }

    public void setNofaktur(String nofaktur) {
        this.nofaktur = nofaktur;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
}
