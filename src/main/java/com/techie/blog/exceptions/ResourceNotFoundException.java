package com.techie.blog.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Supplier;

@NoArgsConstructor
@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    int fieldValue;
    public ResourceNotFoundException(String resourceName,String fieldName,int fieldValue){
        super(String.format("%s not found with %s:%l",resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
