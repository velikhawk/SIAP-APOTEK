package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sistem_akuntansi.entity.PembelianDetail;

/**
 *
 * @author VELIK
 */
public class PembelianDetailModel {
    private Connection connection;

    public PembelianDetailModel(Connection connection) {
        this.connection = connection;
    }
      public void insert(PembelianDetail pembeliandetail) throws SQLException{
       String sql="INSERT INTO "
           +"tr_pembelian_detail("
                +"kode_obat, "
                +"kuantiti, "
                +"harga, "
                +"jumlah, "
                +"exp_date, "
                +"header_nofaktur"
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
       preparedStatement.setString(i++, pembeliandetail.getKode_obat());
       preparedStatement.setInt(i++, pembeliandetail.getKuantiti());
       preparedStatement.setInt(i++, pembeliandetail.getHarga());
       preparedStatement.setInt(i++, pembeliandetail.getJumlah());
       preparedStatement.setDate(i++, new java.sql.Date(pembeliandetail.getExp_date().getTime()));
       preparedStatement.setString(i++, pembeliandetail.getHeader_nofaktur());
       
       preparedStatement.executeUpdate();
       preparedStatement.close();
}
      
       public void update(PembelianDetail entity) throws SQLException{
        String sql = "UPDATE "
            + "tr_pembalian_detail SET "
                + "id = ?, "
                + "kode_obat = ?, "
                + "kuantiti = ?, "
                + "harga = ?, "
                + "jumlah = ?, "
                + "exp_date = ?, "
                
            + "WHERE "
                + "id = ?"
        ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        preparedStatement.setInt(i++, entity.getId());
        preparedStatement.setString(i++, entity.getKode_obat());
        preparedStatement.setInt(i++, entity.getKuantiti());
        preparedStatement.setInt(i++, entity.getHarga());
        preparedStatement.setInt(i++, entity.getJumlah());
        preparedStatement.setDate(i++, new java.sql.Date(entity.getExp_date().getTime()));
       
        preparedStatement.setInt(i++, entity.getId());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
        
    }
       public void delete(PembelianDetail entity) throws SQLException{
        String sql= "DELETE "
            +  "FROM "
                + "tr_pembelian_detail "
            +  "WHERE  "
                + "id = ?"            
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, entity.getId());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
       public Vector<PembelianDetail> search(String keyword) {
          String sql = "SELECT "
                + "tr_pembelian_detail.kode_obat AS tr_pembelian_detail_kode_obat, "
                + "tr_pembelian_detail.kuantiti AS tr_pembelian_detail_kuantiti, "
                + "tr_pembelian_detail.harga AS tr_pembelian_detail_harga, "
                + "tr_pembelian_detail.jumlah AS tr_pembelian_detail_jumlah, "
                + "tr_pembelian_detail.exp_date AS tr_pembelian_detail_exp_date, "
                + "tr_pembelian_detail.header_nofaktur AS tr_pembelian_detail_header_nofaktur "
            + "FROM "
                + "tr_pembelian_detail "
            + "WHERE "
                + "kode_obat LIKE ? "
                + "OR header_nofaktur LIKE ?"
        ;
          Vector<PembelianDetail> vPembelianDetail = new Vector<PembelianDetail>();
        PreparedStatement preparedStatementt = null;
        
        try {
            preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setString(1, "%"+keyword+"%");
            preparedStatementt.setString(2, "%"+keyword+"%");
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                PembelianDetail entity= new PembelianDetail();
                entity.setKode_obat(resultSet.getString("tr_pembelian_detail_kode_obat"));
                entity.setKuantiti(resultSet.getInt("tr_pembelian_detail_kuantiti"));
                entity.setExp_date(resultSet.getDate("tr_pembelian_detail_exp_date"));
                entity.setHarga(resultSet.getInt("tr_pembelian_detail_harga"));
                entity.setJumlah(resultSet.getInt("tr_pembelian_detail_jumlah"));
                entity.setHeader_nofaktur(resultSet.getString("tr_pembelian_detail_header_nofaktur"));

                vPembelianDetail.add(entity);
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
        return vPembelianDetail;
    
      }
       
}
