/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;
import java.util.List;
import Model.Model;


public interface Implement {
    public void insert(Model mdllaundry);
    public void update(Model mdllaundry);
    public void delete(String id_transaksi);
    
     public java.util.List<Model> getALL();
     String urutan();
}
