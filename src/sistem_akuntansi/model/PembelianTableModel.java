/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import sistem_akuntansi.entity.Pembelian;
/**
 *
 * @author VELIK
 */
public class PembelianTableModel extends AbstractTableModel{
    private Vector<Pembelian> data;
    
    public PembelianTableModel(Vector<Pembelian> entitys) {
        this.data = entitys;
    }
     @Override
    public int getRowCount() {
        return this.data.size();
    }
    @Override
    public int getColumnCount() {
        return 4; //jumlah kolom
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NumberFormat numberFormat = new DecimalFormat("#,##0");
        Pembelian pembelian = this.data.get(rowIndex);
        switch(columnIndex){
            case 0: return pembelian.getNofaktur();
            case 1: return pembelian.getTanggal();
            case 2: return pembelian.getKode_pbf();
            case 3: return numberFormat.format(pembelian.getTotal());
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Nofaktur";
            case 1: return "Tanggal";
            case 2: return "Kode pbf";
            case 3: return "Total";
            default: return null;
        }       
    }

    public void setData(Vector<Pembelian> data) {
        this.data = data;
    }
    
    public Vector<Pembelian> getData() {
        return this.data;
    }
}
