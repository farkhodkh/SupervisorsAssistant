package ru.haknazarovfarkhod.supervisorsassistant.DBControlers.Products;

/**
 * Created by Farhod.Haknazarov on 19.01.2018.
 */

public class Product {
    public String productName;
    public UnitOfMeasurement unitOfMeasurement;
    public int minimumQuantity;
    public String articleNumber;

    public Product(String productName, UnitOfMeasurement unitOfMeasurement, int minimumQuantity, String articleNumber) {
        this.productName = productName;
        this.unitOfMeasurement = unitOfMeasurement;
        this.minimumQuantity = minimumQuantity;
        this.articleNumber = articleNumber;
    }

    public Product() {

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

}
