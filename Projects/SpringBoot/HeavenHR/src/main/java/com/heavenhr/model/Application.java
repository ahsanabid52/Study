package com.heavenhr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Entity
@Table(
    name = "application", uniqueConstraints = {@UniqueConstraint(columnNames = { "candidate_id","offer_id"})}) 

public class Application implements Serializable
{

    private static final long serialVersionUID = -4318385333098835071L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Column(length = 1024, nullable = false)
    @Size(min = 10, max = 1024, message = "Max Length allowed is 1024.")
    private String resumeText;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Enumerated(EnumType.STRING)
    private ApplicationStatusEnum applicationStatus;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public Offer getOffer()
    {
        return offer;
    }


    public void setOffer(Offer offer)
    {
        this.offer = offer;
    }


    public Candidate getCandidate()
    {
        return candidate;
    }


    public void setCandidate(Candidate candidate)
    {
        this.candidate = candidate;
    }


    public String getResumeText()
    {
        return resumeText;
    }


    public void setResumeText(String resumeText)
    {
        this.resumeText = resumeText;
    }


    public ApplicationStatusEnum getApplicationStatus()
    {
        return applicationStatus;
    }


    public void setApplicationStatus(ApplicationStatusEnum applicationStatus)
    {
        this.applicationStatus = applicationStatus;
    }
}