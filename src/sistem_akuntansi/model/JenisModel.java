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
import sistem_akuntansi.entity.Jenis;
/**
 *
 * @author VELIK
 */
public class JenisModel {
    private Connection connection;
    
    public JenisModel(Connection connection) {
        this.connection = connection;
    }
    public void insert(Jenis entity) throws SQLException{
         String sql = "INSERT INTO "
            + "ms_jenis("
                + "kode_jenis, "
                + "nama_jenis"
            + ") VALUES("
                + "?, "
                + "?"
                + ")"
        ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        preparedStatement.setString(i++, entity.getKode_jenis());
        preparedStatement.setString(i++, entity.getNama_jenis());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
     public void update(Jenis entity) throws SQLException{
        String sql = "UPDATE "
            + "ms_jenis SET "
                + "kode_jenis = ?, "
                + "nama_jenis = ? "
             + "WHERE "
                + "kode_jenis = ?"
        ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        preparedStatement.setString(i++, entity.getKode_jenis());
        preparedStatement.setString(i++, entity.getNama_jenis());
        preparedStatement.setString(i++, entity.getKode_jenis());
        
         preparedStatement.executeUpdate();
        preparedStatement.close();
     }
     
     public void delete(Jenis entity) throws SQLException{
        String sql= "DELETE "
            +  "FROM "
                + "ms_jenis "
            +  "WHERE  "
                + "kode_jenis = ?"            
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, entity.getKode_jenis());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
     
     public Vector<Jenis> selectAll(){
        String sql = "SELECT "
                + "ms_jenis.kode_jenis AS ms_jenis_kode_jenis, "
                + "ms_jenis.nama_jenis AS ms_jenis_nama_jenis "
            + "FROM "
                + "ms_jenis"
        ;
        Vector<Jenis> vJenis = new Vector<Jenis>();
        PreparedStatement preparedStatementt = null;
        try {
            preparedStatementt = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                Jenis entity= new Jenis();
                entity.setKode_jenis(resultSet.getString("ms_jenis_kode_jenis"));
                entity.setNama_jenis(resultSet.getString("ms_jenis_nama_jenis"));
                
                vJenis.add(entity);
        }
     }catch (SQLException ex) {
            ex.printStackTrace();
     }finally{
             if (preparedStatementt != null) try {
                preparedStatementt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         return vJenis;
     }
     
     public Jenis get(String kode_jenis) {
        String sql= "SELECT "
                + "ms_jenis.kode_jenis AS ms_jenis_kode_jenis, "
                + "ms_jenis.nama_jenis AS ms_jenis_nama_jenis "
                + "FROM "
                + "ms_jenis "
            + "WHERE "
                + "kode_jenis = ? ";
     
         Jenis entity= new Jenis();
        PreparedStatement preparedStatementt = null;
        try {
            preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setString(1, kode_jenis);
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                entity.setKode_jenis(resultSet.getString("ms_jenis_kode_jenis "));
                entity.setNama_jenis(resultSet.getString("ms_jenis_nama_jenis "));
                 }    
     
        } catch (SQLException ex){
             ex.printStackTrace();
        } finally{
            if (preparedStatementt != null) try {
                preparedStatementt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         return entity;
    }
     
     public Vector<Jenis> search(String keyword) {
           String sql = "SELECT "
                + "ms_jenis.kode_jenis AS ms_jenis_kode_jenis, "
                + "ms_jenis.nama_jenis AS ms_jenis_nama_jenis "
            + "FROM "
                + "ms_jenis "
            + "WHERE "
                + "kode_jenis LIKE ? "
                + "OR nama_jenis LIKE ?"
        ;
           Vector<Jenis> vJenis = new Vector<Jenis>();
        PreparedStatement preparedStatementt = null;
        
        try {
            preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setString(1, "%"+keyword+"%");
            preparedStatementt.setString(2, "%"+keyword+"%");
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                Jenis entity= new Jenis();
                entity.setKode_jenis(resultSet.getString("ms_jenis_kode_jenis"));
                entity.setNama_jenis(resultSet.getString("ms_jenis_nama_jenis"));
                
                 vJenis.add(entity);
            }        
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatementt != null) try {
                preparedStatementt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return vJenis;
    }
}
