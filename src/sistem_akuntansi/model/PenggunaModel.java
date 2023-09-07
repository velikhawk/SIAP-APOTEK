package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sistem_akuntansi.entity.Pengguna;
/**
 *
 * @author VELIK
 */
public class PenggunaModel {
    private Connection connection;
    
    public PenggunaModel(Connection connection) {
        this.connection = connection;
    }
    public void insert(Pengguna entity) throws SQLException{
        String sql = "INSERT INTO "
            + "ms_pengguna("
                + "nama_pengguna, "
                + "username, "
                + "password, "
                + "level, "
                + "jenis_kelamin, "
                + "no_telpon, "
                + "alamat"
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
        preparedStatement.setString(i++, entity.getNama_pengguna());
        preparedStatement.setString(i++, entity.getUsername());
        preparedStatement.setString(i++, entity.getPassword());
        preparedStatement.setString(i++, entity.getLevel());
        preparedStatement.setString(i++, entity.getJenis_kelamin());
        preparedStatement.setString(i++, entity.getNo_telpon());
        preparedStatement.setString(i++, entity.getAlamat());

        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
    public Pengguna get(String username)throws SQLException {
        String sql = "SELECT "
                + "ms_pengguna.username AS ms_pengguna_username, "
                + "ms_pengguna.password AS ms_pengguna_password, "
                + "ms_pengguna.level AS ms_pengguna_level "
                + "FROM "
                + "ms_pengguna "
            + "WHERE "
                + "username = ?";
        
        Pengguna entity= new Pengguna();
        PreparedStatement preparedStatementt = null;
        try {
            preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setString(1, username);
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                entity.setUsername(resultSet.getString("ms_pengguna_username"));
                entity.setPassword(resultSet.getString("ms_pengguna_password"));
                entity.setLevel(resultSet.getString("ms_pengguna_level"));
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
      public Vector<Pengguna> selectAll(){
        String sql = "SELECT "
                + "ms_pengguna.nama_pengguna AS ms_pengguna_nama_pengguna, "
                + "ms_pengguna.username AS ms_pengguna_username, "
                + "ms_pengguna.password AS ms_pengguna_password, "
                + "ms_pengguna.level AS ms_pengguna_level, "
                + "ms_pengguna.jenis_kelamin AS ms_pengguna_jenis_kelamin, "
                + "ms_pengguna.no_telpon AS ms_pengguna_no_telpon, "
                + "ms_pengguna.alamat AS ms_pengguna_alamat "
            + "FROM "
                + "ms_pengguna"
        ;
        Vector<Pengguna> vPengguna = new Vector<Pengguna>();
        PreparedStatement preparedStatementt = null;
        try {
            preparedStatementt = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                Pengguna entity= new Pengguna();
                entity.setNama_pengguna(resultSet.getString("ms_pengguna_nama_pengguna"));
                entity.setUsername(resultSet.getString("ms_pengguna_username"));
                entity.setPassword(resultSet.getString("ms_pengguna_password"));
                entity.setLevel(resultSet.getString("ms_pengguna_level"));
                entity.setJenis_kelamin(resultSet.getString("ms_pengguna_jenis_kelamin"));
                entity.setNo_telpon(resultSet.getString("ms_pengguna_no_telpon"));
                entity.setAlamat(resultSet.getString("ms_pengguna_alamat"));

                vPengguna.add(entity);
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
         return vPengguna;
     }    
     
}
