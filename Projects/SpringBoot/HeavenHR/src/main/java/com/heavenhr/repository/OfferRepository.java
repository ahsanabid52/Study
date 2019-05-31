package com.heavenhr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heavenhr.model.Offer;


@Repository("offerRepository")
public interface OfferRepository extends JpaRepository<Offer, Long>
{

}
