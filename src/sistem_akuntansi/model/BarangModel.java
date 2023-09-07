package sistem_akuntansi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import sistem_akuntansi.entity.Barang;

/**
 *
 * @author VELIK
 */
public class BarangModel {
     private Connection connection;

    public BarangModel(Connection connection) {
        this.connection = connection;
    }
        
    public void insert(Barang entity) throws SQLException{
        String sql = "INSERT INTO "
            + "ms_barang("
                + "kode_obat, "
                + "nama_obat, "
                + "kode_jenis, "
                + "tanggal_kadaluwarsa, "
                + "jumlah, "
                + "harga_beli, "
                + "harga_jual"
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
        preparedStatement.setString(i++, entity.getKode_obat());
        preparedStatement.setString(i++, entity.getNama_obat());
        preparedStatement.setString(i++, entity.getKode_jenis());
        preparedStatement.setDate(i++, new java.sql.Date(entity.getTanggal_kadaluwarsa().getTime()));
        preparedStatement.setInt(i++, entity.getJumlah());
        preparedStatement.setInt(i++, entity.getHarga_beli());
        preparedStatement.setInt(i++, entity.getHarga_jual());

        preparedStatement.executeUpdate();
        preparedStatement.close();
}
    
     public void update(Barang entity) throws SQLException{
        String sql = "UPDATE "
            + "ms_barang SET "
                + "kode_obat = ?, "
                + "nama_obat = ?, "
                + "kode_jenis = ?, "
                + "tanggal_kadaluwarsa = ?, "
                + "jumlah = ?, "
                + "harga_beli = ?, "
                + "harga_jual = ? "
            + "WHERE "
                + "kode_obat = ?"
        ;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = 1;
        preparedStatement.setString(i++, entity.getKode_obat());
        preparedStatement.setString(i++, entity.getNama_obat());
        preparedStatement.setString(i++, entity.getKode_jenis());
        preparedStatement.setDate(i++, new java.sql.Date(entity.getTanggal_kadaluwarsa().getTime()));
        preparedStatement.setInt(i++, entity.getJumlah());
        preparedStatement.setInt(i++, entity.getHarga_beli());
        preparedStatement.setInt(i++, entity.getHarga_jual());
        preparedStatement.setString(i++, entity.getKode_obat());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
     }
     
     public void delete(Barang entity) throws SQLException{
        String sql= "DELETE "
            +  "FROM "
                + "ms_barang "
            +  "WHERE  "
                + "kode_obat = ?"            
        ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, entity.getKode_obat());
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
     
     public Vector<Barang> selectAll(){
        String sql = "SELECT "
                + "ms_barang.kode_obat AS ms_barang_kode_obat, "
                + "ms_barang.nama_obat AS ms_barang_nama_obat, "
                + "ms_barang.kode_jenis AS ms_barang_kode_jenis, "
                + "ms_barang.tanggal_kadaluwarsa AS ms_barang_tanggal_kadaluwarsa, "
                + "ms_barang.jumlah AS ms_barang_jumlah, "
                + "ms_barang.harga_beli AS ms_barang_harga_beli, "
                + "ms_barang.harga_jual AS ms_barang_harga_jual "
            + "FROM "
                + "ms_barang"
        ;
        Vector<Barang> vBarang = new Vector<Barang>();
        PreparedStatement preparedStatementt = null;
        try {
            preparedStatementt = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                Barang entity= new Barang();
                entity.setKode_obat(resultSet.getString("ms_barang_kode_obat"));
                entity.setNama_obat(resultSet.getString("ms_barang_nama"));
                entity.setKode_jenis(resultSet.getString("ms_barang_kode_jenis"));
                entity.setTanggal_kadaluwarsa(resultSet.getDate("ms_barang_tanggal_kadaluwarsa"));
                entity.setJumlah(resultSet.getInt("ms_barang_jumlah"));
                entity.setHarga_beli(resultSet.getInt("ms_barang_harga_beli"));
                entity.setHarga_jual(resultSet.getInt("ms_barang_harga_jual"));

                vBarang.add(entity);
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
         return vBarang;
     }    
     
     public Barang get(String kode_obat) {
        String sql= "SELECT "
                + "ms_barang.kode_obat AS ms_barang_kode_obat, "
                + "ms_barang.nama_obat AS ms_barang_nama_obat, "
                + "ms_barang.kode_jenis AS ms_barang_kode_jenis, "
                + "ms_barang.tanggal_kadaluwarsa AS ms_barang_tanggal_kadaluwarsa, "
                + "ms_barang.jumlah AS ms_barang_jumlah, "
                + "ms_barang.harga_beli AS ms_barang_harga_beli, "
                + "ms_barang.harga_jual AS ms_barang_harga_jual "
            + "FROM "
                + "ms_barang "
            + "WHERE "
                + "kode_obat = ?";
        
        Barang entity= new Barang();
        PreparedStatement preparedStatementt = null;
        try {
            preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setString(1, kode_obat);
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                entity.setKode_obat(resultSet.getString("ms_barang_kode_obat"));
                entity.setNama_obat(resultSet.getString("ms_barang_nama_obat"));
                entity.setKode_jenis(resultSet.getString("ms_barang_kode_jenis"));
                entity.setTanggal_kadaluwarsa(resultSet.getDate("ms_barang_tanggal_kadaluwarsa"));
                entity.setJumlah(resultSet.getInt("ms_barang_jumlah"));
                entity.setHarga_beli(resultSet.getInt("ms_barang_harga_beli"));
                entity.setHarga_jual(resultSet.getInt("ms_barang_harga_jual"));
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
      public Vector<Barang> search(String keyword) {
           String sql = "SELECT "
                + "ms_barang.kode_obat AS ms_barang_kode_obat, "
                + "ms_barang.nama_obat AS ms_barang_nama_obat, "
                + "ms_barang.kode_jenis AS ms_barang_kode_jenis, "
                + "ms_barang.tanggal_kadaluwarsa AS ms_barang_tanggal_kadaluwarsa, "
                + "ms_barang.jumlah AS ms_barang_jumlah, "
                + "ms_barang.harga_beli AS ms_barang_harga_beli, "
                + "ms_barang.harga_jual AS ms_barang_harga_jual "
            + "FROM "
                + "ms_barang "
            + "WHERE "
                + "kode_obat LIKE ? "
                + "OR nama_obat LIKE ?"
        ;
           Vector<Barang> vBarang = new Vector<Barang>();
        PreparedStatement preparedStatementt = null;
        
        try {
            preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setString(1, "%"+keyword+"%");
            preparedStatementt.setString(2, "%"+keyword+"%");
            ResultSet resultSet = preparedStatementt.executeQuery();
            while (resultSet.next()){
                Barang entity= new Barang();
                entity.setKode_obat(resultSet.getString("ms_barang_kode_obat"));
                entity.setNama_obat(resultSet.getString("ms_barang_nama_obat"));
                entity.setKode_jenis(resultSet.getString("ms_barang_kode_jenis"));
                entity.setTanggal_kadaluwarsa(resultSet.getDate("ms_barang_tanggal_kadaluwarsa"));
                entity.setJumlah(resultSet.getInt("ms_barang_jumlah"));
                entity.setHarga_beli(resultSet.getInt("ms_barang_harga_beli"));
                entity.setHarga_jual(resultSet.getInt("ms_barang_harga_jual"));

                vBarang.add(entity);
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
        return vBarang;
    }
}
