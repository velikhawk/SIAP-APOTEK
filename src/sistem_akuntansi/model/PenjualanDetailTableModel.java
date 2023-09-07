package sistem_akuntansi.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import sistem_akuntansi.entity.PenjualanDetail;
/**
 *
 * @author VELIK
 */
public class PenjualanDetailTableModel extends AbstractTableModel {
    
    private Vector<PenjualanDetail> data;
    
    public PenjualanDetailTableModel(Vector<PenjualanDetail> entitys) {
        this.data = entitys;
    }
    @Override
    public int getRowCount(){
        return this.data.size();
    }
    @Override
    public int getColumnCount(){
        return 7; //jumlah kolom
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NumberFormat numberFormat = new DecimalFormat("#,##0");
        PenjualanDetail penjualanDetail = this.data.get(rowIndex);
        switch(columnIndex) {
            case 0: return penjualanDetail.getKode_obat();
            case 1: return penjualanDetail.getBarang().getNama_obat();
            case 2: return penjualanDetail.getKode_jenis();
            case 3: return penjualanDetail.getJenis().getNama_jenis();
            case 4: return numberFormat.format(penjualanDetail.getKuantiti());
            case 5: return numberFormat.format(penjualanDetail.getHarga());
            case 6: return numberFormat.format(penjualanDetail.getJumlah());
          
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode obat";
            case 1: return "Nama obat";
            case 2: return "Kode jenis";
            case 3: return "Nama jenis";
            case 4: return "Kuantiti";
            case 5: return "Harga";
            case 6: return "Jumlah";
           
            default: return null;
        }
    }
    public void setData(Vector<PenjualanDetail> data){
        this.data= data;
    }
    public Vector<PenjualanDetail> getData(){
        return this.data;
    }
    
}
