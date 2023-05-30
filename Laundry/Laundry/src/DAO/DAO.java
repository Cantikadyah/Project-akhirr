/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Koneksi;
import Model.Model;
import Implement.Implement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAO implements Implement{
    private Connection con;
    
    public DAO(){
        con = Koneksi.connection();
    }

    @Override
    public void insert(Model mdllaundry){
        PreparedStatement statement = null;
        String sql = "INSERT into transaksi(id_transaksi, nama_customer, jenis_layanan, jumlah_berat, harga_perkilo, total_harga) VALUES(?,?,?,?,?,?)";
        try{
            statement = con.prepareStatement(sql);
            statement.setString(1, mdllaundry.getId_transaksi());
            statement.setString(2, mdllaundry.getNama_customer());
            statement.setString(3, mdllaundry.getJenis_layanan());
            statement.setString(4, mdllaundry.getJumlah_berat());
            statement.setString(5, mdllaundry.getHarga_perkilo());
            statement.setString(6, mdllaundry.getTotal_harga());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                mdllaundry.setId_transaksi(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
       } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(Model mdllaundry){
        PreparedStatement statement = null;
        String sql = "UPDATE transaksi SET nama_customer=?, jenis_layanan=?, jumlah_berat=?, harga_perkilo=?, total_harga=? WHERE id_transaksi=?";
        try{
           statement = con.prepareStatement(sql);
            statement.setString(1, mdllaundry.getNama_customer());
            statement.setString(2, mdllaundry.getJenis_layanan());
            statement.setString(3, mdllaundry.getJumlah_berat());
            statement.setString(4, mdllaundry.getHarga_perkilo());
            statement.setString(5, mdllaundry.getTotal_harga());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
       } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(String id_transaksi){
        PreparedStatement statement = null;
        String sql = "DELETE FROM transaksi WHERE id_transaksi=?";
        try{
            statement = con.prepareStatement(sql);
            statement.setString(1, id_transaksi);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
       } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public String urutan() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        
        
        String sql = "SELECT RIGHT(id_transaksi, 3) AS Nomor FROM transaksi ORDER BY Nomor LIMIT 1";
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()){
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = String.format("LL%03d", nomor);
            }else {
                urutan = "LL001";
            }
        } catch (SQLException ex){
            java.util.logging.Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(st !=null){
                try{
                    st.close();
                } catch(SQLException ex){
                    java.util.logging.Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return urutan; 
    }
    
    @Override
    public java.util.List<Model> getALL(){
        java.util.List<Model> lb = null;
        String sql = "SELECT * FROM transaksi";
        try{
            lb = new ArrayList<Model>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Model l = new Model();
                l.setId_transaksi(rs.getString("id_transaksi"));
                l.setNama_customer(rs.getString("nama_customer"));
                l.setJenis_layanan(rs.getString("jenis_layanan"));
                l.setJumlah_berat(rs.getString("jumlah_berat"));
                l.setHarga_perkilo(rs.getString("harga_perkilo"));
                l.setTotal_harga(rs.getString("total_harga"));
               
                lb.add(l);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
       } 
        return lb;
    }

}
