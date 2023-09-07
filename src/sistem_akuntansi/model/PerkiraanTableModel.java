/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.model;


import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import sistem_akuntansi.entity.Perkiraan;

/**
 *
 * @author AROCHMAN ARYANTA
 */
public class PerkiraanTableModel extends AbstractTableModel{
    private Vector<Perkiraan> data;
    
    public PerkiraanTableModel(Vector<Perkiraan> entitys) {
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
        DecimalFormat numberFormat = new DecimalFormat("#,##0");
        Perkiraan perkiraan = this.data.get(rowIndex);
        switch(columnIndex){
            case 0: return perkiraan.getKode();
            case 1: return perkiraan.getNama();
            case 2: return perkiraan.getKelompok();
            case 3: return perkiraan.getTipe();
            case 4: return numberFormat.format(perkiraan.getSaldo_akhir());
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode";
            case 1: return "Nama";
            case 2: return "Kelompok";
            case 3: return "Tipe";
            case 4: return "Saldo akhir";
            default: return null;
        }       
    }
    
    public void setData(Vector<Perkiraan> data) {
        this.data = data;
    }

    public Vector<Perkiraan> getData() {
        return data;
    }
}
