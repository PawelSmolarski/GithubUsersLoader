package pawelsmolarski95.gmail.githubusersloader.domain.features.user

import pawelsmolarski95.gmail.githubusersloader.data.di.ApiRepositoryModule
import pawelsmolarski95.gmail.githubusersloader.domain.shared.asyncMap

class LoadUsersUseCase {
    private val githubApiRepository = ApiRepositoryModule.provideGithubApiRepository()

    private val numberOfLoadedUsers: Int = 30
    private val numberOfLoadedRepos: Int = 3

    suspend fun execute(): List<User> {
        return githubApiRepository.getUsers().take(numberOfLoadedUsers)
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
            }.toList()
    }
}
