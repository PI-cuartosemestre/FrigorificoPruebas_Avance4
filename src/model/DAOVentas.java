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
public class DAOVentas {
    
    
      private int CodigoVenta;

    public DAOVentas(int CodigoVenta, String Numero, String Fecha, String SubTotal, String Iva, String Total, String Pago, String inventario, String cantidad, String valor_unitario, String importe) {
        this.CodigoVenta = CodigoVenta;
        this.Numero = Numero;
        this.Fecha = Fecha;
        this.SubTotal = SubTotal;
        this.Iva = Iva;
        this.Total = Total;
        this.Pago = Pago;
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.valor_unitario = valor_unitario;
        this.importe = importe;
    }
    private String Numero;
    private String Fecha;
        private String SubTotal;
    private String Iva;
        private String Total;
    private String Pago;
    
    private String inventario;
    private String cantidad;
    private String valor_unitario;
    private String importe;
    
     public DAOVentas() {

             }

    public int getCodigoVenta() {
        return CodigoVenta;
    }

    public void setCodigoVenta(int CodigoVenta) {
        this.CodigoVenta = CodigoVenta;
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

    public String getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(String SubTotal) {
        this.SubTotal = SubTotal;
    }

    public String getIva() {
        return Iva;
    }

    public void setIva(String Iva) {
        this.Iva = Iva;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getPago() {
        return Pago;
    }

    public void setPago(String Pago) {
        this.Pago = Pago;
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
