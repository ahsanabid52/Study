package com.sellics.dto;

public class ResponseInfo
{
    String searchedKeyword;
    int score;
  
    public ResponseInfo()
    {}


    public String getSearchedKeyword()
    {
        return searchedKeyword;
    }


    public void setSearchedKeyword(String searchedKeyword)
    {
        this.searchedKeyword = searchedKeyword;
    }


    public int getScore()
    {
        return score;
    }


    public void setScore(int score)
    {
        this.score = score;
    }

}