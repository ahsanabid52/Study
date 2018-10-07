package com.mytaxi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO
{
    private String responeCode;
    private String responseDescription;


    public String getResponeCode()
    {
        return responeCode;
    }


    public void setResponeCode(String responeCode)
    {
        this.responeCode = responeCode;
    }


    public String getResponseDescription()
    {
        return responseDescription;
    }


    public void setResponseDescription(String responseDescription)
    {
        this.responseDescription = responseDescription;
    }
}
