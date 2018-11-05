package com.heavenhr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heavenhr.exception.CandidateExistsException;
import com.heavenhr.model.Candidate;
import com.heavenhr.service.candidate.CandidateService;

/**
 * All operations with a candidate will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("/api/candidate/")
public class CandidateController
{
    @Autowired
    private CandidateService candidateService;


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCandidate(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(candidateService.getById(id));
    }
    

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @Valid ResponseEntity<?> saveCandidate(@Valid @RequestBody Candidate candidate) throws CandidateExistsException
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.saveCandidate(candidate));
    }
}
