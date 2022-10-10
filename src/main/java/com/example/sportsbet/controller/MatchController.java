package com.example.sportsbet.controller;

import com.example.sportsbet.model.Match;
import com.example.sportsbet.service.MatchOddsService;
import com.example.sportsbet.service.MatchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;
    private final MatchOddsService matchOddsService;

    public MatchController(MatchService matchService, MatchOddsService matchOddsService) {
        this.matchService = matchService;
        this.matchOddsService = matchOddsService;
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    @ApiOperation(value = "Rest request to get all matches", response = Match.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Match.class),
            @ApiResponse(code = 400, message = "Bad request", response = Match.class)
    })
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Match>> getAllMatches(){
        return new ResponseEntity<>(matchService.findAllMatches(), HttpStatus.OK);
    }

    @ApiOperation(value = "Rest request to find match", response = Match.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Match.class),
            @ApiResponse(code = 400, message = "Bad request", response = Match.class)
    })
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/find/{id}")
    public ResponseEntity<Match> getMatchById(@Valid @ApiParam(value = "Required match id", example = "2", required = true) @PathVariable("id") Long id){
        return new ResponseEntity<>(matchService.findMatchById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Rest request to add new match", response = Match.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success", response = Match.class),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Match> addMatch(@Valid @RequestBody Match match){
        return new ResponseEntity( matchService.addMatch(match), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Rest request to update match", response = Match.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success", response = Match.class),
            @ApiResponse(code = 400, message = "Bad request", response = Match.class)
    })
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/update")
    public ResponseEntity<Match> updateMatch(@Valid @RequestBody Match match){
        return new ResponseEntity<>(matchService.updateMatch(match), HttpStatus.OK);
    }

    @ApiOperation(value = "Rest request to delete match")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMatch(@Valid @PathVariable("id")
                                         @ApiParam(value = "Required match id", example = "2", required = true)
                                         Long id){
        matchService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
