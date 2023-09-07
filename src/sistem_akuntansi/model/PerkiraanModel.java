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
import sistem_akuntansi.entity.Perkiraan;

/**
 *
 * @author arochman aryanta
 */
public class PerkiraanModel {
    private Connection connection;

    public PerkiraanModel(Connection connection) {
        this.connection = connection;
    }
        
    public void insert(Perkiraan perkiraan) throws SQLException{
        String sql = "INSERT INTO ms_perkiraan(kode, nama, kelompok, tipe, saldo_akhir) VALUES(?, ?, ?, ?, ?)";
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, perkiraan.getKode());
        statemen.setString(2, perkiraan.getNama());
        statemen.setInt(3, perkiraan.getKelompok());
        statemen.setString(4, perkiraan.getTipe());
        statemen.setDouble(5, perkiraan.getSaldo_akhir());
        statemen.executeUpdate();
        statemen.close();
    }

    public void update(Perkiraan perkiraan) throws SQLException{
        String sql = "UPDATE ms_perkiraan SET nama = ?, kelompok = ?, tipe = ?, saldo_akhir = ? WHERE kode = ?";
        
        PreparedStatement statemen = connection.prepareStatement(sql);        
        statemen.setString(1, perkiraan.getNama());
        statemen.setInt(2, perkiraan.getKelompok());
        statemen.setString(3, perkiraan.getTipe());
        statemen.setDouble(4, perkiraan.getSaldo_akhir());
        statemen.setString(5, perkiraan.getKode());
        statemen.executeUpdate();
        statemen.close();
    }

    public void delete(Perkiraan perkiraan) throws SQLException{
        String sql= "DELETE FROM ms_perkiraan WHERE kode = ?";
        
        PreparedStatement statemen = connection.prepareStatement(sql);
        statemen.setString(1, perkiraan.getKode());
        statemen.executeUpdate();
        statemen.close();
    }
    
    public Vector<Perkiraan> selectAll(){
        String sql = "SELECT kode, nama, kelompok, tipe, saldo_akhir FROM ms_perkiraan";
        Vector<Perkiraan> vPerkiraan = new Vector<Perkiraan>();
        PreparedStatement statement = null;
        try {
            
            statement = connection.prepareStatement(sql);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                Perkiraan entity= new Perkiraan();
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setKelompok(result.getInt("kelompok"));
                entity.setTipe(result.getString("tipe"));
                entity.setSaldo_akhir(result.getDouble("saldo_akhir"));
                vPerkiraan.add(entity);
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
        return vPerkiraan;
    }
    
    public Vector<Perkiraan> search(String keyword) {
        String sql = "SELECT kode, nama, kelompok, tipe, saldo_akhir FROM ms_perkiraan WHERE kode LIKE ? OR nama LIKE ?";        
        Vector<Perkiraan> vPerkiraan = new Vector<Perkiraan>();
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet result= statement.executeQuery();
            while (result.next()){
                Perkiraan entity= new Perkiraan();
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setKelompok(result.getInt("kelompok"));
                entity.setTipe(result.getString("tipe"));
                entity.setSaldo_akhir(result.getDouble("saldo_akhir"));
                vPerkiraan.add(entity);
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
        return vPerkiraan;
    }
    
    public Perkiraan get(String kode) {
        String sql= "SELECT kode, nama, kelompok, tipe, saldo_akhir FROM ms_perkiraan WHERE kode = ?";
        Perkiraan entity= new Perkiraan();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, kode);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                entity.setKode(result.getString("kode"));
                entity.setNama(result.getString("nama"));
                entity.setKelompok(result.getInt("kelompok"));
                entity.setTipe(result.getString("tipe"));
                entity.setSaldo_akhir(result.getDouble("saldo_akhir"));
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
