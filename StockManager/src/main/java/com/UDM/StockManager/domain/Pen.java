package com.UDM.StockManager.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "1" )
public class Pen extends Product {



}



