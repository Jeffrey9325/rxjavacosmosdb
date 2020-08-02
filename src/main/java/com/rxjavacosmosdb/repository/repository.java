package com.rxjavacosmosdb.repository;

import java.io.Serializable;
import java.util.Date;

//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

//import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;
//import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.rxjavacosmosdb.model.Students;

import io.reactivex.Flowable;
import io.reactivex.Single;


@Repository
public interface repository extends RxJava2CrudRepository<Students, Serializable> {
  /**
   * find by Full Name student document.
   * @param fullName full name
   * @return
   */

  Flowable<Students> findByFullName(String fullName);
  /**
   * find by identification document number student document.
   * @param documentNumber identification document number
   * @return
   */
  
  Single<Students> findByDocumentNumber(String documentNumber);
  /**
   * find by rank date of birth student document.
   * @param fromDate date
   * @param toDate date
   * @return
   */
  
  Flowable<Students> findByDateofBirthBetween(Date fromDate, Date toDate);
	

}
