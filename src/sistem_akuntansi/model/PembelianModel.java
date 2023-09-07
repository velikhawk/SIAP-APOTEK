package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sistem_akuntansi.entity.Pembelian;

/**
 *
 * @author VELIK
 */
public class PembelianModel {
     private Connection connection;

    public PembelianModel(Connection connection) {
        this.connection = connection;
    }
    public void insert(Pembelian pembelian) throws SQLException{
       String sql="INSERT INTO "
       +"tr_pembelian("
            +"nofaktur, "
            +"tanggal, "
            +"kode_pbf, "
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
       preparedStatement.setString(i++, pembelian.getNofaktur());
       preparedStatement.setDate(i++, new java.sql.Date(pembelian.getTanggal().getTime()));
       preparedStatement.setString(i++, pembelian.getKode_pbf());
       preparedStatement.setInt(i++, pembelian.getTotal());
       
       preparedStatement.executeUpdate();
       preparedStatement.close();
}
     public void update(Pembelian entity) throws SQLException{
        String sql = "UPDATE "
            + "tr_pembalian SET "
                + "nofaktur = ?, "
                + "tanggal = ?, "
                + "kode_pbf = ?, "
                + "total = ?"
            + "WHERE "
                + "nofaktur = ? "
        ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        preparedStatement.setString(i++, entity.getNofaktur());
        preparedStatement.setDate(i++, new java.sql.Date(entity.getTanggal().getTime()));
        preparedStatement.setString(i++, entity.getKode_pbf());
        preparedStatement.setInt(i++, entity.getTotal());
        preparedStatement.setString(i++, entity.getNofaktur());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
     
     public void delete(Pembelian entity) throws SQLException{
        String sql= "DELETE "
            +  "FROM "
                + "tr_pembelian "
            +  "WHERE  "
                + "nofaktur = ?"            
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, entity.getNofaktur());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
      public Vector<Pembelian> search(String keyword) {
          String sql = "SELECT "
                + "tr_pembelian.nofaktur AS tr_pembelian_nofaktur, "
                + "tr_pembelian.tanggal AS tr_pembelian_tanggal, "
                + "tr_pembelian.kode_pbf AS tr_pembelian_kode_pbf, "
                + "tr_pembelian.total AS tr_pembelian_total "
            + "FROM "
                + "tr_pembelian "
            + "WHERE "
                + "nofaktur LIKE ? "
                + "OR nofaktur LIKE ?"
        ;
          Vector<Pembelian> vPembelian = new Vector<Pembelian>();
        PreparedStatement preparedStatementt = null;
        
        try {
            preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setString(1, "%"+keyword+"%");
            preparedStatementt.setString(2, "%"+keyword+"%");
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                Pembelian entity= new Pembelian();
                entity.setNofaktur(resultSet.getString("tr_pembelian_nofaktur"));
                entity.setKode_pbf(resultSet.getString("tr_pembelian_kode_pbf"));
                entity.setTanggal(resultSet.getDate("tr_pembelian_tanggal"));
                entity.setTotal(resultSet.getInt("tr_pembelian_total"));

                vPembelian.add(entity);
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
        return vPembelian;
    
      }
       public String getNewNomor(){
       String sql = "SELECT "
               + "IF ("
               + "MAX(CAST(RIGHT(tr_pembelian.nofaktur,6) AS UNSIGNED)), "
               + "MAX(CAST(RIGHT(tr_pembelian.nofaktur,6) AS UNSIGNED))+1, "
               +"1"
               +") AS nofaktur "
               +"FROM "
               +"tr_pembelian";
       int newNomor = 0;
       PreparedStatement statement = null;
       try{
           statement =connection.prepareStatement(sql);
           ResultSet result = statement.executeQuery();
           if (result.next()){
               newNomor = result.getInt("nofaktur");
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
