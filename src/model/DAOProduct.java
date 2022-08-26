/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/*
 * @author Reyna Luis, Trujillo Ronald, Guzman Sebastian, Cruz Danna, Gutierrez Ana
 */
public class DAOProduct {

    private int productID;
    private String productCode;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
    private String name;
    private String categoryCode;
    private String description;
    private String stock;
    private String price;
    private String ivaPrice;
    private String providerCode;
    private String state;

    public DAOProduct() {

    }

    public DAOProduct(int productID, String productCode, String name, String categoryCode, String description, String stock, String price, String ivaPrice, String provider, String state) {
        this.productID = productID;
        this.productCode = productCode;
        this.name = name;
        this.categoryCode = categoryCode;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.ivaPrice = ivaPrice;
        this.providerCode = provider;
        this.state = state;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIvaPrice() {
        return ivaPrice;
    }

    public void setIvaPrice(String ivaPrice) {
        this.ivaPrice = ivaPrice;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    
    

}
