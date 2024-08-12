package net.ddns.akhmadullo.github_users.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubBranch {

    @JsonProperty("name")
    private String name;

    @JsonProperty("commit")
    private Commit commit;

    public static class Commit {
        @JsonProperty("sha")
        private String sha;

        public String getSha() {
            return sha;
        }

        public void setSha(String sha) {
            this.sha = sha;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }
}
