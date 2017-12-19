package com.example.tournament.model;

import java.util.Objects;

public class User {

    private String name;

    private int wins;

    private int losses;

    private int currentRank;

    public User(String name, int wins, int losses, int currentRank) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.currentRank = currentRank;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(int currentRank) {
        this.currentRank = currentRank;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(name, user.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
