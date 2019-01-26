package com.sellics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sellics.service.amazon.KeywordService;

/**
 * Application controller which is a rest controller and exposes
 * a rest method through which we can search for a particular 
 * keyword.  
 * 
 * @author Ahsan Abid Hassan
 *
 */
@RestController
@RequestMapping("/api/estimate/")
public class ApplicationController
{

    @Autowired
    private KeywordService amkService;

    @RequestMapping(path = "/{keyword}", method = RequestMethod.GET)
    public ResponseEntity<?> getApplication(@PathVariable String keyword)
    {
        return ResponseEntity.status(HttpStatus.OK).body(amkService.searchKeywordAndCalculateScore(keyword));
    }
}