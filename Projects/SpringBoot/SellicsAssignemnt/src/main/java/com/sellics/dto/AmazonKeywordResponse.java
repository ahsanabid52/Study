package com.sellics.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmazonKeywordResponse
{
    private String keyword;
    private List<String> results = new ArrayList<String>();
    private String rawResponse;


    public String getKeyword()
    {
        return keyword;
    }


    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }


    public List<String> getResults()
    {
        return results;
    }


    public void setResults(List<String> results)
    {
        this.results = results;
    }


    public String getRawResponse()
    {
        return rawResponse;
    }


    public void setRawResponse(String rawResponse)
    {
        this.rawResponse = rawResponse;
    }


    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("AmazonKeywordResponse [ keyword=");
        str.append(keyword);
        str.append(", results=");
        str.append(String.join(", ", results));
        str.append(", rawResponse=");
        str.append(rawResponse);
        str.append("]");
        
        return str.toString();

    }
}
