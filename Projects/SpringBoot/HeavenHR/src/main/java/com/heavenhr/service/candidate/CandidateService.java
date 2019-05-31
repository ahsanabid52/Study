package com.heavenhr.service.candidate;

import javax.validation.Valid;

import com.heavenhr.model.Candidate;

public interface CandidateService
{

    Candidate getById(Long id);

    @Valid
    Candidate saveCandidate(@Valid Candidate candidate);

}
