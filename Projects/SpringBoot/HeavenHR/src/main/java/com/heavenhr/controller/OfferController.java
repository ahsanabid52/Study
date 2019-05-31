package com.heavenhr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heavenhr.exception.ConstraintsViolationException;
import com.heavenhr.model.Offer;
import com.heavenhr.service.offer.OfferService;

@RestController
@RequestMapping("/api/offer/")
public class OfferController
{

    @Autowired
    private OfferService offerService;


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOffer(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getById(id));
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<Offer>> getAllOffers()
    {
        return ResponseEntity.status(HttpStatus.OK).body(offerService.findAll());

    }


    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> editOffer(@PathVariable(value = "id") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(offerService.getById(id));
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> saveOffer(@Valid Offer offer) throws ConstraintsViolationException
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(offerService.saveOffer(offer));
    }
}
