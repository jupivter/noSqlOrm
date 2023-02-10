package com.nosqlorm.nosqlorm;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoDBCredentials extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "developer";
    }

    @Override
    public MongoClient mongoClient () {
        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://developer:passwordhere@cluster0.c0xh7fy.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings mcs = MongoClientSettings
                .builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mcs);
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.example.nosqlorm");
    }
}
