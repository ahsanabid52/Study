package com.sellics.service.amazon;

import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sellics.dto.AmazonKeywordResponse;
import com.sellics.dto.ResponseInfo;

@Service
public class KeywordServiceImpl implements KeywordService
{
    private static final String AMAZON_URL = "http://completion.amazon.com/search/complete?search-alias=aps&client=amazon-search-ui&mkt=1&q=";


    /* This function calls the amazon to get the results for
     * a particular keyword and then calculates the score 
     * for that keyword according to the position of the exact keyword 
     * in the results from amazon.
     * 
     * @see com.sellics.service.amazon.KeywordService#searchKeywordAndCalculateScore(java.lang.String)
     */
    @Override
    public ResponseInfo searchKeywordAndCalculateScore(@Valid String keyword)
    {
        int score = 0;
        ResponseInfo resp = null;
        AmazonKeywordResponse aResp = null;
        StringBuilder currentSearchValue = new StringBuilder();

        // Searching for every character in the keyword and calculating a score.
        char[] charArray = keyword.toCharArray();

        // This functions mimics the search function in amazon and as we type and we see results in the amazon search box
        // they results are shown and on every input of a character a new result set is shown.
        // I search for the whole keyword by starting from the first character and then adding each character and searching.
        // I will then give the score to the current search if the desired keyword appears in the result and according to its position.
        // Small position indicates the desired result was among the first ones which is a success.
        // So smaller the score the better.
        for (int i = 0; i < charArray.length; i++)
        {
            currentSearchValue.append(charArray[i]);
            aResp = callAmazonService(currentSearchValue.toString());
            if (null != aResp && null != aResp.getResults() && (!aResp.getResults().isEmpty()))
            {
                int currSearchedCharacterScore = calculateScoreByOrderInResult(keyword, aResp.getResults());
                score += currSearchedCharacterScore;
            }
        }
        
        resp = prepareResponse(keyword, score);

        return resp;
    }


    /**
     * This method calls the amazon service to get the matching results.
     * 
     * @param keyword
     * @return
     */
    private AmazonKeywordResponse callAmazonService(String keyword)
    {
        AmazonKeywordResponse response = null;
        RestTemplate restTemplate = new RestTemplate();
        try
        {
            response = getMappedObjectFromString(restTemplate.getForObject(AMAZON_URL + keyword, String.class));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }


    /**
     * This function checks if the keyword that is searched 
     * is present in the results, If so it calculates the score 
     * according to order/position in which the keyword was present.
     * 
     *  For example if the keyword is on the first position the score
     *  will be 1.
     *  For second postion the score will be 2.
     *  For third postion the score will be 3.
     *   
     * Score  =  keyword position in the results.
     * @param keyword that was searched
     * @param results results of the keyword search
     * @return
     */
    private int calculateScoreByOrderInResult(String keyword, List<String> results)
    {
        // assigning it the size of the result set in case there is no match for the keyword.
        int position = results.size();
        for (int i = 0; i < results.size(); i++)
        {
            if (results.get(i).equals(keyword))
            {
                position = i + 1;
                break;
            }
        }
        return position;
    }


    private ResponseInfo prepareResponse(String keyword, int calculateScore)
    {
        ResponseInfo resp = new ResponseInfo();
        resp.setScore(calculateScore);
        resp.setSearchedKeyword(keyword);

        return resp;
    }


    private AmazonKeywordResponse getMappedObjectFromString(String text) throws ParseException
    {

        JSONParser parser = new JSONParser(text);
        List<Object> parse = (List<Object>) parser.parse();
        AmazonKeywordResponse resp = new AmazonKeywordResponse();

        resp.setKeyword((String) parse.get(0));
        resp.setResults((List<String>) parse.get(1));

        resp.setRawResponse(text);

        return resp;

    }
}
