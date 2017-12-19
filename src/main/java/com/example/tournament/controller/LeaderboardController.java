package com.example.tournament.controller;

import com.example.tournament.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.tournament.service.LeaderboardServiceImpl;

import java.util.List;

@RestController
public class LeaderboardController {

    @Autowired
    private LeaderboardServiceImpl leaderboardService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> index() {
        List<User> users = leaderboardService.getLeaderboard();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
