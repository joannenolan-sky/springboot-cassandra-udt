package com.example.database.config;

import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.internal.core.type.codec.registry.DefaultCodecRegistry;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;

public class CassandraSessionConfig implements CqlSessionBuilderCustomizer {

    private static final Logger logger = LoggerFactory.getLogger(CassandraSessionConfig.class);

    final MeterRegistry meterRegistry;

    public CassandraSessionConfig(MeterRegistry meterRegistry) {
        logger.info("cassandra configuration bean instantiated");
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void customize(CqlSessionBuilder cqlSessionBuilder) {
        cqlSessionBuilder.withMetricRegistry(meterRegistry)
                .withCodecRegistry(new DefaultCodecRegistry("default"));

    }
}