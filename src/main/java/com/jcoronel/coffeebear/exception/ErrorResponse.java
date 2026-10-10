package com.jcoronel.coffeebear.exception;

import java.util.Map;

//Record mejor para evitar getters and setters
public record ErrorResponse(Map<String,String> error) {
}
