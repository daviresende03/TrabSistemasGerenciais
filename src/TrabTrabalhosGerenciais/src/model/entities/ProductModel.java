/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import model.enums.ProductTypeEnum;

/**
 *
 * @author Davi
 */
public class ProductModel extends BaseModel{
    private String name;
    private ProductTypeEnum type;
    private UnitModel unit;
    private double costPrice;
    private double salePrice;
    private double stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductTypeEnum getType() {
        return type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
    }

    public UnitModel getUnit() {
        return unit;
    }

    public void setUnit(UnitModel unit) {
        this.unit = unit;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
    
    
}
