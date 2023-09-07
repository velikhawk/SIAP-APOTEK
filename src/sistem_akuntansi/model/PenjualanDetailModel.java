package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sistem_akuntansi.entity.PenjualanDetail;

/**
 *
 * @author VELIK
 */
public class PenjualanDetailModel {
    private Connection connection;

    public PenjualanDetailModel(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(PenjualanDetail penjualandetail) throws SQLException{
       String sql="INSERT INTO "
       +"tr_penjualan_detail("
            +"kode_obat, "
            +"kode_jenis, "
            +"kuantiti, "
            +"harga, "
            +"jumlah, "
            +"header_nomor"
       + ") VALUES("
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
       preparedStatement.setString(i++, penjualandetail.getKode_obat());
       preparedStatement.setString(i++, penjualandetail.getKode_jenis());
       preparedStatement.setInt(i++, penjualandetail.getKuantiti());
       preparedStatement.setInt(i++, penjualandetail.getHarga());
       preparedStatement.setInt(i++, penjualandetail.getJumlah());
       preparedStatement.setString(i++, penjualandetail.getHeader_nomor());
       
       preparedStatement.executeUpdate();
       preparedStatement.close();
}
    public Vector<PenjualanDetail> get(String key){
        String sql = "SELECT "
                +"tr_penjualan_detail.id AS tr_penjualan_detail_id, "
                + "tr_penjualan_detail.kode_barang AS tr_penjualan_detail.kode_obat, "
                + "tr_penjualan_detail.kode_jenis AS tr_penjualan_detail.kode_jenis, "
                +"tr_penjualan_detail.kuantiti AS tr_penjualan_detail_kuantiti, "
                +"tr_penjualan_detail.harga AS tr_penjualan_detail_harga, "
                + "tr_penjualan_detail.jumlah AS tr_penjualan_detail_jumlah, "
                + "tr_penjualan_detail.header_nomor AS tr_penjualan_detail_header_nomor"
                + "FROM"
                + "tr_penjualan_detail "
                + "WHERE"
                + "tr_penjualan_detail.header_nomor = ? ";
        
        Vector<PenjualanDetail> entitys = new Vector<PenjualanDetail>();
        PreparedStatement preparedStatement = null;
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            preparedStatement.setString(i++, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                PenjualanDetail entity = new PenjualanDetail();
                
                entity.setId(resultSet.getInt("tr_penjualan_detail_id"));
                entity.setKode_obat(resultSet.getString("tr_penjualan_detail_kode_obat"));
                entity.setKode_jenis(resultSet.getString("tr_penjualan_detail_kode_jenis"));
                entity.setKuantiti(resultSet.getInt("tr_penjualan_detail_kuantiti"));
                entity.setHarga(resultSet.getInt("tr_penjualan_detail_harga"));
                entity.setJumlah(resultSet.getInt("tr_penjualan_detail_jumlah"));
                entity.setHeader_nomor(resultSet.getString("tr_penjualan_detail_header_nomor"));
                entitys.add(entity);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) try{
                preparedStatement.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return entitys;
    }
}
