package com.hasqvarna.todo.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDMapper implements Converter<String, UUID> {
    @Override
    public UUID convert( String uuid) {
        return UUID.fromString(uuid);
    }
}