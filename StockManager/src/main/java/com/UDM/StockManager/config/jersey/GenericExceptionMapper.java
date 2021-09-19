package com.UDM.StockManager.config.jersey;

import javax.ws.rs.core.*;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {



        private final Logger LOGGER = Logger.getLogger( getClass().getName() );

        @Context
        private Request request;


        private Variant getVariant( Request request ) {
            if ( request == null ) return null;
            final List<Variant> variants = Variant.mediaTypes( MediaType.APPLICATION_JSON_TYPE ).build();
            final Variant variant = request.selectVariant( variants );
            return variant;
        }



        @Override
        public Response toResponse( Throwable ex ) {

            final Variant variant = getVariant( request );

            LOGGER.log( Level.SEVERE, ex.getMessage(), ex );

            Response.ResponseBuilder builder = Response.status( 500 );

            builder.type( MediaType.TEXT_PLAIN );
            Response response = builder.build();

            return response;
        }



    }
