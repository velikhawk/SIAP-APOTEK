package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistem_akuntansi.entity.ReturnObat;
/**
 *
 * @author VELIK
 */
public class ReturnModel {
  private Connection connection;

    public ReturnModel(Connection connection) {
        this.connection = connection;
    }
    public void insert(ReturnObat retur) throws SQLException{
       String sql="INSERT INTO "
       +"tr_return("
            +"nomor, "
            +"tanggal_return, "
            +"kode_pbf, "
            +"nofaktur, "
            +"total"
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
       preparedStatement.setString(i++, retur.getNomor());
       preparedStatement.setDate(i++, new java.sql.Date(retur.getTanggal_return().getTime()));
       preparedStatement.setString(i++, retur.getKode_pbf());
       preparedStatement.setString(i++, retur.getNofaktur());
       preparedStatement.setInt(i++, retur.getTotal());
       
       preparedStatement.executeUpdate();
       preparedStatement.close();
    }
    
    public void update(ReturnObat entity) throws SQLException{
        String sql = "UPDATE "
            + "tr_return SET "                
                + "tanggal_return = ?, "
                + "kode_pbf = ?, "
                + "nofaktur = ?, "
                + "total = ? "
            + "WHERE "
                + "nomor = ?"
        ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
//        preparedStatement.setString(i++, entity.getNomor());
        preparedStatement.setDate(i++, new java.sql.Date(entity.getTanggal_return().getTime()));
        preparedStatement.setString(i++, entity.getKode_pbf());
        preparedStatement.setString(i++, entity.getNofaktur());
        preparedStatement.setInt(i++, entity.getTotal());
        preparedStatement.setString(i++, entity.getNomor());
         
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public void delete(ReturnObat entity) throws SQLException{
        String sql= "DELETE "
            +  "FROM "
                + "tr_return "
            +  "WHERE  "
                + "nomor = ?"            
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public String getNewNomor(){
       String sql = "SELECT "
               + "IF ("
               + "MAX(CAST(RIGHT(tr_penjualan.nomor,8) AS UNSIGNED)), "
               + "MAX(CAST(RIGHT(tr_penjualan.nomor,8) AS UNSIGNED))+1, "
               +"1"
               +") AS nomor "
               +"FROM "
               +"tr_return";
       int newNomor = 0;
       PreparedStatement statement = null;
       try{
           statement =connection.prepareStatement(sql);
           ResultSet result = statement.executeQuery();
           if (result.next()){
               newNomor = result.getInt("nomor");
           }
       }catch (SQLException ex) {
           ex.printStackTrace();
       }finally {
           if (statement != null) try {
               statement.close();
           }catch (SQLException ex) {
               ex.printStackTrace();
           }
       }
       return String.format("RR%06d", newNomor);
   }
}
