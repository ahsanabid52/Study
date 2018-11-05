package com.heavenhr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(
    name = "candidate")
public class Candidate implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 6237400774195206952L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;

    @Column(unique = true, nullable = false)
    @Email(message = "*Please provide a valid Email")
    private String email;


    public Long getCandidateId()
    {
        return candidateId;
    }


    public void setCandidateId(Long candidateId)
    {
        this.candidateId = candidateId;
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }
}
