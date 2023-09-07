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
import sistem_akuntansi.entity.KasMasukDetail;

/**
 *
 * @author arochman aryanta
 */
public class KasMasukDetailModel {
    private Connection connection;

    public KasMasukDetailModel(Connection connection) {
        this.connection = connection;
    }    
    
    public void insert(KasMasukDetail entity) throws SQLException{
        String sql = "INSERT INTO "
            + "tr_kas_masuk_detail("
                + "kode_rekening, "
                + "jumlah, "
                + "header_nomor"
            + ") VALUES("
                + "?, "
                + "?, "
                + "?"
            + ")"
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        preparedStatement.setString(i++, entity.getKode_rekening());
        preparedStatement.setInt(i++, entity.getJumlah());
        preparedStatement.setString(i++, entity.getHeader_nomor());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void delete(KasMasukDetail entity) throws SQLException{
        String sql = "DELETE "
            +  "FROM "
                + "tr_kas_masuk_detail "
            +  "WHERE  "
                + "header_nomor = ?"
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;        
       preparedStatement.setString(i++, entity.getHeader_nomor());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public Vector<KasMasukDetail> get(String key) {
        String sql = "SELECT "
                + "tr_kas_masuk_detail.id AS tr_kas_masuk_detail_id, "
                + "tr_kas_masuk_detail.kode_rekening AS tr_kas_masuk_detail_kode_rekening, "
                + "tr_kas_masuk_detail.jumlah AS tr_kas_masuk_detail_jumlah, "
                + "tr_kas_masuk_detail.header_nomor AS tr_kas_masuk_detail_header_nomor "
            + "FROM "
                + "tr_kas_masuk_detail "
            + "WHERE "
                + "tr_kas_masuk_detail.header_nomor = ?"
        ;
        
        Vector<KasMasukDetail> entitys = new Vector<KasMasukDetail>();
        PreparedStatement preparedStatement = null; 
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            preparedStatement.setString(i++, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                KasMasukDetail entity = new KasMasukDetail();
                entity.setId(resultSet.getInt("tr_kas_masuk_detail_id"));
                entity.setKode_rekening(resultSet.getString("tr_kas_masuk_detail_kode_rekening"));
                entity.setJumlah(resultSet.getInt("tr_kas_masuk_detail_jumlah"));
                entity.setHeader_nomor(resultSet.getString("tr_kas_masuk_detail_header_nomor"));
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
