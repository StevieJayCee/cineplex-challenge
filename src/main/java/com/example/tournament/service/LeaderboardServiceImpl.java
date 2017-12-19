package com.example.tournament.service;

import com.example.tournament.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("leaderboardService")
public class LeaderboardServiceImpl implements LeaderboardService {

    @Override
    public List<User> getLeaderboard() {

        Comparator<User> byUserWinsAndLosses
                = Comparator.comparing(User::getWins, Comparator.reverseOrder())
                .thenComparing(User::getLosses, Comparator.reverseOrder());

        List<User> usersByWinsAndLosses = new ArrayList<>(dbResponse().values());

        List<User> rankedUsers = new ArrayList<>();
        usersByWinsAndLosses.stream().sorted(byUserWinsAndLosses).forEach(user -> {

            if(rankedUsers.size() > 0){
                User lastRanked = rankedUsers.get(rankedUsers.size()-1);

                if(user.getWins() - user.getLosses() == lastRanked.getWins() - lastRanked.getLosses()) {
                    user.setCurrentRank(lastRanked.getCurrentRank());
                } else {
                    user.setCurrentRank(lastRanked.getCurrentRank() +1);
                }
            } else {
                user.setCurrentRank(1);
            }

            rankedUsers.add(user);
        });

        return rankedUsers;
    }

    private static Map<String, User> dbResponse() {

        // find better performant
        Map<String, User> users = new HashMap<>();
        users.put("Jane", new User("Jane", 2, 3, 0));
        users.put("Jacob", new User("Jacob", 2, 3, 0));
        users.put("Jamie", new User("Jamie", 3, 2, 0));
        users.put("Jerry", new User("Jerry", 0, 5, 0));
        users.put("Jessica", new User("Jessica", 5, 0, 0));
        users.put("Michael", new User("Michael", 3, 2, 0));



        //Jessica loses 2 matches against michael
        users.get("Jessica").setLosses(2);
        users.get("Michael").setWins(2);

        //UnkownPlayer joins the tournament and wins 12 games
        users.put("Unknown", new User("Unknown", 12, 0, 0));

        users.get("Jane").setLosses(5);
        users.get("Jacob").setLosses(5);
        users.get("Jamie").setLosses(4);
        users.get("Jerry").setLosses(7);
        users.get("Michael").setLosses(4);
        users.get("Jessica").setLosses(4);


        return users;
    }
}
