/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
 * @author Reyna Luis, Trujillo Ronald, Guzman Sebastian, Cruz Danna, Gutierrez Ana
 */

public class connection {

    /*CREAR VARIABLES Y RUTA*/
    private final String DB="de_la_vega_steak_house";
    private final String URL="jdbc:mysql://localhost:33065/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER="root";
    private final String PASS="";

    /* CLASE CONECCION A MYSQL POR EL DRIVER */
    public Connection Conect() {

        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");

            link = DriverManager.getConnection(URL, USER, PASS);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        }
        return link;
    }

}
