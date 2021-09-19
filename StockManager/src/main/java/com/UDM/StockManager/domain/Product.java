package com.UDM.StockManager.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name = "product_type",
discriminatorType = DiscriminatorType.INTEGER)
public abstract class Product implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @Column( nullable = false, unique = true )
    private String name;
    @Column( nullable = false )
    private int quantity;
    @Column( nullable = false )
    private double price;
    @Column( nullable = false, unique = true )
    protected ProductCode productCode;

    public ProductCode getProductCode() {
        return productCode;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice( double price ) {
        this.price = price;
    }

}
