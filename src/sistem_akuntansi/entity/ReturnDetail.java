package sistem_akuntansi.entity;

/**
 *
 * @author VELIK
 */
public class ReturnDetail {
    private Integer id;
    private String kode_obat;
    private Integer harga;
    private Integer kuantiti;
    private Integer jumlah;
    private String header_nomor;
    
    private Barang barang;
    private Pbf pbf;
    private Pembelian pembelian;

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Pbf getPbf() {
        return pbf;
    }

    public void setPbf(Pbf pbf) {
        this.pbf = pbf;
    }

    public Pembelian getPembelian() {
        return pembelian;
    }

    public void setPembelian(Pembelian pembelian) {
        this.pembelian = pembelian;
    }

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

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getKuantiti() {
        return kuantiti;
    }

    public void setKuantiti(Integer kuantiti) {
        this.kuantiti = kuantiti;
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

    

}
