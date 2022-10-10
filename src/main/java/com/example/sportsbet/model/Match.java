package com.example.sportsbet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "match")
public class Match implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Field description can't be blank!")
    @Column(name = "description")
    String description;

    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull(message = "Please insert match date!")
    @Column(name = "match_date")
    LocalDate matchDate;


    @NotNull(message = "Please insert match time!")
    @Column(name="match_time")
    LocalTime matchTime;

    @NotBlank(message = "Field team A can't be blank!")
    @Column(name="team_a")
    String teamA;

    @NotBlank(message = "Field team B can't be blank!")
    @Column(name="team_b")
    String teamB;

    @NotNull(message = "Field sport can't be null!")
    @Min(value = 1, message = "Insert 1 for football, 2 for basketball!")
    @Max(value = 2, message = "Insert 1 for football, 2 for basketball!")
    @Column(name="sport")
    Integer sport;

    @Override
    public String toString() {
        return "Match{" +
                ", The match title is '" + description + '\'' +
                ", the  date is on " + matchDate +
                ", the time is =" + matchTime + ". "+
                ", The first team is ='" + teamA + '\'' +
                ", and the second time is ='" + teamB + '\'' +
                ", The sport is=" + Sport.values()[sport] +
                '}';
    }
}
