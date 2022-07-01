package com.quranschool.coreModule.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response<T>{

    private T data;
    private String message;
    private boolean status;
    private String error;
    private List<String> parameters;
    private Date timeStamp;
    private Long code;


    public Response(T data) {
        this.status = true;
        this.data = data;
        this.timeStamp = new Date();
    }

    public Response(String error) {
        this.error = error;
        this.status = false;
        this.timeStamp = new Date();
    }

    public Response(String error, List<String> parameters) {
        this.error = error;
        this.parameters = parameters;
        this.status = false;
        this.timeStamp = new Date();
    }

    public Response(String error, String message, List< String > parameters, Long code){
        this.status = false;
        this.error = error;
        this.message = message;
        this.parameters = parameters;
        this.code = code;
        this.timeStamp = new Date();
    }

}
