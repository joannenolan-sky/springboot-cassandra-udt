package com.example.database.spring;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.data.UdtValue;
import com.datastax.oss.driver.api.core.type.UserDefinedType;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.api.core.type.codec.registry.CodecRegistry;
import com.datastax.oss.driver.api.core.type.codec.registry.MutableCodecRegistry;
import com.example.database.config.CassandraDriverConfig;
import com.example.database.model.InfoCodec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = {"com.example.database.repository"})
public class CassandraSpringModule {
    @Bean
    CassandraDriverConfig cassandraDriverConfig() {
        return new CassandraDriverConfig();
    }

    @Bean
    UserDefinedType udt(CqlSession session) {
        CodecRegistry codecRegistry = session.getContext().getCodecRegistry();
        UserDefinedType info = session
                .getMetadata()
                .getKeyspace(session.getKeyspace().orElseThrow())
                .flatMap(ks -> ks.getUserDefinedType("info"))
                .orElseThrow(IllegalStateException::new);

        TypeCodec<UdtValue> innerCodec = codecRegistry.codecFor(info);
        InfoCodec infoCodec = new InfoCodec(innerCodec);

        ((MutableCodecRegistry) codecRegistry).register(infoCodec);
        return info;
    }

}
