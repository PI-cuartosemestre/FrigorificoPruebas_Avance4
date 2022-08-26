/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author star
 */
public class DAOcompras {
    
    
      private int CodigoCompra;

   
    private String Numero;
    private String Fecha;
 
        private String Total;

    
    private String inventario;
    private String cantidad;
    private String valor_unitario;
    private String importe;
    
     public DAOcompras() {

             }

    public DAOcompras(int CodigoCompra, String Numero, String Fecha, String Total, String inventario, String cantidad, String valor_unitario, String importe) {
        this.CodigoCompra = CodigoCompra;
        this.Numero = Numero;
        this.Fecha = Fecha;
        this.Total = Total;
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.valor_unitario = valor_unitario;
        this.importe = importe;
    }

    public int getCodigoCompra() {
        return CodigoCompra;
    }

    public void setCodigoCompra(int CodigoCompra) {
        this.CodigoCompra = CodigoCompra;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(String valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

  
     
     
}
