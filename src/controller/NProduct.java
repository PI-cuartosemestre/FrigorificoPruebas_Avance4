/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import model.DAOProduct;
import java.sql.CallableStatement;
import java.sql.Connection;
import model.connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NProduct {

    private connection mysql = new connection();
    private Connection connect = mysql.Conect();
    private String sql;

    ///************************--MOSTRAR REGISTRO JTABLE--------------------------------------
    //BUSCAR REGISTROS 
    public DefaultTableModel consult(String search) {

        DefaultTableModel model;

        String[] titles = {"Código", "Producto", "Descripción", "Precio", "Precio Venta con Iva", "Stock", "Categoria", "Código Proveedor", "Proveedor",
            "Estado", "Codigo Categoria", "IDI", "IDP","Precio Compra"};

        String[] records = new String[14];

        model = new DefaultTableModel(null, titles);

        //BUSCAR
        sql = "SELECT i.CODIGOINV, i.NOMBRE_PRO, i.DESCRIPCION, i.PRECIO, (i.PRECIO * iva.VALORIVA) AS PRECIO_CON_IVA, i.CANTIDAD, "
                + "c.NOMBRE_CAT , p.CODIGOPROV, pe.NOMBRE, (SELECT CASE WHEN (i.CANTIDAD < 0.1) THEN 'AGOTADO' ELSE 'EN STOCK' END) AS ESTADO, "
                + "c.CODIGOCAT, i.ID_INVENTARIO, p.ID_PROVEEDOR, i.PRECIO_COMPRA FROM inventario i "
                + "INNER JOIN categorias c ON c.CODIGOCAT = i.CODIGOCAT "
                + "INNER JOIN proveedores p ON p.ID_PROVEEDOR = i.ID_PROVEEDOR "
                + "INNER JOIN personas pe ON p.COD_PERSONA = pe.COD_PERSONA "
                + "INNER JOIN iva ON iva.ID_IVA = 1 "
                + "WHERE i.NOMBRE_PRO LIKE '" + search + "%';";

        try {

            Statement st = connect.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                records[0] = rs.getString("CODIGOINV");

                records[1] = rs.getString("NOMBRE_PRO");

                records[2] = rs.getString("DESCRIPCION");

                records[3] = rs.getString("PRECIO");

                records[4] = rs.getString("PRECIO_CON_IVA");

                records[5] = rs.getString("CANTIDAD");

                records[6] = rs.getString("NOMBRE_CAT");

                records[7] = rs.getString("CODIGOPROV");

                records[8] = rs.getString("NOMBRE");

                records[9] = rs.getString("ESTADO");

                records[10] = rs.getString("CODIGOCAT");

                records[11] = rs.getString("ID_INVENTARIO");

                records[12] = rs.getString("ID_PROVEEDOR");
                
                records[13] = rs.getString("PRECIO_COMPRA");

                model.addRow(records);
            }

            return model;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            return null;

        }

    }

    public DefaultTableModel consultCategory(String search) {

        DefaultTableModel model;

        String[] titles = {"Codigo", "Categoria"};

        String[] records = new String[2];

        model = new DefaultTableModel(null, titles);

        //Buscar categoria
        sql = "SELECT * FROM categorias WHERE NOMBRE_CAT LIKE '" + search + "%'";
        try {

            Statement st = connect.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                records[0] = rs.getString("CODIGOCAT");

                records[1] = rs.getString("NOMBRE_CAT");

                model.addRow(records);
            }

            return model;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            return null;

        }

    }

    public String consultIva() {
        String iva = "";
        sql = "SELECT VALORIVA FROM iva WHERE ID_IVA = 1;";
        try {

            PreparedStatement pst = connect.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                iva = rs.getString("VALORIVA");

            }
            return iva;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean insertCategory(String nombreCategoria) {

        sql = "INSERT INTO categorias (NOMBRE_CAT) VALUES (?);";

        try {
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, nombreCategoria);
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

    //INSERTAR REGISTROS 
    public boolean insert(DAOProduct product) {

        sql = "INSERT INTO inventario (CODIGOINV, NOMBRE_PRO, CODIGOCAT, DESCRIPCION, CANTIDAD, PRECIO, ID_PROVEEDOR) values (?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, product.getProductCode());
            pst.setString(2, product.getName());
            pst.setString(3, product.getCategoryCode());
            pst.setString(4, product.getDescription());
            pst.setString(5, product.getStock());
            pst.setString(6, product.getPrice());
            pst.setString(7, product.getProviderCode());

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

    //actualizar REGISTROS
    public boolean edit(DAOProduct product) {

        sql = "UPDATE inventario SET CODIGOINV = ?, NOMBRE_PRO = ?, CODIGOCAT = ?, DESCRIPCION = ?, CANTIDAD = ?, PRECIO = ?, ID_PROVEEDOR = ? WHERE ID_INVENTARIO = ?;";

        try {

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, product.getProductCode());

            pst.setString(2, product.getName());

            pst.setString(3, product.getCategoryCode());

            pst.setString(4, product.getDescription());

            pst.setString(5, product.getStock());

            pst.setString(6, product.getPrice());

            pst.setString(7, product.getProviderCode());

            pst.setInt(8, product.getProductID());

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

    //Eliminar REGISTROS
    public boolean delete(DAOProduct product) {

        sql = "DELETE FROM inventario WHERE ID_INVENTARIO = ?;";

        try {

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setInt(1, product.getProductID());

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

}
