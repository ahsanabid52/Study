package com.heavenhr.service.offer;

import java.util.List;

import javax.validation.Valid;

import com.heavenhr.model.Offer;

public interface OfferService
{

    Offer getById(Long id);


    List<Offer> findAll();


    Offer saveOffer(@Valid Offer offer);

}
