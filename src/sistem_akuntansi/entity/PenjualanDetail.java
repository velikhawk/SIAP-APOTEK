package sistem_akuntansi.entity;

/**
 *
 * @author VELIK
 */
public class PenjualanDetail {
   private Integer id;
   private String kode_obat;
   private String kode_jenis;
   private Integer kuantiti;
   private Integer harga;
   private Integer jumlah;
   private String header_nomor;
   
    private Barang barang;
    private Jenis jenis;

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

    public String getKode_jenis() {
        return kode_jenis;
    }

    public void setKode_jenis(String kode_jenis) {
        this.kode_jenis = kode_jenis;
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

    public String getHeader_nomor() {
        return header_nomor;
    }

    public void setHeader_nomor(String header_nomor) {
        this.header_nomor = header_nomor;
    }
    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }
     public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }

}
