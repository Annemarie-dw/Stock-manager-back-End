package com.UDM.StockManager.config.jersey;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;

@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper> {

        private final ObjectMapper mapper;

        public JacksonConfig() {
            mapper = new ObjectMapper();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            mapper.setDateFormat(df);
            //mapper.setDateFormat(new ISO8601DateFormat());
            //mapper.setSerializationInclusion(Include.NON_NULL);
            //mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

            mapper.enable( SerializationFeature.INDENT_OUTPUT );
            mapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
            mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
//        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        }

        @Override
        public ObjectMapper getContext( Class<?> type ) {
            return mapper;
        }
    }



