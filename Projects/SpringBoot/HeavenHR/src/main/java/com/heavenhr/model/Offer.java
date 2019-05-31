package com.heavenhr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
    name = "offer")
public class Offer implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 433942753668123602L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @Column(unique = true,nullable =false)
    private String jobTitle;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(nullable = false)
    private Integer numberOfApplications = 0;


    public Long getOfferId()
    {
        return offerId;
    }


    public void setOfferId(Long offerId)
    {
        this.offerId = offerId;
    }


    public String getJobTitle()
    {
        return jobTitle;
    }


    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }


    public Date getStartDate()
    {
        return startDate;
    }


    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }


    public Integer getNumberOfApplications()
    {
        return numberOfApplications;
    }


    public void setNumberOfApplications(Integer numberOfApplications)
    {
        this.numberOfApplications = numberOfApplications;
    }
}
