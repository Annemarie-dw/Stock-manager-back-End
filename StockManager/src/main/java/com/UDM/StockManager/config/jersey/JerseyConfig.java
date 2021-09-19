package com.UDM.StockManager.config.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

    @Configuration
    @ApplicationPath( "/api" )
public class JerseyConfig extends ResourceConfig {


        public JerseyConfig() {

//            register( FuneralFormResource.class );
//            register( AdminResource.class );
//            register( FormResource.class );
//            register( DeathFormResource.class );
            register( JacksonConfig.class );


//        // Error handling
            register( GenericExceptionMapper.class);
//        register(GeneralExceptionMapper.class);
//        register(ValidationExceptionMapper.class);
//        register(DuplicateKeyExceptionMapper.class);
//        register(DataIntegrityViolationExceptionMapper.class);
//        // Logging
//        register(new LoggingFeature(Logger.getLogger(getClass().getName())));
        }


}
