/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.connection;
import model.DAOUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NUser {

    private connection mysql = new connection();
    private Connection connect = mysql.Conect();
    private String sqlQuery;

    //CONSULTA LOGIN 
    public boolean login(DAOUser user) {
        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            //CONSULTA USUARIO 
            sqlQuery = "SELECT NOMBREUSU, cast(AES_DECRYPT(CLAVE, 'key') AS char) AS CLAVE, TIPOUSUARIO FROM usuarios where NOMBREUSU=?";
            ps = connect.prepareStatement(sqlQuery);

            ps.setString(1, user.getUser());

            rs = ps.executeQuery();

            if (rs.next()) {
                if (user.getPass().equals(rs.getString(2))) {
                    user.setCharge(rs.getString(3));

                    return true;

                } else {

                    return false;
                }

            }

            return false;

        } catch (SQLException ex) {

            System.err.println(ex.toString());

            return false;

        }

    }

}
