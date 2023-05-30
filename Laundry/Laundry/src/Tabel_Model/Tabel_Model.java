/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabel_Model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Model;

public class Tabel_Model extends AbstractTableModel{
    
    java.util.List<Model> list_laundry;
    
    public Tabel_Model(java.util.List<Model> list_laundry){
        this.list_laundry = list_laundry;
    }
    

    @Override
    public int getRowCount() {
        return list_laundry.size(); 
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    

     @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID TRANSAKSI";
            case 1:
                return "NAMA CUSTOMER";
            case 2:
                return "NO JENIS LAYANAN";
            case 3:
                return "JUMLAH BERAT";
            case 4:
                return "HARGA PER-KILO";
            case 5:
                return "TOTAL HARGA";
            
            default:
                return null;
             
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return list_laundry.get(row).getId_transaksi();
            case 1:
                return list_laundry.get(row).getNama_customer();
            case 2:
                return list_laundry.get(row).getJenis_layanan();
            case 3:
                return list_laundry.get(row).getJumlah_berat();
            case 4:
                return list_laundry.get(row).getHarga_perkilo();
            case 5:
                return list_laundry.get(row).getTotal_harga();
            
            default:
                return null;
             
        }
    }
}
