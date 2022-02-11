package pawelsmolarski95.gmail.githubusersloader.data.api

import pawelsmolarski95.gmail.githubusersloader.domain.model.UserReposResponseModel
import pawelsmolarski95.gmail.githubusersloader.domain.model.UsersResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("users")
    suspend fun getUsers(): List<UsersResponseModel>

    @GET("users/{login}/repos")
    suspend fun getReposForUser(
        @Path("login") login: String,
        @Query("per_page") page: Int
    ): List<UserReposResponseModel>
}
