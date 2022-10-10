package com.example.sportsbet.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name ="matchodds")
public class MatchOdds implements Serializable {

    @Id
    @Column(name="id", insertable = false, updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="match_id")
    @NotNull(message = "Insert match id!")
    @Min(value = 1, message = "Match id cant be less than 1!")
    private Long matchId;

    @NotNull(message = "Insert specifier!")
    @Column(name="specifier")
    @Size(max=1)
    private String specifier;

    @NotNull(message = "Insert odd!")
    @Column(name="odd")
    private Long odd;

}
