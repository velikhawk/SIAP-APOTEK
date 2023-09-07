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
import sistem_akuntansi.entity.PembelianDetail;
/**
 *
 * @author VELIK
 */
public class PembelianDetailTableModel extends AbstractTableModel{
     private Vector<PembelianDetail> data;
    
    public PembelianDetailTableModel(Vector<PembelianDetail> entitys) {
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
        PembelianDetail pembelianDetail = this.data.get(rowIndex);
        switch(columnIndex){
            case 0: return pembelianDetail.getKode_obat();
            case 1: return pembelianDetail.getBarang().getNama_obat();
            case 2: return numberFormat.format(pembelianDetail.getKuantiti());
            case 3: return numberFormat.format(pembelianDetail.getHarga());
            case 4: return numberFormat.format(pembelianDetail.getJumlah());
            case 5: return pembelianDetail.getExp_date();
            case 6: return pembelianDetail.getHeader_nofaktur();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode Obat";
            case 1: return "Nama Obat";
            case 2: return "Kuantiti";
            case 3: return "Harga";
            case 4: return "Jumlah";
            case 5: return "EXP Date";
            case 6: return "Nofaktur";
            default: return null;
        }       
    }

    public void setData(Vector<PembelianDetail> data) {
        this.data = data;
    }
    
    public Vector<PembelianDetail> getData() {
        return this.data;
    }
}
