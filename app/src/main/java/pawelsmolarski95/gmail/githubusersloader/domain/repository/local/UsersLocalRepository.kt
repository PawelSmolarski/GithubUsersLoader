package pawelsmolarski95.gmail.githubusersloader.domain.repository.local

import pawelsmolarski95.gmail.githubusersloader.domain.features.user.User

interface UsersLocalRepository {
    suspend fun getUsersWithRepos() : List<User>
    suspend fun insertUsersWithRepos(users: List<User>)
}
