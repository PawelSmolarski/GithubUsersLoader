package pawelsmolarski95.gmail.githubusersloader.domain.repository.api

import pawelsmolarski95.gmail.githubusersloader.domain.model.UserReposResponseModel
import pawelsmolarski95.gmail.githubusersloader.domain.model.UsersResponseModel

interface GithubApiRepository {
    suspend fun getUsers(): List<UsersResponseModel>

    suspend fun getUserRepos(login: String, reposAmount: Int): List<UserReposResponseModel>
}
