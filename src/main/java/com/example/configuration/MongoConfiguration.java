package com.example.configuration;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:mongo.properties")
public class MongoConfiguration {
    private final Environment environment;

    @Autowired
    public MongoConfiguration(final Environment environment) {
        this.environment = environment;
    }

    @Primary
    @Bean(name = "MongoTemplate")
    MongoTemplate getMongoTemplate() {
        String userName = this.environment.getProperty("mongo.username");
        String password = this.environment.getProperty("mongo.password");
        String database = this.environment.getProperty("mongo.database");
        String host = this.environment.getProperty("mongo.host");
        int port = Integer.parseInt(this.environment.getProperty("mongo.port"));
        List<MongoCredential> mongoCredentialList = new ArrayList<>(1);
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(
                userName,
                database,
                password.toCharArray());
        mongoCredentialList.add(mongoCredential);
        List<ServerAddress> serverAddressList = new ArrayList<>();
        serverAddressList.add(new ServerAddress(host, port));
        MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder()
                .threadsAllowedToBlockForConnectionMultiplier(5)
                .maxConnectionIdleTime(60000)
                .connectionsPerHost(10)
                .minConnectionsPerHost(5)
                .maxWaitTime(120000)
                .connectTimeout(10000)
                .socketTimeout(0)
                .socketKeepAlive(false)
                .readPreference(ReadPreference.secondaryPreferred())
                .build();
        MongoClient mongoClient =
                new MongoClient(
                        serverAddressList,
                        mongoCredentialList,
                        mongoClientOptions);
        MongoDbFactory mongoDbFactory =
                new SimpleMongoDbFactory(mongoClient, database);
        DbRefResolver dbRefResolver =
                new DefaultDbRefResolver(mongoDbFactory);
        MappingMongoConverter mappingMongoConverter =
                new MappingMongoConverter(
                        dbRefResolver, new MongoMappingContext());
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate mongoTemplate =
                new MongoTemplate(mongoDbFactory, mappingMongoConverter);
        mongoTemplate.setReadPreference(ReadPreference.secondaryPreferred());
        return mongoTemplate;
    }
}
