package net.ddns.akhmadullo.github_users.controller;

import net.ddns.akhmadullo.github_users.model.GitHubRepository;
import net.ddns.akhmadullo.github_users.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubController {

    @Autowired
    private GitHubService gitHubService;

    @GetMapping("/users/{username}/repos")
    public ResponseEntity<?> getUserRepositories(
            @PathVariable String username,
            @RequestHeader("Accept") String acceptHeader) {

        if (!"application/json".equals(acceptHeader)) {
            return ResponseEntity.status(406).body("Not Acceptable");
        }

        try {
            List<GitHubRepository> repositories = gitHubService.getUserRepositories(username);
            return ResponseEntity.ok(repositories);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(new ErrorResponse(404, e.getMessage()));
        }
    }

    private record ErrorResponse(int status, String message) {}
}
