/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import model.DAOVentas;
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
public class NVenta {

    private connection mysql = new connection();
    private Connection connect = mysql.Conect();
    private String sql;

    private String sqlQuery;
    private String preQuery;

    public boolean insertar(DAOVentas v) {

        sql = " insert into venta (codigoventa,cod_persona,fecha,subtotal,iva,total,codigopag) values (?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setInt(1, v.getCodigoVenta());

            pst.setString(2, v.getNumero());

            pst.setString(3, v.getFecha());

            pst.setString(4, v.getSubTotal());

            pst.setString(5, v.getIva());

            pst.setString(6, v.getTotal());

            pst.setString(7, v.getPago());

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

    public boolean detalle(DAOVentas v) {

        sql = " insert into ventasdetalle (codigoventa,id_inventario,cantidad,valor_unitario,total) values (?,?,?,?,?)";

        try {

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setInt(1, v.getCodigoVenta());
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
        sql = "select  max(CODIGOVENTA) from VENTA";

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

    public DefaultTableModel consult(String search) {

        DefaultTableModel model;

        String[] titles = {"Codigo", "Tipo de Pago"};

        String[] records = new String[2];

        model = new DefaultTableModel(null, titles);

        sqlQuery = "SELECT * FROM  PAGOS";

        try {

            Statement st = connect.createStatement();

            ResultSet rs = st.executeQuery(sqlQuery);

            while (rs.next()) {

                records[0] = rs.getString("CODIGOPAG");

                records[1] = rs.getString("TIPOPAGO");

                model.addRow(records);
            }

            return model;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

}
