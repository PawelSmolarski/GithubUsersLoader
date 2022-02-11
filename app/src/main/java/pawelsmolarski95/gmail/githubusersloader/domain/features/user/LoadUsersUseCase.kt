package pawelsmolarski95.gmail.githubusersloader.domain.features.user

import pawelsmolarski95.gmail.githubusersloader.data.di.ApiRepositoryModule
import pawelsmolarski95.gmail.githubusersloader.data.di.DataModule
import pawelsmolarski95.gmail.githubusersloader.domain.repository.api.GithubApiRepository
import pawelsmolarski95.gmail.githubusersloader.domain.repository.local.UsersLocalRepository
import pawelsmolarski95.gmail.githubusersloader.domain.shared.asyncMap

class LoadUsersUseCase {
    private val githubApiRepository: GithubApiRepository =
        ApiRepositoryModule.provideGithubApiRepository()

    private val usersLocalRepository: UsersLocalRepository =
        DataModule.provideUsersLocalRepository()

    companion object {
        private const val numberOfLoadedUsers: Int = 30
        private const val numberOfLoadedRepos: Int = 3
    }
    suspend fun getAllUsers(): List<User> {
        return try {
            getUsersFromApi()
        } catch (expected: Throwable) { // TODO more explicit exception for lack of internet connection or API problems.
            getUsersFromLocalCache()
        }
    }

    suspend fun getUsersByQuery(query: String): List<User> {
        return getAllUsers().filter { user ->
            user.name.contains(query) || user.repoNames.any { repo ->
                repo.contains(query)
            }
        }
    }

    private suspend fun getUsersFromLocalCache(): List<User> {
        return usersLocalRepository.getUsersWithRepos()
    }

    private suspend fun getUsersFromApi() = githubApiRepository
        .getUsers()
        .take(numberOfLoadedUsers)
        .asyncMap { userResponseModel ->
            val login = userResponseModel.login
            val repos = githubApiRepository.getUserRepose(login, numberOfLoadedRepos).map {
                it.name
            }

            User(
                userResponseModel.id,
                userResponseModel.avatarUrl,
                userResponseModel.login,
                repos
            )
        }.toList().also { users ->
            saveUsersToFromLocalCache(users)
        }

    private suspend fun saveUsersToFromLocalCache(users: List<User>) {
        return usersLocalRepository.insertUsersWithRepos(users)
    }
}
