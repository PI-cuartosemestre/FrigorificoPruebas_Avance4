/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import model.DAOEmployee;
import java.sql.CallableStatement;
import java.sql.Connection;
import model.connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NEmployee {

    private connection mysql = new connection();
    private Connection connect = mysql.Conect();
    private String sqlQuery;
    private String preQuery;

    ///************************--MOSTRAR REGISTRO JTABLE--------------------------------------
    //BUSCAR REGISTROS
    public DefaultTableModel consult(String search) {

        DefaultTableModel model;

        String[] titles = {"Codigo", "Dni", "Tipo", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Sueldo", "Estado"};

        String[] records = new String[10];

        model = new DefaultTableModel(null, titles);

        //BUSCAR EMPLEADO
        sqlQuery = "SELECT P.COD_PERSONA, P.IDENTIFICACION, P.TIPOPERSONA, P.NOMBRE, P.APELLIDO, P.TELEFONO, P.MAIL,P.DIRECCION, E.SUELDO, E.ESTADO "
                + "FROM personas P INNER JOIN EMPLEADOS E ON E.COD_PERSONA=P.COD_PERSONA WHERE (P.NOMBRE LIKE '" + search + "%')";

        try {

            Statement st = connect.createStatement();

            ResultSet rs = st.executeQuery(sqlQuery);

            while (rs.next()) {

                //CAMPO DE LA TABLA EMPLEADO 
                records[0] = rs.getString("COD_PERSONA");

                records[1] = rs.getString("IDENTIFICACION");

                records[2] = rs.getString("TIPOPERSONA");

                records[3] = rs.getString("NOMBRE");

                records[4] = rs.getString("APELLIDO");

                records[5] = rs.getString("DIRECCION");

                records[6] = rs.getString("TELEFONO");

                records[7] = rs.getString("MAIL");

                records[8] = rs.getString("SUELDO");

                records[9] = rs.getString("ESTADO");

                model.addRow(records);
            }

            return model;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

    //INSERTAR REGISTROS
    public boolean insertPerson(DAOEmployee client) {

        sqlQuery = "INSERT INTO personas (IDENTIFICACION, TIPOPERSONA, NOMBRE, APELLIDO, TELEFONO, MAIL, DIRECCION) VALUES (?,?,?,?,?,?,?);";
        //"INSERT INTO empleados VALUES (?,?);";

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);
            //Persona
            pst.setString(1, client.getDni());
            pst.setString(2, client.getType());
            pst.setString(3, client.getName());
            pst.setString(4, client.getLastName());
            pst.setString(5, client.getPhoneNumber());
            pst.setString(6, client.getEmail());
            pst.setString(7, client.getAddress());

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

    public boolean insertEmpleado(DAOEmployee employee) {

        sqlQuery = "INSERT INTO empleados(COD_PERSONA, SUELDO, ESTADO)  VALUES (?,?,?);";

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);

            pst.setString(1, requestPrimary(employee.getDni()));
            pst.setString(2, employee.getSalary());
            pst.setString(3, employee.getState());

            //System.out.println(requestPrimary(employee.getDni()));
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

    //SOLICITAR LLAVE PRIMARIA DE PERSONA
    public String requestPrimary(String dni) {
        String primary = "";
        preQuery = "SELECT COD_PERSONA FROM personas WHERE IDENTIFICACION = ?;";
        try {

            PreparedStatement pst = connect.prepareStatement(preQuery);
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                primary = rs.getString("COD_PERSONA");

            }
            return primary;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    //EDITAR REGISTROS 
    public boolean edit(DAOEmployee employee) {

        sqlQuery = "UPDATE personas p JOIN empleados e ON e.COD_PERSONA = p.COD_PERSONA "
                + "SET p.IDENTIFICACION=?, p.TIPOPERSONA=?, p.NOMBRE=?, p.APELLIDO=?, p.DIRECCION =?,"
                + "p.TELEFONO =?, p.MAIL =?, e.SUELDO=?, e.ESTADO=? WHERE p.COD_PERSONA=?;";

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);

            pst.setString(1, employee.getDni());
            pst.setString(2, employee.getType());
            pst.setString(3, employee.getName());
            pst.setString(4, employee.getLastName());
            pst.setString(5, employee.getAddress());
            pst.setString(6, employee.getPhoneNumber());
            pst.setString(7, employee.getEmail());
            pst.setString(8, employee.getSalary());
            pst.setString(9, employee.getState());
            pst.setInt(10, employee.getClientID());

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
  //ELIMINAR REGISTROS 
    public boolean delete(DAOEmployee employee) {

        sqlQuery = "DELETE empleados FROM empleados WHERE COD_PERSONA=?;";

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);

            pst.setInt(1, employee.getClientID());

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
