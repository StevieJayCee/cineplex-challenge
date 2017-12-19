package com.example.tournament.service;

import com.example.tournament.model.User;

import java.util.Collection;

public interface LeaderboardService {

    Collection<User> getLeaderboard();

}
