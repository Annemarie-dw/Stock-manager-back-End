package com.UDM.StockManager.resource;

import com.UDM.StockManager.domain.Product;
import com.UDM.StockManager.service.StockService;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path( "/stock" )
public class StockResource {

    private StockService stockService;

    @POST
    @Path( "/add" )
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Product add( Product product ) {

        Product newProduct = stockService.add( product );
        return newProduct;


    }



}
