/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import model.DAOcompras;
import java.sql.CallableStatement;
import java.sql.Connection;
import model.connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author star
 */
public class NCompra {

    private connection mysql = new connection();
    private Connection connect = mysql.Conect();
    private String sql;

    public boolean insertar(DAOcompras v) {

        sql = " insert into compras (codigocompras,codigoempl,fecha,total) values (?,?,?,?)";

        try {

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setInt(1, v.getCodigoCompra());

            pst.setInt(2, v.getCodEmpleado());

            pst.setString(3, v.getFecha());

            pst.setString(4, v.getTotal());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            return false;

        }

    }

    public boolean detalle(DAOcompras v) {

        sql = " insert into comprasdetalle (codigocompras,id_inventario,cantidad,valor_unitario,total) values (?,?,?,?,?)";

        try {

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setInt(1, v.getCodigoCompra());

            pst.setString(2, v.getInventario());
            pst.setString(3, v.getCantidad());

            pst.setString(4, v.getValor_unitario());

            pst.setString(5, v.getTotal());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            return false;

        }

    }

    ///************************----------------------------------------
    public String Autogenerar() {

        String d = "";

        PreparedStatement ps;

        ResultSet rs;
        sql = "select  max(CODIGOCOMPRAS) from COMPRAS";

        try {

            PreparedStatement pst = connect.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {

                d = rs.getString(1);
            }

        } catch (Exception e) {

        }
        return d;

    }

}
