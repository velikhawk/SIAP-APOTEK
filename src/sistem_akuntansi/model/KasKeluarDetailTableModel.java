/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.model;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import sistem_akuntansi.entity.KasKeluarDetail;

/**
 *
 * @author AROCHMAN ARYANTA
 */
public class KasKeluarDetailTableModel extends AbstractTableModel{
    private Vector<KasKeluarDetail> data;
    
    public KasKeluarDetailTableModel(Vector<KasKeluarDetail> entitys) {
        this.data = entitys;
    }
    
    @Override
    public int getRowCount() {
        return this.data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 3; //jumlah kolom
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NumberFormat numberFormat = new DecimalFormat("#,##0");
        KasKeluarDetail kasKeluarDetail = this.data.get(rowIndex);
        switch(columnIndex){
            case 0: return kasKeluarDetail.getKode_rekening();
            case 1: return kasKeluarDetail.getPerkiraan().getNama();
            case 2: return numberFormat.format(kasKeluarDetail.getJumlah());
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode";
            case 1: return "Nama";
            case 2: return "Jumlah";
            default: return null;
        }       
    }
    
    public void setData(Vector<KasKeluarDetail> data) {
        this.data = data;
    }
    
    public Vector<KasKeluarDetail> getData() {
        return this.data;
    }
}
