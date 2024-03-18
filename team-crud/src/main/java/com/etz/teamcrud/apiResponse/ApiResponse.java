package com.etz.teamcrud.apiResponse;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private String message;
    private String status;

    private T data;

    public ApiResponse(){

    }

    public static <T> ApiResponse success (T data){
        ApiResponse response =new ApiResponse();
        response.setData(data);
        response.setStatus("200");
        response.setMessage("successfully created");
        return response;
    }

    public static <T> ApiResponse disabled (T data){
        ApiResponse response =new ApiResponse();
        response.setData(data);
        response.setStatus("202");
        response.setMessage("successfully disabled");
        return response;
    }

    public static <T> ApiResponse deleted (){
        ApiResponse response =new ApiResponse();
        //response.setData(data);
        response.setStatus("404");
        response.setMessage("Not found");
        return response;
    }

    public static <T> ApiResponse deleted (T data){
        ApiResponse response =new ApiResponse();
        //response.setData(data);
        response.setStatus("404");
        response.setMessage("Not found");
        return response;
    }

    public static <T> ApiResponse noContent (){
        ApiResponse response =new ApiResponse();
        //response.setData(data);
        response.setStatus("204");
        response.setMessage("No content");
        return response;
    }

}
