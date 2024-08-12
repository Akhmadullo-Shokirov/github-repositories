package net.ddns.akhmadullo.github_users.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GitHubRepository {

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("fork")
    private boolean fork;

    private List<GitHubBranch> branches;

    public static class Owner {
        @JsonProperty("login")
        private String login;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public List<GitHubBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<GitHubBranch> branches) {
        this.branches = branches;
    }
}


