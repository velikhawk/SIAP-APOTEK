package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sistem_akuntansi.entity.Penjualan;

/**
 *
 * @author VELIK
 */
public class PenjualanModel {
    private Connection connection;

    public PenjualanModel(Connection connection) {
        this.connection = connection;
    }
    
   public void insert(Penjualan penjualan) throws SQLException{
       String sql="INSERT INTO "
       +"tr_penjualan("
       +"nomor, "
       +"kode_pelanggan, "
       +"tanggal, "
       +"total"
       + ") VALUES("
                + "?, "
                + "?, "
                + "?, "
                + "?"
            + ")"
        ;
       
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
       int i = 1;
       preparedStatement.setString(i++, penjualan.getNomor());     
       preparedStatement.setString(i++, penjualan.getKode_pelanggan());
       preparedStatement.setDate(i++, new java.sql.Date(penjualan.getTanggal().getTime())); 
       preparedStatement.setInt(i++, penjualan.getTotal());
       
       preparedStatement.executeUpdate();
       preparedStatement.close();
    }
   
   public void delete(Penjualan entity)throws SQLException{
       String sql = "DELETE "
               + "FROM "
               +"tr_penjualan "
               + "WHERE "
               + "nomor = ? "
               ;
        PreparedStatement preparedStatement = 
                connection.prepareStatement(sql);
        int i = 1;
        preparedStatement.setString(i++, entity.getNomor());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
   }
   
   public Vector<Penjualan> get(String key){
       String sql = "SELECT "
               +"tr_penjualan.nomor AS tr_penjualan_nomor, "
               +"tr_penjualan.kode_pelanggan AS tr_penjualan_kode_pelanggan, "
               +"tr_penjualan.tanggal AS tr_penjualan_tanggal, "
               +"tr_penjualan.total AS tr_penjualan_total "
               
               + "FROM "
               + "tr_penjualan "
               + "WHERE "
               + "tr_penjualan.nomor = ?";
       Vector<Penjualan> entitys = new Vector<Penjualan>();
       PreparedStatement preparedStatement = null;
       
       try{
           preparedStatement = connection.prepareStatement(sql);
           int i = 1;
           preparedStatement.setString(i++, key);
           ResultSet resultSet = preparedStatement.executeQuery();
           
           while (resultSet.next()){
               Penjualan entity = new Penjualan();
               entity.setNomor(resultSet.getString("tr_penjualan_nomor"));
               entity.setKode_pelanggan(resultSet.getString("tr_penjualan_kode_pelanggan"));
               entity.setTanggal(resultSet.getDate("tr_penjualan_tanggal"));
               entity.setTotal(resultSet.getInt("tr_penjualan_total"));
               entitys.add(entity);
           }
       } catch (SQLException ex){
           ex.printStackTrace();
       }finally {
           if (preparedStatement != null) try {
               preparedStatement.close();
           } catch (SQLException ex){
               ex.printStackTrace();
           }
       }
        return entitys;
   }
   
   public String getNewNomor(){
       String sql = "SELECT "
               + "IF ("
               + "MAX(CAST(RIGHT(tr_penjualan.nomor,6) AS UNSIGNED)), "
               + "MAX(CAST(RIGHT(tr_penjualan.nomor,6) AS UNSIGNED))+1, "
               +"1"
               +") AS nomor "
               +"FROM "
               +"tr_penjualan";
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
       return String.format("JJ%06d", newNomor);
   }
}
