package com.heavenhr.service.offer;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.heavenhr.exception.OfferExistsException;
import com.heavenhr.model.Offer;
import com.heavenhr.repository.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService
{

    @Autowired
    protected OfferRepository offerRepository;


    public Offer getById(Long id)
    {
        Optional<Offer> offer = offerRepository.findById(id);
        if (!offer.isPresent())
        {
            throw new EntityNotFoundException("Offer entity not found.");
        }

        return offer.get();
    }


    public List<Offer> findAll()
    {
        return offerRepository.findAll();
    }


    public Offer saveOffer(Offer offer)
    {

        try
        {
            offer = offerRepository.save(offer);
        }
        catch (ConstraintViolationException | DataIntegrityViolationException e)
        {
            throw new OfferExistsException("Offer Already Exists.");
        }
        return offer;

    }
}
