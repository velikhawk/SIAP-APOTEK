/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.model;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import sistem_akuntansi.entity.Jenis;
/**
 *
 * @author VELIK
 */
public class JenisTableModel extends AbstractTableModel {
     private Vector<Jenis> data;
    
    public JenisTableModel(Vector<Jenis> entitys) {
        this.data = entitys;
    }
    @Override
    public int getRowCount() {
        return this.data.size();
    }
    
    @Override
    public int getColumnCount() {
        return 2; //jumlah kolom
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Jenis jenis = this.data.get(rowIndex);
        switch(columnIndex){
            case 0: return jenis.getKode_jenis();
            case 1: return jenis.getNama_jenis();
            default: return null;
        }
    }
     @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode jenis";
            case 1: return "Nama jenis";
            default: return null;
        }   
    }
    public void setData(Vector<Jenis> data) {
        this.data = data;
    }

    public Vector<Jenis> getData() {
        return data;
    }
}