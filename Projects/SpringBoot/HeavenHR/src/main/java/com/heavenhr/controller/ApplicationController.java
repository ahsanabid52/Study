package com.heavenhr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heavenhr.model.Application;
import com.heavenhr.model.ApplicationStatusEnum;
import com.heavenhr.service.application.ApplicationService;

@RestController
@RequestMapping("/api/application/")
public class ApplicationController
{

    @Autowired
    private ApplicationService appService;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<Application>> getAllapplication()
    {
        return ResponseEntity.status(HttpStatus.OK).body(appService.getAllApplications());
    }


    @RequestMapping(path = "/offer/{idOff}/{idApp}", method = RequestMethod.GET)
    public ResponseEntity<?> applicationsByOffer(@PathVariable Long idOff, @PathVariable Long idApp)
    {
        return ResponseEntity.status(HttpStatus.OK).body((appService.getApplicationByOfferIdAndApplicationId(idOff, idApp)));
    }


    @RequestMapping(path = "/offer/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Application>> getApplicationsByOfferId(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(appService.getApplicationsByOfferId(id));
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getApplication(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(appService.getById(id));
    }


    @RequestMapping(path = "/total", method = RequestMethod.GET)
    public ResponseEntity<?> countApplications()
    {
        Long count = appService.getCountOfApplications();
        if (null == count)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Application saveApplication(@Valid @RequestBody Application app)
    {
        // Initially setting application status to applied.
        app.setApplicationStatus(ApplicationStatusEnum.APPLIED);
        app = appService.saveApplication(app);

        return app;
    }


    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> updateStatus(@RequestBody String status, @PathVariable("id") Long id)
    {
        appService.updateStatus(status, id);
        return ResponseEntity.noContent().build();
    }
}