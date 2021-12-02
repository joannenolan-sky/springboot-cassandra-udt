package com.example.database.config;

import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
import com.datastax.oss.driver.api.core.config.ProgrammaticDriverConfigLoaderBuilder;
import org.springframework.boot.autoconfigure.cassandra.DriverConfigLoaderBuilderCustomizer;

import java.util.Arrays;

public class CassandraDriverConfig implements DriverConfigLoaderBuilderCustomizer {

    @Override
    public void customize(ProgrammaticDriverConfigLoaderBuilder builder) {
        builder.withString(DefaultDriverOption.METRICS_ID_GENERATOR_CLASS, "TaggingMetricIdGenerator");
        builder.withString(DefaultDriverOption.METRICS_FACTORY_CLASS, "MicrometerMetricsFactory");
        builder.withStringList(DefaultDriverOption.METRICS_SESSION_ENABLED, Arrays.asList("connected-nodes", "cql-requests"));
        builder.withStringList(DefaultDriverOption.METRICS_NODE_ENABLED, Arrays.asList("cql-messages"));
        builder.withString(DefaultDriverOption.METRICS_ID_GENERATOR_PREFIX, "");

    }
}
