package com.example.Animal.Shelter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column (name = "id", nullable = false)
  private int id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(columnDefinition = "LONGTEXT")
  private String urlImg;

  @Column(name = "Description", columnDefinition = "LONGTEXT", nullable = false)
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonBackReference
  @JoinColumn(name = "user_id")
  private User user;
}
