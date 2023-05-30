/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO;
import Model.Model;
import Tabel_Model.Tabel_Model;
import Implement.Implement;
import View.ViewLaundry;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Controller_Laundry {
    ViewLaundry frame;
    Implement implement;
    List<Model> list;
    
    public Controller_Laundry(ViewLaundry frame){
        this.frame = frame;
        implement = new DAO();
        list = implement.getALL();
        Tabel_Model tmb = new Tabel_Model(list);
        
    }

    
    public void reset(){
        frame.getTidtransaksi().setText("");
        frame.getTnama().setText("");
        frame.getCbxjenis().setSelectedItem("--Silahkan Pilih--");
        frame.getTberat().setText("");
        frame.getTharga().setText("");
        frame.getTtotal().setText("");
        
    }
    
    //Tampil Data Ke Tabel
    public void isiTable(){
        list = implement.getALL();
        Tabel_Model tmb = new Tabel_Model(list);
        frame.getTabeldata().setModel(tmb);
    }
    
     public void isiField(int row){
        frame.getTidtransaksi1().setText(list.get(row).getId_transaksi());
        frame.getTnama1().setText(list.get(row).getNama_customer());
        frame.getCbxjenis1().setSelectedItem(list.get(row).getJenis_layanan());
        frame.getTberat1().setText(list.get(row).getJumlah_berat());
        frame.getTharga1().setText(list.get(row).getHarga_perkilo());
        frame.getTtotal1().setText(list.get(row).getTotal_harga());
        
    }
    
     
    public void insert(){
        if(!frame.getTidtransaksi().getText().trim().isEmpty()& !frame.getTnama().getText().trim().isEmpty()& !frame.getTberat().getText().trim().isEmpty()& !frame.getTharga().getText().trim().isEmpty()& !frame.getTtotal().getText().trim().isEmpty()){
            Model l = new Model();
            
            l.setId_transaksi(frame.getTidtransaksi().getText());
            l.setNama_customer(frame.getTnama().getText());
            l.setJenis_layanan(frame.getCbxjenis().getSelectedItem().toString()); 
            l.setJumlah_berat(frame.getTberat().getText());
            l.setHarga_perkilo(frame.getTharga().getText());
            l.setTotal_harga(frame.getTtotal().getText());
            
            
            implement.insert(l);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        } else {
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }
    
    //Update Data Dari Tabel Ke Database
    public void update(){
        if(!frame.getTidtransaksi1().getText().trim().isEmpty()){
            Model l = new Model();
            
            l.setNama_customer(frame.getTnama1().getText());
            l.setJenis_layanan(frame.getCbxjenis1().getSelectedItem().toString()); 
            l.setJumlah_berat(frame.getTberat1().getText());
            l.setHarga_perkilo(frame.getTharga1().getText());
            l.setTotal_harga(frame.getTtotal1().getText());
            
            implement.update(l);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame, "Silahkan Pilih Data Yang Akan Di Update");
        }
    }
    
    //Hapus Data Pada Tabel
    public void delete(){
        if(!frame.getTidtransaksi1().getText().trim().isEmpty()){
            String id_transaksi = frame.getTidtransaksi1().getText();
            implement.delete(id_transaksi);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame, "Silahkan Pilih Data Yang Akan Di Hapus");
        }
    }
    
     
}
