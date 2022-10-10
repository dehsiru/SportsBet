package com.example.sportsbet.service;

import com.example.sportsbet.model.MatchOdds;
import com.example.sportsbet.repository.MatchOddsRepository;
import com.example.sportsbet.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchesAndMatchOddsService {

    private final MatchOddsRepository matchOddsRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public MatchesAndMatchOddsService(MatchOddsRepository matchOddsRepository, MatchRepository matchRepository) {
        this.matchOddsRepository = matchOddsRepository;
        this.matchRepository = matchRepository;
    }

    public List<MatchOdds> findAllMatchOddsByMatchId(Long matchId){
        if(matchRepository.existsById(matchId)){
            return matchOddsRepository.findAllMatchOddsByMatchId(matchId);
        }else {
            throw(new RuntimeException("There are no active records on Match with match id "+ matchId + " !"));
        }

    }
}
