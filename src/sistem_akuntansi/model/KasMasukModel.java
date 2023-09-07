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
import sistem_akuntansi.entity.KasMasuk;

/**
 *
 * @author arochman aryanta
 */
public class KasMasukModel {
    private Connection connection;

    public KasMasukModel(Connection connection) {
        this.connection = connection;
    }    
    
    public void insert(KasMasuk entity) throws SQLException{
        String sql = "INSERT INTO "
            + "tr_kas_masuk("
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
    
    public void delete(KasMasuk entity) throws SQLException{
        String sql = "DELETE "
            +  "FROM "
                + "tr_kas_masuk "
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
    
    public Vector<KasMasuk> get(String key) {
        String sql = "SELECT "
            + "tr_kas_masuk.nomor AS tr_kas_masuk_nomor, "
            + "tr_kas_masuk.tanggal AS tr_kas_masuk_tanggal, "
            + "tr_kas_masuk.keterangan AS tr_kas_masuk_keterangan, "
            + "tr_kas_masuk.kode_rekening_kas AS tr_kas_masuk_kode_rekening_kas, "
            + "tr_kas_masuk.total AS tr_kas_masuk_total "
            + "FROM "
                + "tr_kas_masuk "
            + "WHERE "
                + "kas_masuk.nomor = ?"
        ;
        
        Vector<KasMasuk> entitys = new Vector<KasMasuk>();
        PreparedStatement preparedStatement = null; 
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            preparedStatement.setString(i++, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                KasMasuk entity = new KasMasuk();
                entity.setNomor(resultSet.getString("tr_kas_masuk_nomor"));
                entity.setTanggal(resultSet.getDate("tr_kas_masuk_tanggal"));
                entity.setKeterangan(resultSet.getString("tr_kas_masuk_keterangan"));
                entity.setKode_rekening_kas(resultSet.getString("tr_kas_masuk_kode_rekening_kas"));
                entity.setTotal(resultSet.getInt("tr_kas_masuk_total"));
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
                + "MAX(CAST(RIGHT(tr_kas_masuk.nomor,6) AS UNSIGNED)), "
                + "MAX(CAST(RIGHT(tr_kas_masuk.nomor,6) AS UNSIGNED))+1, "
                + "1"
            + ") AS nomor "
            + "FROM "
                + "tr_kas_masuk"
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
        return String.format("JKM%06d", newNomor);
    }
    
}
