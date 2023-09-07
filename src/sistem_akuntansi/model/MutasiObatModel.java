/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.model;

/**
 *
 * @author VELIK
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sistem_akuntansi.entity.MutasiObat;

public class MutasiObatModel {
    private Connection connection;

    public MutasiObatModel(Connection connection) {
        this.connection = connection;
    }    
     public void insert(MutasiObat entity) throws SQLException{
        String sql = "INSERT INTO "
            + "tr_mutasi_obat("
                + "tanggal, "
                + "nomor_bukti, "
                + "keterangan, "
                + "kode_obat, "
                + "masuk_kuantiti, "
                + "masuk_jumlah, "
                + "keluar_kuantiti, "
                + "keluar_jumlah"
            + ") VALUES("
                + "?, "
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
        preparedStatement.setString(i++, entity.getKode_obat());
        preparedStatement.setInt(i++, entity.getMasuk_kuantiti());
        preparedStatement.setInt(i++, entity.getMasuk_jumlah());
        preparedStatement.setInt(i++, entity.getKeluar_kuantiti());
        preparedStatement.setInt(i++, entity.getKeluar_jumlah());

        preparedStatement.executeUpdate();
        preparedStatement.close();
     }
     
     
    public void delete(MutasiObat entity) throws SQLException{
        String sql = "DELETE "
            +  "FROM "
                + "tr_mutasi_obat "
            +  "WHERE  "
                + "nomor_bukti = ?"
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;        
        preparedStatement.setString(i++, entity.getNomor_bukti());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public Vector<MutasiObat> get(String key) {
        String sql = "SELECT "
            + "tr_mutasi_obat.id AS tr_mutasi_obat_id, "
            + "tr_mutasi_obat.tanggal AS tr_mutasi_obat_tanggal, "
            + "tr_mutasi_obat.nomor_bukti AS tr_mutasi_obat_nomor_bukti, "
            + "tr_mutasi_obat.keterangan AS tr_mutasi_obat_keterangan, "
            + "tr_mutasi_obat.kode_obat AS tr_mutasi_obat_kode_obat, "
            + "tr_mutasi_obat.masuk_kuantiti AS tr_mutasi_obat_masuk_kuantiti, "
            + "tr_mutasi_obat.masuk_jumlah AS tr_mutasi_obat_masuk_jumlah, "
            + "tr_mutasi_obat.keluar_kuantiti AS tr_mutasi_obat_keluar_kuantiti, "
            + "tr_mutasi_obat.keluar_jumlah AS tr_mutasi_obat_keluar_jumlah "
            + "FROM "
                + "tr_mutasi_obat "
            + "WHERE "
                + "tr_mutasi_obat.nomor_bukti = ?"
        ;
        
    Vector<MutasiObat> entitys = new Vector<MutasiObat>();
        PreparedStatement preparedStatement = null; 
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            preparedStatement.setString(i++, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                MutasiObat entity = new MutasiObat();
                entity.setId(resultSet.getInt("tr_mutasi_obat_id"));
                entity.setTanggal(resultSet.getDate("tr_mutasi_obat_tanggal"));
                entity.setNomor_bukti(resultSet.getString("tr_mutasi_obat_nomor_bukti"));
                entity.setKeterangan(resultSet.getString("tr_mutasi_obat_keterangan"));
                entity.setKode_obat(resultSet.getString("tr_mutasi_obat_kode_obat"));
                entity.setMasuk_kuantiti(resultSet.getInt("tr_mutasi_obat_masuk_kuantiti"));
                entity.setMasuk_jumlah(resultSet.getInt("tr_mutasi_obat_masuk_jumlah"));
                entity.setKeluar_kuantiti(resultSet.getInt("tr_mutasi_obat_keluar_kuantiti"));
                entity.setKeluar_jumlah(resultSet.getInt("tr_mutasi_obat_keluar_jumlah"));

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
