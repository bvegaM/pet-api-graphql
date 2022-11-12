package com.bvega.petapigraphql.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLScalarType graphQLScalarDate(){
        return ExtendedScalars.Date;
    }

    @Bean
    public GraphQLScalarType graphQLScalarTypeLong(){
        return ExtendedScalars.GraphQLLong;
    }

}
