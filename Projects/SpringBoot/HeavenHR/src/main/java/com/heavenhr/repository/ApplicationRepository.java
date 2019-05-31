package com.heavenhr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.heavenhr.model.Application;

@Repository("applicationRepository")
public interface ApplicationRepository extends JpaRepository<Application, Long>
{

    @Query("SELECT app FROM Application app WHERE offer_id = ?1")
    List<Application> getApplicationsByOfferId(Long id);


    @Query("SELECT app FROM Application app WHERE offer_id = ?1 AND application_id = ?2")
    Application getApplicationByOfferIdAndApplicationId(Long offerId, Long appId);

}
