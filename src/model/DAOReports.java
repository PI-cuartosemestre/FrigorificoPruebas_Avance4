/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.ViewPrincipalMenu;


public class DAOReports {

    public DAOReports() {
    }
    
    public void reporteProductos () {                                             
    
        
        Document documento = new Document();
        Image imagen = null;
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes/Reporte_productos.pdf"));
            
            Paragraph p = new Paragraph();
            documento.open();
            String imageUrl = "src/Images/imgBlackLogo.png";
            try {
                imagen = Image.getInstance("src/Images/imgBlackLogo.png");
            } catch (BadElementException ex) {
                Logger.getLogger(ViewPrincipalMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewPrincipalMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

            p.setAlignment(Element.ALIGN_CENTER);
            p.add(imagen);

            p.add("REPORTE DE PRODUCTOS - DE LA VEGA STEAK HOUSE");

            documento.add(p);
            documento.add(Chunk.NEWLINE);
            //Aqui se crea la tabla hay que poner la cantidad de columnas
            PdfPTable tabla = new PdfPTable(8);

            tabla.addCell("CODIGO INVENTARIO");
            tabla.addCell("NOMBRE PRODUCTO");
            tabla.addCell("DESCRIPCIÓN");
            tabla.addCell("PRECIO SIN IVA");
            tabla.addCell("PRECIO CON IVA");
            tabla.addCell("CANTIDAD");
            tabla.addCell("NOMBRE CATEGORIA");
            tabla.addCell("CODIGO PROVEEDOR ");
            try {
                //Conexion conexion = new Conexion();
                connection mysql = new connection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                Connection conn = mysql.Conect();
                
                //AQUI VAN LAS CONSULTAS
                String sql = "SELECT i.CODIGOINV, i.NOMBRE_PRO, i.DESCRIPCION, i.PRECIO AS PRECIO_SIN_IVA , (i.PRECIO * iva.VALORIVA) AS PRECIO_CON_IVA, i.CANTIDAD, c.NOMBRE_CAT, p.CODIGOPROV FROM inventario i INNER JOIN categorias c ON c.CODIGOCAT=i.CODIGOCAT INNER JOIN proveedores p ON p.ID_PROVEEDOR=i.ID_PROVEEDOR INNER JOIN iva ON iva.ID_IVA = 1 WHERE (i.CANTIDAD>0.0);";
                ps = conn.prepareStatement(sql);
                
                //System.out.println(sql + "" + personasmodelo.getCedula());
                rs = ps.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            
            Paragraph parrafo = new Paragraph();
            
            documento.add(Chunk.NEWLINE);
            parrafo.add("REPORTE DE PRODUCTOS AGOTADOS  - DE LA VEGA STEAK HOUSE");
            parrafo.setAlignment(Element.ALIGN_CENTER);
            
            documento.add(parrafo);
            documento.add(Chunk.NEWLINE);

            PdfPTable tabla_agotados = new PdfPTable(8);

            tabla_agotados.addCell("CODIGO INVENTARIO");
            tabla_agotados.addCell("NOMBRE_PRODUCTO");
            tabla_agotados.addCell("DESCRIPCIÓN");
            tabla_agotados.addCell("PRECIO SIN IVA");
            tabla_agotados.addCell("PRECIO CON IVA");
            tabla_agotados.addCell("CANTIDAD");
            tabla_agotados.addCell("NOMBRE CATEGORIA");
            tabla_agotados.addCell("CODIGOPROVEEDOR");
            try {
                //Conexion conexion = new Conexion();
                connection mysql = new connection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                Connection conn = mysql.Conect();
                
                
                //AQUI VAN LAS CONSULTAS
                String sql = "SELECT i.CODIGOINV, i.NOMBRE_PRO, i.DESCRIPCION, i.PRECIO AS PRECIO_SIN_IVA , (i.PRECIO * iva.VALORIVA) AS PRECIO_CON_IVA, i.CANTIDAD, c.NOMBRE_CAT, p.CODIGOPROV FROM inventario i INNER JOIN categorias c ON c.CODIGOCAT=i.CODIGOCAT INNER JOIN proveedores p ON p.ID_PROVEEDOR=i.ID_PROVEEDOR INNER JOIN iva ON iva.ID_IVA = 1 WHERE (i.CANTIDAD=0.0);";
                ps = conn.prepareStatement(sql);
                
                //System.out.println(sql + "" + personasmodelo.getCedula());
                rs = ps.executeQuery();

                if (rs.next()) {

                    do {
                        tabla_agotados.addCell(rs.getString(1));
                        tabla_agotados.addCell(rs.getString(2));
                        tabla_agotados.addCell(rs.getString(3));
                        tabla_agotados.addCell(rs.getString(4));
                        tabla_agotados.addCell(rs.getString(5));
                        tabla_agotados.addCell(rs.getString(6));
                        tabla_agotados.addCell(rs.getString(7));
                        tabla_agotados.addCell(rs.getString(8));
                    } while (rs.next());
                    documento.add(tabla_agotados);
                }

            } catch (DocumentException | SQLException e) {
            }
            
          
            
            documento.close();
            
          //abrirarchivo(ruta + "/Desktop/Reportes/Reporte_productos .pdf");
             abrirarchivo(ruta + "/Desktop/Reportes/Reporte_productos.pdf");
            JOptionPane.showMessageDialog(null, "Reporte creado. Se abrirá automáticamente");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void reporteClientes () {                                             
    
        
        Document documento = new Document();
        Image imagen = null;
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes/Reporte_clientes.pdf"));
           
            Paragraph p = new Paragraph();
            documento.open();
            String imageUrl = "src/Images/imgBlackLogo.png";
            try {
                imagen = Image.getInstance("src/Images/imgBlackLogo.png");
            } catch (BadElementException ex) {
                Logger.getLogger(ViewPrincipalMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewPrincipalMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

            p.setAlignment(Element.ALIGN_CENTER);
            p.add(imagen);

            p.add("REPORTE DE CLIENTES - DE LA VEGA STEAK HOUSE");

            documento.add(p);
            documento.add(Chunk.NEWLINE);
            //Aqui se crea la tabla hay que poner la cantidad de columnas
            PdfPTable tabla = new PdfPTable(8);

            tabla.addCell("Identificacion");
            tabla.addCell("Tipo Persona");
            tabla.addCell("Nombre");
            tabla.addCell("Apellido");
            tabla.addCell("Telefono");
            tabla.addCell("Mail");
            tabla.addCell("Direccion");
            tabla.addCell("Deuda");
            try {
                //Conexion conexion = new Conexion();
                connection mysql = new connection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                Connection conn = mysql.Conect();
                
                //AQUI VAN LAS CONSULTAS
                String sql = "SELECT P.IDENTIFICACION, P.TIPOPERSONA, P.NOMBRE, P.APELLIDO, P.TELEFONO, P.MAIL,P.DIRECCION, C.DEUDA FROM personas P INNER JOIN clientes C WHERE (P.COD_PERSONA = C.COD_PERSONA);";
                ps = conn.prepareStatement(sql);
                
                //System.out.println(sql + "" + personasmodelo.getCedula());
                rs = ps.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            
          //abrirarchivo(ruta + "/Desktop/Reportes/Reporte_clientes.pdf");
          abrirarchivo(ruta + "/Desktop/Reportes/Reporte_clientes.pdf");
            
            JOptionPane.showMessageDialog(null, "Reporte creado. Se abrirá automáticamente");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
        
    }
    
    
       public void reporteProveedor() {                                             
    
        
        Document documento = new Document();
        Image imagen = null;
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes/Reporte_proveedor.pdf"));
           
            Paragraph p = new Paragraph();
            documento.open();
            String imageUrl = "src/Images/imgBlackLogo.png";
            try {
                imagen = Image.getInstance("src/Images/imgBlackLogo.png");
            } catch (BadElementException ex) {
                Logger.getLogger(ViewPrincipalMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewPrincipalMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

            p.setAlignment(Element.ALIGN_CENTER);
            p.add(imagen);

            p.add("REPORTE DE PROVEEDORES  - DE LA VEGA STEAK HOUSE");

            documento.add(p);
            documento.add(Chunk.NEWLINE);
            //Aqui se crea la tabla hay que poner la cantidad de columnas
            PdfPTable tabla = new PdfPTable(9);

            tabla.addCell("Codigo Proveedor");
            tabla.addCell("Tipo Persona");
            tabla.addCell("Nombre");
            tabla.addCell("Apellido");
            tabla.addCell("Telefono");
            tabla.addCell("Mail");
            tabla.addCell("Direccion");
            tabla.addCell("Estado Provedor");
            tabla.addCell("Identificacion");
            try {
                //Conexion conexion = new Conexion();
                connection mysql = new connection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                Connection conn = mysql.Conect();
                
                //AQUI VAN LAS CONSULTAS
                String sql = "SELECT prov.CODIGOPROV, person.TIPOPERSONA, person.NOMBRE, person.APELLIDO, person.TELEFONO, person.MAIL, person.DIRECCION, (SELECT CASE WHEN (prov.ESTADO=1) THEN 'VIGENTE' ELSE 'NO VIGENTE' END) AS ESTADO_PROVEEDOR, person.IDENTIFICACION FROM personas person INNER JOIN proveedores prov ON person.COD_PERSONA = prov.COD_PERSONA;";
                ps = conn.prepareStatement(sql);
                
                //System.out.println(sql + "" + personasmodelo.getCedula());
                rs = ps.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                        tabla.addCell(rs.getString(9));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            
          //abrirarchivo(ruta + "/Desktop/Reportes/Reporte_proveedor.pdf");
          abrirarchivo(ruta + "/Desktop/Reportes/Reporte_proveedor.pdf");
            
            JOptionPane.showMessageDialog(null, "Reporte creado. Se abrirá automáticamente");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
        
    }
       
       
       
        public void reporteVentas() {                                             
    
        
        Document documento = new Document();
        Image imagen = null;
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes/Reporte_ventas.pdf"));
           
            Paragraph p = new Paragraph();
            documento.open();
            String imageUrl = "src/Images/imgBlackLogo.png";
            try {
                imagen = Image.getInstance("src/Images/imgBlackLogo.png");
            } catch (BadElementException ex) {
                Logger.getLogger(ViewPrincipalMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewPrincipalMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

            p.setAlignment(Element.ALIGN_CENTER);
            p.add(imagen);

            p.add("REPORTE DE VENTAS  - DE LA VEGA STEAK HOUSE");

            documento.add(p);
            documento.add(Chunk.NEWLINE);
            //Aqui se crea la tabla hay que poner la cantidad de columnas
            PdfPTable tabla = new PdfPTable(7);

            tabla.addCell("Codigo Venta");
            tabla.addCell("Identificacion");
            tabla.addCell("Nombre");
            tabla.addCell("Apellido");
            tabla.addCell("Fecha");
            tabla.addCell("Total");
            tabla.addCell("Tipo Pago");
            
            try {
                //Conexion conexion = new Conexion();
                connection mysql = new connection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                Connection conn = mysql.Conect();
                
                //AQUI VAN LAS CONSULTAS
                String sql = "SELECT v.CODIGOVENTA, person.IDENTIFICACION,person.NOMBRE,person.APELLIDO, v.FECHA, v.TOTAL, p.TIPOPAGO FROM venta v INNER JOIN pagos p ON p.CODIGOPAG=v.CODIGOPAG INNER JOIN personas person ON person.COD_PERSONA=v.COD_PERSONA;";
                ps = conn.prepareStatement(sql);
                
                //System.out.println(sql + "" + personasmodelo.getCedula());
                rs = ps.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                       
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            
          //abrirarchivo(ruta + "/Desktop/Reportes/Reporte_ventas.pdf");
          abrirarchivo(ruta + "/Desktop/Reportes/Reporte_ventas.pdf");
            
            JOptionPane.showMessageDialog(null, "Reporte creado. Se abrirá automáticamente");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
        
    }
       
    
    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
