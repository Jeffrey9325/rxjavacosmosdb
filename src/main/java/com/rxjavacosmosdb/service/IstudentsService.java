package com.rxjavacosmosdb.service;

import com.rxjavacosmosdb.model.Students;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.Date;

/**
 * IstudentsService interface.
 * @author jeffrey
 * @version v1.0
 */

public interface IstudentsService {
  /**
   * search by name student document.
   * @param name full name student
   * @return
   */

  Flowable<Students> searchbyName(String name);
  /**
   * search by document student document.
   * @param document identification document number
   * @return
   */
  
  Single<Students> searchbyDocument(String document);
  /**
   * search by rank date of birth.
   * @param fromDate date
   * @param toDate date
   * @return
   */
  
  Flowable<Students> searchbyrankdateofBirth(Date fromDate, Date toDate);
  /**
   * create record student document.
   * @param student student
   * @return
   */
  
  Completable createStudent(Students student);
  /**
   * show all students of student document.
   * @return
   */
  
  Observable<Students> allStudents();
  /**
   * modify record student document.
   * @param student student
   * @return
   */
  
  Single<Students> modifyStudent(String id, Students student);
  /**
   * delete record of student document.
   * @param student student
   * @return
   */
  
  Completable deleteStudents(String id);
  /**
   * find by id student document.
   * @param idStudent id
   * @return
   */
  
//  Single<Students> findbyId(String idStudent);
  
}