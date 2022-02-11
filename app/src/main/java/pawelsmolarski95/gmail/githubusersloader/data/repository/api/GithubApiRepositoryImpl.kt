package pawelsmolarski95.gmail.githubusersloader.data.repository.api

import pawelsmolarski95.gmail.githubusersloader.data.api.GithubService
import pawelsmolarski95.gmail.githubusersloader.domain.model.UserReposResponseModel
import pawelsmolarski95.gmail.githubusersloader.domain.model.UsersResponseModel
import pawelsmolarski95.gmail.githubusersloader.domain.repository.api.GithubApiRepository

class GithubApiRepositoryImpl(
    private val githubService: GithubService
) : GithubApiRepository{
    override suspend fun getUsers(): List<UsersResponseModel> {
        return githubService.getUsers()
    }

    override suspend fun getUserRepos(login: String, reposAmount: Int): List<UserReposResponseModel> {
        return githubService.getReposForUser(login, reposAmount)
    }
}
