package com.example.sportsbet.repository;

import com.example.sportsbet.model.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {

    @Query("SELECT mo FROM MatchOdds mo WHERE mo.matchId = :matchId")
    List<MatchOdds> findAllMatchOddsByMatchId(@Param("matchId")Long matchId);


}

