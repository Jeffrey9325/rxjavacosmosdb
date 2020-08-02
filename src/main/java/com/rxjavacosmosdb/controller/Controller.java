package com.rxjavacosmosdb.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rxjavacosmosdb.service.StudentServiceImpl;
import com.rxjavacosmosdb.model.Students;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@RestController
@RequestMapping("/Students/v1.0")
public class Controller {
	
	@Autowired
	public StudentServiceImpl repository;
	
	@GetMapping("/names/{fullName}")
	  public Flowable<Students> searchbyName(@PathVariable final String fullName) {
	    return repository.searchbyName(fullName);
	  }
	
	@GetMapping("/documents/{document}")
	  public Single<Students> searchbyDocument(@PathVariable final String document) {
	    return repository.searchbyDocument(document);
	  }
	
	@GetMapping("/dates/{fromDate}/{toDate}")
	  public Flowable<Students> searchbyrankdateofBirth(
	      @PathVariable @DateTimeFormat(iso = ISO.DATE) final Date fromDate,
	      @PathVariable  @DateTimeFormat(iso = ISO.DATE)  final Date toDate) {
	    return repository.searchbyrankdateofBirth(fromDate, toDate);
	  }
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	  public Completable createStudent(@Valid @RequestBody final Students student) {
	    return repository.createStudent(student);
	  }
	
	@GetMapping("/")
	  public Observable<Students> allStudents() {  
	    return repository.allStudents();
	  }
		
	@PutMapping("/{id}")
	  public Single<Students> modifyStudent(@PathVariable final String id,
	      @Valid @RequestBody final Students student) {
		return repository.modifyStudent(id, student);
	  }
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	  public Completable deleteStudents(@PathVariable final String id) {
	    return repository.deleteStudents(id);
	  }
}
