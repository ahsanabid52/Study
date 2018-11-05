package com.heavenhr.service.application;

import java.util.List;

import javax.validation.Valid;

import com.heavenhr.model.Application;

public interface ApplicationService
{

    Application getById(Long id);


    @Valid
    Application saveApplication(@Valid Application application);


    List<Application> getAllApplications();


    Application updateStatus(String status, Long id);


    Long getCountOfApplications();


    List<Application> getApplicationsByOfferId(Long id);


    Application getApplicationByOfferIdAndApplicationId(Long offerId, Long appId);

}
