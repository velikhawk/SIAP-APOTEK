/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sistem_akuntansi.entity.KasKeluar;

/**
 *
 * @author arochman aryanta
 */
public class KasKeluarModel {
    private Connection connection;

    public KasKeluarModel(Connection connection) {
        this.connection = connection;
    }    
    
    public void insert(KasKeluar entity) throws SQLException{
        String sql = "INSERT INTO "
            + "tr_kas_keluar("
                + "nomor, "
                + "tanggal, "
                + "keterangan, "
                + "kode_rekening_kas, "
                + "total"
            + ") VALUES("
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?"
            + ")"
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        preparedStatement.setString(i++, entity.getNomor());
        preparedStatement.setDate(i++, new java.sql.Date(entity.getTanggal().getTime()));
        preparedStatement.setString(i++, entity.getKeterangan());
        preparedStatement.setString(i++, entity.getKode_rekening_kas());
        preparedStatement.setInt(i++, entity.getTotal());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public void delete(KasKeluar entity) throws SQLException{
        String sql = "DELETE "
            +  "FROM "
                + "tr_kas_keluar "
            +  "WHERE  "
            + "nomor = ?"
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1; 
        preparedStatement.setString(i++, entity.getNomor());
        preparedStatement.setDate(i++, new java.sql.Date(entity.getTanggal().getTime()));
        preparedStatement.setString(i++, entity.getKeterangan());
        preparedStatement.setString(i++, entity.getKode_rekening_kas());
        preparedStatement.setInt(i++, entity.getTotal());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public Vector<KasKeluar> get(String key) {
        String sql = "SELECT "
            + "tr_kas_keluar.nomor AS tr_kas_keluar_nomor, "
            + "tr_kas_keluar.tanggal AS tr_kas_keluar_tanggal, "
            + "tr_kas_keluar.keterangan AS tr_kas_keluar_keterangan, "
            + "tr_kas_keluar.kode_rekening_kas AS tr_kas_keluar_kode_rekening_kas, "
            + "tr_kas_keluar.total AS tr_kas_keluar_total "
            + "FROM "
                + "tr_kas_keluar "
            + "WHERE "
                + "kas_masuk.nomor = ?"
        ;
        
        Vector<KasKeluar> entitys = new Vector<KasKeluar>();
        PreparedStatement preparedStatement = null; 
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            preparedStatement.setString(i++, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                KasKeluar entity = new KasKeluar();
                entity.setNomor(resultSet.getString("tr_kas_keluar_nomor"));
                entity.setTanggal(resultSet.getDate("tr_kas_keluar_tanggal"));
                entity.setKeterangan(resultSet.getString("tr_kas_keluar_keterangan"));
                entity.setKode_rekening_kas(resultSet.getString("tr_kas_keluar_kode_rekening_kas"));
                entity.setTotal(resultSet.getInt("tr_kas_keluar_total"));

                entitys.add(entity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) try {
                preparedStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }    
        return entitys;
    }
    
    public String getNewNomor(){        
        String sql = "SELECT "
            + "IF("
                + "MAX(CAST(RIGHT(tr_kas_keluar.nomor,6) AS UNSIGNED)), "
                + "MAX(CAST(RIGHT(tr_kas_keluar.nomor,6) AS UNSIGNED))+1, "
                + "1"
            + ") AS nomor "
            + "FROM "
                + "tr_kas_keluar"
        ;
        int newNomor = 0;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql); 
            ResultSet result = statement.executeQuery();
            if (result.next()){
                newNomor = result.getInt("nomor");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }   
        return String.format("JKK%06d", newNomor);
    }
    public String angka (int satuan){
        String[] huruf ={"","Satu","Dua","Tiga","Empat","Lima","Enam","Tujuh","Delapan","Sembilan","Sepuluh","Sebelas"};
String hasil="";
if(satuan<12)
hasil=hasil+huruf[satuan];
else if(satuan<20)
hasil=hasil+angka(satuan-10)+" Belas";
else if(satuan<100)
hasil=hasil+angka(satuan/10)+" Puluh "+angka(satuan%10);
else if(satuan<200)
hasil=hasil+"Seratus "+angka(satuan-100);
else if(satuan<1000)
hasil=hasil+angka(satuan/100)+" Ratus "+angka(satuan%100);
else if(satuan<2000)
hasil=hasil+"Seribu "+angka(satuan-1000);
else if(satuan<1000000)
hasil=hasil+angka(satuan/1000)+" Ribu "+angka(satuan%1000);
else if(satuan<1000000000)
hasil=hasil+angka(satuan/1000000)+" Juta "+angka(satuan%1000000);
else if(satuan>=1000000000)
hasil="Angka terlalu besar, harus kurang dari 1 milyar!";
return hasil;
}
    
}
