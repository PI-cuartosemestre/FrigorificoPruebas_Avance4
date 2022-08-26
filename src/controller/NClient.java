/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import model.DAOClient;
import java.sql.CallableStatement;
import java.sql.Connection;
import model.connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NClient {

    private connection mysql = new connection();
    private Connection connect = mysql.Conect();
    private String sqlQuery;
    private String preQuery;

    ///************************--MOSTRAR REGISTRO JTABLE--------------------------------------
    //BUSCAR REGISTROS
    public DefaultTableModel consult(String search) {

        DefaultTableModel model;

        String[] titles = {"Codigo", "Dni", "Tipo", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Deuda"};

        String[] records = new String[9];

        model = new DefaultTableModel(null, titles);

        //BUSCAR  CLIENTE 
        sqlQuery = "SELECT P.COD_PERSONA, P.IDENTIFICACION, P.TIPOPERSONA, P.NOMBRE, P.APELLIDO, P.TELEFONO, P.MAIL," 
        +"P.DIRECCION, C.DEUDA FROM personas P INNER JOIN clientes C WHERE (P.NOMBRE LIKE '" + search + "%')"
        +"AND (P.COD_PERSONA = C.COD_PERSONA)";

        try {

            Statement st = connect.createStatement();

            ResultSet rs = st.executeQuery(sqlQuery);

            while (rs.next()) {
                
                //CAMPO DE LA TABLA CLIENTE 
                records[0] = rs.getString("COD_PERSONA");

                records[1] = rs.getString("IDENTIFICACION");

                records[2] = rs.getString("TIPOPERSONA");

                records[3] = rs.getString("NOMBRE");

                records[4] = rs.getString("APELLIDO");

                records[5] = rs.getString("DIRECCION");

                records[6] = rs.getString("TELEFONO");
                
                records[7] = rs.getString("MAIL");
                
                records[8] = rs.getString("DEUDA");

                model.addRow(records);
            }

            return model;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

    //INSERTAR REGISTROS
    public boolean insertPerson(DAOClient client) {

        sqlQuery = "INSERT INTO personas (IDENTIFICACION, TIPOPERSONA, NOMBRE, APELLIDO, TELEFONO, MAIL, DIRECCION) VALUES (?,?,?,?,?,?,?);";
                //"INSERT INTO clientes VALUES (?,?);";

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
            //Cliente
            //pst.setString(8, requestPrimary(client.getDni()));
            // pst.setString(9, client.getDebt());
            

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
    
    public boolean insertClient(DAOClient client) {

        sqlQuery = "INSERT INTO clientes VALUES (?,?);";

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);
            
            pst.setString(1, requestPrimary(client.getDni()));
            pst.setString(2, client.getDebt());
            
            //System.out.println(requestPrimary(client.getDni()));

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
                
            }
        } catch (Exception e) {
            
            //VENTANA DE ERROR Y EXITO AL TIEMPO!!!!! PREGUNTAR !!! ANA NO TE OLVIDES!!!

            JOptionPane.showMessageDialog(null, e);        
            
            return false;

        }
        
        

    }
    
    //SOLICITAR LLAVE PRIMARIA DE CLIENTE
    public String requestPrimary(String dni){
        String primary="";
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
   public boolean edit(DAOClient client) {

        sqlQuery = "UPDATE personas p JOIN clientes c ON c.COD_PERSONA = p.COD_PERSONA "
                + "SET p.IDENTIFICACION=?, p.TIPOPERSONA=?, p.NOMBRE=?, p.APELLIDO=?, p.DIRECCION =?,"
                + "p.TELEFONO =?, p.MAIL =?, c.DEUDA =? WHERE p.COD_PERSONA=?;";
        
        //System.out.println(sqlQuery);

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);

            pst.setString(1, client.getDni());
            pst.setString(2, client.getType());
            pst.setString(3, client.getName());
            pst.setString(4, client.getLastName());
            pst.setString(5, client.getAddress());
            pst.setString(6, client.getPhoneNumber());
            pst.setString(7, client.getEmail());
            pst.setString(8, client.getDebt());
            pst.setInt(9, client.getClientID());

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
    public boolean delete(DAOClient client) {

        sqlQuery = "DELETE clientes FROM clientes WHERE COD_PERSONA=?;";

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);

            pst.setInt(1, client.getClientID());

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
