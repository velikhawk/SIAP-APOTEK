package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistem_akuntansi.entity.ReturnDetail;
/**
 *
 * @author VELIK
 */
public class ReturnDetailModel {
     private Connection connection;

    public ReturnDetailModel(Connection connection) {
        this.connection = connection;
    }
     public void insert(ReturnDetail retur) throws SQLException{
       String sql="INSERT INTO "
       +"tr_return_detail("
            +"kode_obat, "
            +"harga, "
            +"kuantiti, "
            +"jumlah, "
            +"header_nomor "
       + ") VALUES("
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?"
            + ")";
       
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
       int i = 1;
//       preparedStatement.setInt(i++, retur.getId());
       preparedStatement.setString(i++, retur.getKode_obat());
       preparedStatement.setInt(i++, retur.getHarga());
       preparedStatement.setInt(i++, retur.getKuantiti());
       preparedStatement.setInt(i++, retur.getJumlah());
       preparedStatement.setString(i++, retur.getHeader_nomor());
       
       preparedStatement.executeUpdate();
       preparedStatement.close();
     }
     
     public void update(ReturnDetail entity) throws SQLException{
        String sql = "UPDATE "
            + "tr_return_detail SET "
                + "id = ?, "
                + "kode_obat = ?, "
                + "harga = ?, "
                + "kuantiti = ?, "
                + "jumlah = ?, "
                + "header_nomor = ? "
            + "WHERE "
                + "id = ?"
        ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
       int i = 1;
       preparedStatement.setInt(i++, entity.getId());
       preparedStatement.setString(i++, entity.getKode_obat());
       preparedStatement.setInt(i++, entity.getHarga());
       preparedStatement.setInt(i++, entity.getKuantiti());
       preparedStatement.setInt(i++, entity.getJumlah());
       preparedStatement.setString(i++, entity.getHeader_nomor());
       preparedStatement.setInt(i++, entity.getId());
       
       preparedStatement.executeUpdate();
       preparedStatement.close();
     }
     public void delete(ReturnDetail entity) throws SQLException{
        String sql= "DELETE "
            +  "FROM "
                + "tr_return_detail "
            +  "WHERE  "
                + "id = ?"            
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
