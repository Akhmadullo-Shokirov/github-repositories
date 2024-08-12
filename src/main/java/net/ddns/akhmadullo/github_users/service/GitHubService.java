package net.ddns.akhmadullo.github_users.service;

import net.ddns.akhmadullo.github_users.model.GitHubBranch;
import net.ddns.akhmadullo.github_users.model.GitHubRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubService {

    private final WebClient webClient;

    public GitHubService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.github.com").build();
    }

    public List<GitHubRepository> getUserRepositories(String username) {
        try {
            List<GitHubRepository> repositories = webClient.get()
                    .uri("/users/{username}/repos", username)
                    .retrieve()
                    .bodyToFlux(GitHubRepository.class)
                    .collectList()
                    .block();

            if (repositories == null || repositories.isEmpty()) {
                throw new RuntimeException("User not found");
            }

            return repositories.stream()
                    .filter(repo -> !repo.isFork())
                    .peek(repo -> repo.setBranches(getBranches(username, repo.getName())))
                    .collect(Collectors.toList());

        } catch (WebClientResponseException.NotFound e) {
            throw new RuntimeException("User not found", e);
        }
    }

    private List<GitHubBranch> getBranches(String username, String repoName) {
        return webClient.get()
                .uri("/repos/{username}/{repo}/branches", username, repoName)
                .retrieve()
                .bodyToFlux(GitHubBranch.class)
                .collectList()
                .block();
    }
}
