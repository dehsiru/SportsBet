package com.example.sportsbet.controller;

import com.example.sportsbet.model.MatchOdds;
import com.example.sportsbet.service.MatchOddsService;
import com.example.sportsbet.service.MatchesAndMatchOddsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/match-odds")
public class MatchOddsController {

    private final MatchOddsService matchOddsService;
    private final MatchesAndMatchOddsService matchesAndMatchOddsService;

    public MatchOddsController(MatchOddsService matchOddsService, MatchesAndMatchOddsService matchesAndMatchOddsService) {
        this.matchOddsService = matchOddsService;
        this.matchesAndMatchOddsService = matchesAndMatchOddsService;
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    @ApiOperation(value = "Rest request to get all odds", response = MatchOdds.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = MatchOdds.class),
            @ApiResponse(code = 400, message = "Bad request", response = MatchOdds.class)
    })
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<MatchOdds>> getAllMatchOdds(){
        return new ResponseEntity<>(matchOddsService.findAllMatchOdds(), HttpStatus.OK);
    }

    @ApiOperation(value = "Rest request to find match odds by id", response = MatchOdds.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = MatchOdds.class),
            @ApiResponse(code = 400, message = "Bad request", response = MatchOdds.class)
    })
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/find/{id}")
    public ResponseEntity<MatchOdds> getMatchOddsById(@Valid @ApiParam(value = "Required match odds id", example = "2", required = true) @PathVariable("id") Long id){
        return new ResponseEntity<>(matchOddsService.findMatchOddsById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Rest request to add new match odds", response = MatchOdds.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success", response = MatchOdds.class),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<MatchOdds> addMatchOdds(@Valid @RequestBody MatchOdds matchOdds){
        return new ResponseEntity(matchOddsService.addMatchOdds(matchOdds), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Rest request to update match odds", response = MatchOdds.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success", response = MatchOdds.class),
            @ApiResponse(code = 400, message = "Bad request", response = MatchOdds.class)
    })
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/update")
    public ResponseEntity<MatchOdds> updateMatchOdds(@Valid @RequestBody MatchOdds matchOdds){
        return new ResponseEntity<>(matchOddsService.updateMatchOdds(matchOdds), HttpStatus.OK);
    }

    @ApiOperation(value = "Rest request to delete match odds")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMatchOdds(@Valid @PathVariable("id")
                                         @ApiParam(value = "Required match odds id", example = "2", required = true)
                                                 Long id){
        matchOddsService.deleteMatchOdds(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Rest request to get all odds for match id", response = MatchOdds.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = MatchOdds.class),
            @ApiResponse(code = 400, message = "Bad request", response = MatchOdds.class)
    })
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/find/match-id/{matchId}", produces = {"application/json"})
    public ResponseEntity<List<MatchOdds>> getAllMatchOddsByMatchId(@Valid @ApiParam(value = "Required match id", example = "2", required = true) @PathVariable("matchId") Long matchId){
        return new ResponseEntity<>(matchesAndMatchOddsService.findAllMatchOddsByMatchId(matchId), HttpStatus.OK);
    }













}
