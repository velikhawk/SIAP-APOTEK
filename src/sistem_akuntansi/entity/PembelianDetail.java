package sistem_akuntansi.entity;

import java.util.Date;

/**
 *
 * @author VELIK
 */
public class PembelianDetail {
   private Integer id;
   private String kode_obat;
   private Integer kuantiti;
   private Integer harga;
   private Integer jumlah;
   private Date exp_date;
   private String header_nofaktur;

   private Barang barang;
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode_obat() {
        return kode_obat;
    }

    public void setKode_obat(String kode_obat) {
        this.kode_obat = kode_obat;
    }

    public Integer getKuantiti() {
        return kuantiti;
    }

    public void setKuantiti(Integer kuantiti) {
        this.kuantiti = kuantiti;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }
    
     public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public String getHeader_nofaktur() {
        return header_nofaktur;
    }

    public void setHeader_nofaktur(String header_nofaktur) {
        this.header_nofaktur = header_nofaktur;
    }

}
