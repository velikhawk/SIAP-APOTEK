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
import sistem_akuntansi.entity.Pelanggan;

/**
 *
 * @author VELIK
 */
public class PelangganTableModel extends AbstractTableModel{
    private Vector<Pelanggan> data;
    
    public PelangganTableModel(Vector<Pelanggan> entitys) {
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
        Pelanggan pelanggan = this.data.get(rowIndex);
        switch(columnIndex){
            case 0: return pelanggan.getKode_pelanggan();
            case 1: return pelanggan.getNama_pelanggan();
            case 2: return pelanggan.getAlamat();
            case 3: return pelanggan.getTelepon();
            case 4: return pelanggan.getKota();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode pelanggan";
            case 1: return "Nama pelanggan";
            case 2: return "Alamat";
            case 3: return "Telepon";
            case 4: return "Kota";
            default: return null;
        }       
    }

    public void setData(Vector<Pelanggan> data) {
        this.data = data;
    }
    
    public Vector<Pelanggan> getData() {
        return this.data;
    }
}