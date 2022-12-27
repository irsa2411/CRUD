/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmahasiswasederhana.models;

import com.irsa.churd.crudmahasiswasederhana.db.ConnectionHelper;
import crudmahasiswasederhana.interfc.MahasiswaInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class MahasiswaController implements MahasiswaInterface{
    PreparedStatement st;

    @Override
    public Mahasiswa insert(Mahasiswa o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Insert into mahasiswa values(?,?,?)");
        st.setString(1, o.getNim());
        st.setString(2, o.getNama());
        st.setString(3, o.getAlamat());
        st.executeUpdate();
        return o;
    }

    public void update(Mahasiswa o) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
                "Update Mahasiswa set nama=?, alamat=?, where nim=?");

        st.setString(1, o.getNim());
        st.setString(2, o.getNama());
        st.setString(3, o.getAlamat());
        st.executeUpdate();
    }


    @Override
    public void delete(String nim) throws SQLException {
        st = ConnectionHelper.getConnection().prepareStatement(
        "Delete from mahasiswa where nim=?");
    }
    @Override
    public List<Mahasiswa> getAll() throws SQLException {
        Statement st=ConnectionHelper.getConnection().createStatement();
        ResultSet rs=st.executeQuery("Select * from mahasiswa");
        List<Mahasiswa>list=new ArrayList<Mahasiswa>();
        while(rs.next()){
            Mahasiswa mhs=new Mahasiswa(null,null,null);
            mhs.setNim("Nim");
            mhs.setNama("Nama");
            mhs.setAlamat("Alamat");
            list.add(mhs);
        }
        return list;
    }
}