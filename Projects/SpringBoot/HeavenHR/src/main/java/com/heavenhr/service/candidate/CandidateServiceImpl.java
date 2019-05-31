package com.heavenhr.service.candidate;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.heavenhr.exception.CandidateExistsException;
import com.heavenhr.model.Candidate;
import com.heavenhr.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService
{

    @Autowired
    protected CandidateRepository candidateRepository;


    @Override
    public Candidate getById(Long id)
    {
        Optional<Candidate> cand = candidateRepository.findById(id);
        if (!cand.isPresent())
        {
            throw new EntityNotFoundException("Candidate entity not found.");
        }

        return cand.get();
    }


    @Override
    public @Valid Candidate saveCandidate(@Valid Candidate candidate)
    {
        try
        {
            candidate = candidateRepository.save(candidate);
        }
        catch (ConstraintViolationException | DataIntegrityViolationException e)
        {
            throw new CandidateExistsException("Candidate Already Exists.");
        }
        return candidate;
    }
}