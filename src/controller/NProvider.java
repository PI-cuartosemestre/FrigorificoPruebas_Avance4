/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import model.DAOProvider;
import java.sql.CallableStatement;
import java.sql.Connection;
import model.connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NProvider {

    private connection mysql = new connection();
    private Connection connect = mysql.Conect();
    private String sqlQuery;
    private String preQuery;

    ///************************--MOSTRAR REGISTRO JTABLE--------------------------------------
    //BUSCAR REGISTROS
    public DefaultTableModel consult(String search) {

        DefaultTableModel model;

        String[] titles = {"Codigo de Proveedor", "Tipo", "Nombre", "Apellidos", "Telefono", "Email", "Direccion", "Estado", "DNI", "IDPRO", "IDP"};

        String[] records = new String[11];

        model = new DefaultTableModel(null, titles);
      
        sqlQuery = "SELECT pro.CODIGOPROV, p.TIPOPERSONA, p.NOMBRE, p.APELLIDO, p.TELEFONO, p.MAIL, p.DIRECCION, "
                + "pro.ESTADO, p.IDENTIFICACION, pro.ID_PROVEEDOR, p.COD_PERSONA "
                + "FROM personas p INNER JOIN proveedores pro ON p.COD_PERSONA = pro.COD_PERSONA "
                + "WHERE (p.NOMBRE LIKE '" + search + "%');";

        try {

            Statement st = connect.createStatement();

            ResultSet rs = st.executeQuery(sqlQuery);

            while (rs.next()) {
                
                //CAMPO DE LA TABLA CLIENTE 
                records[0] = rs.getString("CODIGOPROV");

                records[1] = rs.getString("TIPOPERSONA");

                records[2] = rs.getString("NOMBRE");

                records[3] = rs.getString("APELLIDO");

                records[4] = rs.getString("TELEFONO");

                records[5] = rs.getString("MAIL");

                records[6] = rs.getString("DIRECCION");
                
                records[7] = rs.getString("ESTADO");
                
                records[8] = rs.getString("IDENTIFICACION");
                
                records[9] = rs.getString("ID_PROVEEDOR");
                
                records[10] = rs.getString("COD_PERSONA");

                model.addRow(records);
            }

            return model;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            return null;
        }
    }

    //INSERTAR REGISTROS
    public boolean insertPerson(DAOProvider provider) {

        sqlQuery = "INSERT INTO personas (IDENTIFICACION, TIPOPERSONA, NOMBRE, APELLIDO, TELEFONO, MAIL, DIRECCION) VALUES (?,?,?,?,?,?,?);";
                //"INSERT INTO clientes VALUES (?,?);";

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);
            //Persona
            pst.setString(1, provider.getDni());
            pst.setString(2, provider.getType());
            pst.setString(3, provider.getName());
            pst.setString(4, provider.getLastName());
            pst.setString(5, provider.getPhoneNumber());
            pst.setString(6, provider.getEmail());
            pst.setString(7, provider.getAddress());
            //Cliente
            //pst.setString(8, requestPrimary(provider.getDni()));
            // pst.setString(9, provider.getDebt());
            

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
    

    public boolean insertProvider(DAOProvider provider) {

        sqlQuery = "INSERT INTO proveedores(CODIGOPROV, COD_PERSONA, ESTADO) VALUES (?,?,?);";

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);
            
            pst.setString(1, provider.getProviderCode());
            pst.setString(2, requestPrimary(provider.getDni()));
            pst.setString(3, provider.getState());
            
            //System.out.println(requestPrimary(provider.getDni()));

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
    public boolean editProvider(DAOProvider provider) {

        sqlQuery = "UPDATE personas p JOIN proveedores pro ON p.COD_PERSONA = pro.COD_PERSONA SET p.IDENTIFICACION = ?, "
                + "p.TIPOPERSONA = ?, p.NOMBRE = ?, p.APELLIDO = ?, p.TELEFONO = ?, p.MAIL = ?, p.DIRECCION = ?, "
                + "pro.CODIGOPROV = ?, pro.ESTADO = ? WHERE p.COD_PERSONA = ?; ";
       
        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);

            pst.setString(1, provider.getDni());
            pst.setString(2, provider.getType());
            pst.setString(3, provider.getName());
            pst.setString(4, provider.getLastName());
            pst.setString(5, provider.getPhoneNumber());
            pst.setString(6, provider.getEmail());
            pst.setString(7, provider.getAddress());
            pst.setString(8, provider.getProviderCode());
            pst.setString(9, provider.getState());            
            pst.setInt(10, provider.getPersonID()); 

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
    
        public boolean deleteProvider(DAOProvider provider) {

        sqlQuery = "DELETE proveedores FROM proveedores WHERE ID_PROVEEDOR = ?;";

        try {

            PreparedStatement pst = connect.prepareStatement(sqlQuery);

            pst.setInt(1, provider.getProviderID());

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
