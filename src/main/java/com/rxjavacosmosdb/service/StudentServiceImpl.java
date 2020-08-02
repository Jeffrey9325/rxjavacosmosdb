package com.rxjavacosmosdb.service;

import com.rxjavacosmosdb.model.Students;
import com.rxjavacosmosdb.repository.repository;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * StudentServiceImpl class.
 * @author jeffrey
 * @version v1.0
 */

@Service
public class StudentServiceImpl implements IstudentsService {
  /**
   * Reactive Repository.
   */
  @Autowired
  private repository repository;
 
  
  @Override
  public Flowable<Students> searchbyName(final String name) {
    return repository.findByFullName(name);
  }

  @Override
  public Single<Students> searchbyDocument(final String document) {
    return repository.findByDocumentNumber(document);
  }

  @Override
  public Flowable<Students> searchbyrankdateofBirth(final Date fromDate, final Date toDate) {
    return repository.findByDateofBirthBetween(fromDate, toDate);
  }

  @Override
  public Completable createStudent(final Students student) {
    return repository.save(student).ignoreElement();
  }

  @Override
  public Observable<Students> allStudents() {
    return repository.findAll().toObservable();
  }

  @Override
  public Single<Students> modifyStudent(String id, final Students student) {
	  return repository.findById(id).toSingle()
	  .flatMap(people -> {
	  people.setId(id);
	  people.setFullName(student.getFullName());
	  people.setGender(student.getGender());
	  people.setDateofBirth(student.getDateofBirth());
	  people.setTypeDocument(student.getTypeDocument());
	  people.setDocumentNumber(student.getDocumentNumber());
	  return repository.save(people);  
	  })
	  .doOnSuccess(ok -> System.out.println("modifyStudent ok"))
	  .doOnError(error -> System.out.println("modifyStudent error"));
  }

  @Override
  public Completable deleteStudents(final String id) {
	  return repository.deleteById(id)
			  .doOnComplete(() -> System.out.println("finished delete"))
	          .doOnError(e -> System.out.println("Error delete"));
  }

  //este codigo se borrara
//  @Override
//  public Single<Students> findbyId(final String idStudent) {
//    return repository.findById(idStudent);
//  }  
}
