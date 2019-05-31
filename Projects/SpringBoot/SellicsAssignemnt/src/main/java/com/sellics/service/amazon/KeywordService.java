package com.sellics.service.amazon;

import javax.validation.Valid;

import com.sellics.dto.ResponseInfo;

/**
 * Keyword Service interface which is used to interact with amazon 
 * and get suggestions from amazon for a particular keyword. 
 * 
 * @author Ahsan Abid Hassan
 *
 */
public interface KeywordService
{

    ResponseInfo searchKeywordAndCalculateScore(@Valid String keyword);

}