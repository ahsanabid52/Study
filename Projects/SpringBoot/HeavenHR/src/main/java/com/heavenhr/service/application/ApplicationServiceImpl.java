package com.heavenhr.service.application;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.heavenhr.exception.CandidateExistsException;
import com.heavenhr.exception.InvalidStatusException;
import com.heavenhr.model.Application;
import com.heavenhr.model.ApplicationStatusEnum;
import com.heavenhr.model.Offer;
import com.heavenhr.repository.ApplicationRepository;
import com.heavenhr.repository.CandidateRepository;
import com.heavenhr.repository.OfferRepository;
import com.heavenhr.util.LoggingInterceptor;

@Service
public class ApplicationServiceImpl implements ApplicationService
{

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Autowired
    protected ApplicationRepository appRepository;

    @Autowired
    protected OfferRepository offerRepository;

    @Autowired
    protected CandidateRepository candidateRepository;


    @Override
    public Application getById(Long id)
    {
        Application application = appRepository.getOne(id);
        if (null == application)
        {
            throw new EntityNotFoundException("Application Entity Not Found with id " + id);
        }
        return application;
    }


    @Override
    public List<Application> getAllApplications()
    {
        return appRepository.findAll();
    }


    @Override
    @Transactional(readOnly = false)
    public @Valid Application saveApplication(@Valid Application app)
    {
        try
        {
            if (candidateRepository.existsById(app.getCandidate().getCandidateId()))
            {
                if (offerRepository.existsById(app.getOffer().getOfferId()))
                {
                    app = appRepository.save(app);
                    incrementOfferAccordingly(app.getOffer().getOfferId());
                    trigger(app);
                }
                else
                {
                    throw new EntityNotFoundException("Offer Not Found");
                }
            }
            else
            {
                throw new EntityNotFoundException("Candidate Not Found");
            }
        }
        catch (ConstraintViolationException | DataIntegrityViolationException e)
        {
            throw new CandidateExistsException("Candidate Already Exists");
        }
        return app;

    }


    @Override
    public List<Application> getApplicationsByOfferId(Long id)
    {

        return appRepository.getApplicationsByOfferId(id);
    }


    @Override
    public Application getApplicationByOfferIdAndApplicationId(Long offerId, Long appId)
    {
        return appRepository.getApplicationByOfferIdAndApplicationId(offerId, appId);
    }


    @Override
    public Long getCountOfApplications()
    {
        return appRepository.count();
    }


    @Override
    public Application updateStatus(String status, Long id)
    {
        if (StringUtils.isEmpty(status))
        {
            throw new InvalidStatusException("Invalid Status in the input. " + status);
        }
        Application application = getById(id);
        application.setApplicationStatus(ApplicationStatusEnum.valueOf(status));
        application = appRepository.saveAndFlush(application);
        trigger(application);
        return application;
    }


    protected void incrementOfferAccordingly(Long id)
    {
        Offer offer = offerRepository.findById(id).get();
        offer.setNumberOfApplications(offer.getNumberOfApplications() + 1);
        offerRepository.save(offer);
    }


    private static void trigger(Application appl)
    {
        logger.info("Application with id {} status is changed to {}.", appl.getId(), appl.getApplicationStatus());
    }
}