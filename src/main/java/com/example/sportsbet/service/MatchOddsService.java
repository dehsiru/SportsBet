package com.example.sportsbet.service;

import com.example.sportsbet.model.Match;
import com.example.sportsbet.model.MatchOdds;
import com.example.sportsbet.repository.MatchOddsRepository;
import com.example.sportsbet.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchOddsService {

    private final MatchOddsRepository matchOddsRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public MatchOddsService(MatchOddsRepository matchOddsRepository, MatchRepository matchRepository) {
        this.matchOddsRepository = matchOddsRepository;
        this.matchRepository = matchRepository;
    }

    public List<MatchOdds> findAllMatchOdds(){
        return matchOddsRepository.findAll();
    }

    public MatchOdds findMatchOddsById(Long id){
        return matchOddsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match odds by id "+ id + "was not found!"));
    }

    public MatchOdds addMatchOdds(MatchOdds matchOdds) {
        return matchOddsRepository.save(matchOdds);
    }

    public MatchOdds updateMatchOdds(MatchOdds matchOdds) {
        if(matchRepository.existsById(matchOdds.getMatchId())) {
            return matchOddsRepository.save(matchOdds);
        }else{
            throw(new RuntimeException("There is no match by id "+ matchOdds.getMatchId() + "!"));
        }
    }

    public void deleteMatchOdds(Long id) {
        if( matchOddsRepository.existsById(id)) {
            matchOddsRepository.deleteById(id);
        }else{
            throw(new RuntimeException("Match Odds by id "+ id + " was not found!"));
        }
    }

}
