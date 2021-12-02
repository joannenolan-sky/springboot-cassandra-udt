package com.example.database.model;

import com.datastax.oss.driver.api.core.data.UdtValue;
import com.datastax.oss.driver.api.core.type.UserDefinedType;
import com.datastax.oss.driver.api.core.type.codec.MappingCodec;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.api.core.type.reflect.GenericType;
import edu.umd.cs.findbugs.annotations.Nullable;
import org.springframework.lang.NonNull;

public class InfoCodec extends MappingCodec<UdtValue, Info> {
    public InfoCodec(@NonNull TypeCodec<UdtValue> innerCodec) {
        super(innerCodec, GenericType.of(Info.class));
    }

    @NonNull
    @Override
    public UserDefinedType getCqlType() {
        return (UserDefinedType) super.getCqlType();
    }

    @Nullable
    @Override
    protected Info innerToOuter(@Nullable UdtValue value) {
        return value == null
                ? null
                : new Info(
                value.getString("field1"),
                value.getSet("fieldSet", String.class));
    }

    @Nullable
    @Override
    protected UdtValue outerToInner(@Nullable Info value) {
        return value == null
                ? null
                : getCqlType()
                .newValue()
                .setString("field1", value.getField1())
                .setSet("fieldSet", value.getFieldSet(), String.class);
    }

}
