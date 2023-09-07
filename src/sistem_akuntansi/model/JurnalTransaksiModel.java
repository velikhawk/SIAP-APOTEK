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
import sistem_akuntansi.entity.JurnalTransaksi;

/**
 *
 * @author arochman aryanta
 */
public class JurnalTransaksiModel {
    private Connection connection;

    public JurnalTransaksiModel(Connection connection) {
        this.connection = connection;
    }    
    
    public void insert(JurnalTransaksi entity) throws SQLException{
        String sql = "INSERT INTO "
            + "tr_jurnal_transaksi("
                + "tanggal, "
                + "nomor_bukti, "
                + "keterangan, "
                + "kode_rekening, "
                + "tipe, "
                + "debet, "
                + "kredit"
            + ") VALUES("
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?"
            + ")"
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;        
        preparedStatement.setDate(i++, new java.sql.Date(entity.getTanggal().getTime()));
        preparedStatement.setString(i++, entity.getNomor_bukti());
        preparedStatement.setString(i++, entity.getKeterangan());
        preparedStatement.setString(i++, entity.getKode_rekening());
        preparedStatement.setString(i++, entity.getTipe());
        preparedStatement.setInt(i++, entity.getDebet());
        preparedStatement.setInt(i++, entity.getKredit());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public void delete(JurnalTransaksi entity) throws SQLException{
        String sql = "DELETE "
            +  "FROM "
                + "tr_jurnal_transaksi "
            +  "WHERE  "
                + "nomor_bukti = ?"
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;        
        preparedStatement.setString(i++, entity.getNomor_bukti());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public Vector<JurnalTransaksi> get(String key) {
        String sql = "SELECT "
                + "tr_jurnal_transaksi.id AS tr_jurnal_transaksi_id, "
                + "tr_jurnal_transaksi.tanggal AS tr_jurnal_transaksi_tanggal, "
                + "tr_jurnal_transaksi.nomor_bukti AS tr_jurnal_transaksi_nomor_bukti, "
                + "tr_jurnal_transaksi.keterangan AS tr_jurnal_transaksi_keterangan, "
               // + "tr_jurnal_transaksi.kode_rekening AS tr_jurnal_transaksi_kode_rekening, "
                + "tr_jurnal_transaksi.tipe AS tr_jurnal_transaksi_tipe, "
                + "tr_jurnal_transaksi.debet AS tr_jurnal_transaksi_debet, "
                + "tr_jurnal_transaksi.kredit AS tr_jurnal_transaksi_kredit "
            + "FROM "
                + "tr_jurnal_transaksi "
            + "WHERE "
                + "tr_jurnal_transaksi.nomor_bukti = ?"
        ;
        
        Vector<JurnalTransaksi> entitys = new Vector<JurnalTransaksi>();
        PreparedStatement preparedStatement = null; 
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            preparedStatement.setString(i++, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                JurnalTransaksi entity = new JurnalTransaksi();
                entity.setId(resultSet.getInt("tr_jurnal_transaksi_id"));
                entity.setTanggal(resultSet.getDate("tr_jurnal_transaksi_tanggal"));
                entity.setNomor_bukti(resultSet.getString("tr_jurnal_transaksi_nomor_bukti"));
                entity.setKeterangan(resultSet.getString("tr_jurnal_transaksi_keterangan"));
               // entity.setKode_rekening(resultSet.getString("tr_jurnal_transaksi_kode_rekening"));
                entity.setTipe(resultSet.getString("tr_jurnal_transaksi_tipe"));
                entity.setDebet(resultSet.getInt("tr_jurnal_transaksi_debet"));
                entity.setKredit(resultSet.getInt("tr_jurnal_transaksi_kredit"));

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
}
