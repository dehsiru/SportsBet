package com.example.sportsbet.service;

import com.example.sportsbet.model.Match;
import com.example.sportsbet.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> findAllMatches(){
        return matchRepository.findAll();
    }

    public Match addMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Match match) {
        if(matchRepository.existsById(match.getId())) {
            return matchRepository.save(match);
        }else{
            throw(new RuntimeException("There is no match with id "+ match.getId() + " !"));
        }
    }

    public void deleteMatch(Long id) {
        if(matchRepository.existsById(id)){
            matchRepository.deleteById(id);
        }else {
            throw( new RuntimeException("Match by id "+ id + " was not found!"));
        }
    }

    public Match findMatchById(Long id){
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match by id "+ id + " was not found!"));
    }

}
