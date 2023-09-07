package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sistem_akuntansi.entity.Pbf;
/**
 *
 * @author VELIK
 */
public class PbfModel {
     private Connection connection;

    public PbfModel(Connection connection) {
        this.connection = connection;
    }
    public void insert(Pbf entity) throws SQLException{
        String sql = "INSERT INTO "
            + "ms_pbf("
                + "kode_pbf, "
                + "nama_pbf, "
                + "alamat, "
                + "telepon, "
                + "kota"
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
        preparedStatement.setString(i++, entity.getKode_pbf());
        preparedStatement.setString(i++, entity.getNama_pbf());
        preparedStatement.setString(i++, entity.getAlamat());
        preparedStatement.setString(i++, entity.getTelepon());
        preparedStatement.setString(i++, entity.getKota());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public void update(Pbf entity) throws SQLException{
        String sql = "UPDATE "
            + "ms_pbf SET "
                + "kode_pbf = ?, "
                + "nama_pbf = ?, "
                + "alamat = ?, "
                + "telepon = ?, "
                + "kota = ? "
            + "WHERE "
                + "kode_pbf = ?"
        ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        preparedStatement.setString(i++, entity.getKode_pbf());
        preparedStatement.setString(i++, entity.getNama_pbf());
        preparedStatement.setString(i++, entity.getAlamat());
        preparedStatement.setString(i++, entity.getTelepon());
        preparedStatement.setString(i++, entity.getKota());
        preparedStatement.setString(i++, entity.getKode_pbf());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
     public void delete(Pbf entity) throws SQLException{
        String sql= "DELETE "
            +  "FROM "
                + "ms_pbf "
            +  "WHERE  "
                + "kode_pbf = ?"            
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, entity.getKode_pbf());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
     
      public Vector<Pbf> selectAll(){
        String sql = "SELECT "
                + "ms_pbf.kode_pbf AS ms_pbf_kode_pbf, "
                + "ms_pbf.nama_pbf AS ms_pbf_nama_pbf, "
                + "ms_pbf.alamat AS ms_pbf_alamat, "
                + "ms_pbf.telepon AS ms_pbf_telepon, "
                + "ms_pbf.kota AS ms_pbf_kota "
            + "FROM "
                + "ms_pbf"
        ;
        Vector<Pbf> vPbf = new Vector<Pbf>();
        PreparedStatement preparedStatementt = null;
        try {
            preparedStatementt = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                Pbf entity= new Pbf();
                entity.setKode_pbf(resultSet.getString("ms_pbf_kode_pbf"));
                entity.setNama_pbf(resultSet.getString("ms_pbf_nama_pbf"));
                entity.setAlamat(resultSet.getString("ms_pbf_alamat"));
                entity.setTelepon(resultSet.getString("ms_pbf_telepon"));
                entity.setKota(resultSet.getString("ms_pbf_kota"));

                vPbf.add(entity);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
     }finally{
             if (preparedStatementt != null) try {
                preparedStatementt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return vPbf;
    }
      
      public Vector<Pbf> search(String keyword) {
          String sql= "SELECT kode_pbf, nama_pbf, alamat, telepon, kota FROM ms_pbf WHERE kode_pbf LIKE ? OR nama_pbf LIKE ?";        
        Vector<Pbf> pbf = new Vector<Pbf>();
        PreparedStatement statement = null; 
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet result= statement.executeQuery();
            while (result.next()){
                Pbf entity = new Pbf();
                entity.setKode_pbf(result.getString("kode_pbf"));
                entity.setNama_pbf(result.getString("nama_pbf"));
                entity.setAlamat(result.getString("alamat"));
                entity.setTelepon(result.getString("telepon"));
                entity.setKota(result.getString("kota"));
                pbf.add(entity);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }    
        return pbf;
        }
      
      
      public Pbf get(String kode_pbf) {
        String sql= "SELECT "
                + "ms_pbf.kode_pbf AS ms_pbf_kode_pbf, "
                + "ms_pbf.nama_pbf AS ms_pbf_nama_pbf, "
                + "ms_pbf.alamat AS ms_pbf_alamat, "
                + "ms_pbf.telepon AS ms_pbf_telepon, "
                + "ms_pbf.kota AS ms_pbf_kota "
            + "FROM "
                + "ms_pbf "
            + "WHERE "
                + "kode_pbf = ?";
        
        Pbf entity= new Pbf();
        PreparedStatement preparedStatementt = null;
        try {
            preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setString(1, kode_pbf);
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                entity.setKode_pbf(resultSet.getString("ms_pbf_kode_pbf"));
                entity.setNama_pbf(resultSet.getString("ms_pbf_nama_pbf"));
                entity.setAlamat(resultSet.getString("ms_pbf_alamat"));
                entity.setTelepon(resultSet.getString("ms_pbf_telepon"));
                entity.setKota(resultSet.getString("ms_pbf_kota"));
            }    
     
        } catch (SQLException ex){
             ex.printStackTrace();
        } finally{
            if (preparedStatementt != null) try {
                preparedStatementt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         return entity;
    }                
}
