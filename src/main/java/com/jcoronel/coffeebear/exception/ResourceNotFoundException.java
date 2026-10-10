package com.jcoronel.coffeebear.exception;

public class ResourceNotFoundException extends RuntimeException {
  String resourceName;

  public ResourceNotFoundException(String message) {
    super("resource " + message + " not found");
    resourceName = message;
  }

  public String getResourceName() {
    return resourceName;
  }
}
