package sistem_akuntansi.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import sistem_akuntansi.entity.Barang;
/**
 *
 * @author VELIK
 */
public class BarangTableModel extends AbstractTableModel {
    private Vector<Barang> data;
    
    public BarangTableModel(Vector<Barang> entitys) {
        this.data = entitys;
    }
    @Override
    public int getRowCount() {
        return this.data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 7; //jumlah kolom
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NumberFormat numberFormat = new DecimalFormat("#,##0");
        Barang barang = this.data.get(rowIndex);
        switch(columnIndex){
            case 0: return barang.getKode_obat();
            case 1: return barang.getNama_obat();
            case 2: return barang.getKode_jenis();
            case 3: return barang.getTanggal_kadaluwarsa();
            case 4: return numberFormat.format(barang.getJumlah());
            case 5: return numberFormat.format(barang.getHarga_beli());
            case 6: return numberFormat.format(barang.getHarga_jual());
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode obat";
            case 1: return "Nama obat";
            case 2: return "Kode jenis";
            case 3: return "Tanggal kadaluwarsa";
            case 4: return "Jumlah";
            case 5: return "Harga beli";
            case 6: return "Harga jual";
            default: return null;
        }       
    }
    public void setData(Vector<Barang> data) {
        this.data = data;
    }

    public Vector<Barang> getData() {
        return data;
    }
}
