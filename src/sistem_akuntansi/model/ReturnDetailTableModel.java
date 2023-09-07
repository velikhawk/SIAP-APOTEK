package sistem_akuntansi.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import sistem_akuntansi.entity.ReturnDetail;
/**
 *
 * @author VELIK
 */
public class ReturnDetailTableModel extends AbstractTableModel {
    
    private Vector<ReturnDetail> data;
    
    public ReturnDetailTableModel(Vector<ReturnDetail> entitys) {
        this.data = entitys;
    }
    @Override
    public int getRowCount(){
        return this.data.size();
    }
    @Override
    public int getColumnCount(){
        return 4; //jumlah kolom
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NumberFormat numberFormat = new DecimalFormat("#,##0");
        ReturnDetail returnDetail = this.data.get(rowIndex);
        switch(columnIndex) {
            case 0: return returnDetail.getKode_obat();
            case 1: return numberFormat.format(returnDetail.getHarga());
            case 2: return numberFormat.format(returnDetail.getKuantiti());                        
            case 3: return numberFormat.format(returnDetail.getJumlah());
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode obat";
            case 1: return "Harga";
            case 2: return "Kuantiti";
            case 3: return "Jumlah";
            
            default: return null;
        }
    }
    public void setData(Vector<ReturnDetail> data){
        this.data= data;
    }
    public Vector<ReturnDetail> getData(){
        return this.data;
    }
}
