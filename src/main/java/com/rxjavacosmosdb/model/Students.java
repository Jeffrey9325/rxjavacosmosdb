package com.rxjavacosmosdb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "students")
@JsonPropertyOrder({"id", "fullName", "gender",
    "dateofBirth", "typeDocument", "documentNumber"})
public class Students implements Serializable {

  private static final long serialVersionUID = -4918046051378102684L;
  /**
   * id.
   */
  @Id
   private String id;
  /**
   * full name.
   */
  @NotEmpty(message = "should not be empty")
  private String fullName;
  /**
   * gender.
   */
  @NotEmpty(message = "should not be empty")
  private String gender;
  /**
   * date of birth.
   */
//  @JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
  
//  private LocalDate dateofBirth;
  private Date dateofBirth;
  /**
   * type of identification document.
   */
  @NotEmpty(message = "should not be empty")
  private String typeDocument;
  /**
   * identification document number.
   */
  @Size(min = 8, max = 8, message = "must contain 8 characters")
  private String documentNumber;
}