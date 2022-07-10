package com.example.springservice.model;

import lombok.Data;

@Data
public class Response {

    private boolean success = true;
    private String message = null;
    private Object data = null;

}
