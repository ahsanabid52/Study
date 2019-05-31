package com.heavenhr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heavenhr.model.Candidate;

 
@Repository("candidateRepository")
public interface CandidateRepository extends JpaRepository<Candidate, Long>
{
    
}
