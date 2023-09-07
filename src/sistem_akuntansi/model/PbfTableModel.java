package sistem_akuntansi.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import sistem_akuntansi.entity.Pbf;
/**
 *
 * @author VELIK
 */
public class PbfTableModel extends AbstractTableModel {
     private Vector<Pbf> data;
    
    public PbfTableModel(Vector<Pbf> entitys) {
        this.data = entitys;
    }
    @Override
    public int getRowCount() {
        return this.data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 5; //jumlah kolom
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NumberFormat numberFormat = new DecimalFormat("#,##0");
        Pbf pbf = this.data.get(rowIndex);
        switch(columnIndex){
            case 0: return pbf.getKode_pbf();
            case 1: return pbf.getNama_pbf();
            case 2: return pbf.getAlamat();
            case 3: return pbf.getTelepon();
            case 4: return pbf.getKota();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode pbf";
            case 1: return "Nama pbf";
            case 2: return "Alamat";
            case 3: return "Telepon";
            case 4: return "Kota";
            default: return null;
        }       
    }
    public void setData(Vector<Pbf> data) {
        this.data = data;
    }

    public Vector<Pbf> getData() {
        return data;
    }
}
