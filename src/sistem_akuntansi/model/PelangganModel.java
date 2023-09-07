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
import sistem_akuntansi.entity.Pelanggan;
/**
 *
 * @author VELIK
 */
public class PelangganModel {
    private Connection connection;

    public PelangganModel(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Pelanggan pelanggan) throws SQLException{
        String sql = "INSERT INTO ms_pelanggan(kode_pelanggan, nama_pelanggan, alamat, telepon, kota) VALUES(?, ?, ?, ?, ?)";
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, pelanggan.getKode_pelanggan());
        statemen.setString(2, pelanggan.getNama_pelanggan());
        statemen.setString(3, pelanggan.getAlamat());
        statemen.setString(4, pelanggan.getTelepon());
        statemen.setString(5, pelanggan.getKota());
        
        statemen.executeUpdate();
        statemen.close();
    }
    
    public void update(Pelanggan pelanggan) throws SQLException{
        String sql = "UPDATE "
                + "ms_pelanggan SET "
                + "nama_pelanggan = ?, "
                + "alamat = ?, "
                + "telepon = ?, "
                + "kota = ? "
                + "WHERE "
                + "kode_pelanggan = ?"
                ;
        
        PreparedStatement statemen = connection.prepareStatement(sql);        
        statemen.setString(1, pelanggan.getNama_pelanggan());
        statemen.setString(2, pelanggan.getAlamat());
        statemen.setString(3, pelanggan.getTelepon());
        statemen.setString(4, pelanggan.getKota());
        statemen.setString(5, pelanggan.getKode_pelanggan());
        statemen.executeUpdate();
        statemen.close();
    }
    
    public void delete(Pelanggan pelanggan) throws SQLException{
        String sql = "DELETE FROM ms_pelanggan WHERE kode_pelanggan = ? ";
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, pelanggan.getKode_pelanggan());
        statemen.executeUpdate();
        statemen.close();
    }
    
    public Vector<Pelanggan> search(String keyword) {
        String sql= "SELECT kode_pelanggan, nama_pelanggan, alamat, telepon, kota FROM ms_pelanggan WHERE kode_pelanggan LIKE ? OR nama_pelanggan LIKE ?";        
        Vector<Pelanggan> pelanggan = new Vector<Pelanggan>();
        PreparedStatement statement = null; 
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet result= statement.executeQuery();
            while (result.next()){
                Pelanggan entity = new Pelanggan();
                entity.setKode_pelanggan(result.getString("kode_pelanggan"));
                entity.setNama_pelanggan(result.getString("nama_pelanggan"));
                entity.setAlamat(result.getString("alamat"));
                entity.setTelepon(result.getString("telepon"));
                entity.setKota(result.getString("kota"));
                pelanggan.add(entity);
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
        return pelanggan;
        }
    
    public Pelanggan get(String kode_pelanggan) {
        String sql= "SELECT kode_pelanggan, nama_pelanggan, alamat, telepon, kota FROM ms_pelanggan WHERE kode_pelanggan=?";        
        Pelanggan entity = new Pelanggan();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);    
            statement.setString(1, kode_pelanggan);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                entity.setKode_pelanggan(result.getString("kode_pelanggan"));
                entity.setNama_pelanggan(result.getString("nama_pelanggan"));
                entity.setAlamat(result.getString("alamat"));
                entity.setTelepon(result.getString("telepon"));
                entity.setKota(result.getString("kota"));
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
        return entity;
    }
}
