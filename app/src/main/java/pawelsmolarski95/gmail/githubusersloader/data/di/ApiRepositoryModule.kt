package pawelsmolarski95.gmail.githubusersloader.data.di

import pawelsmolarski95.gmail.githubusersloader.data.repository.api.GithubApiRepositoryImpl
import pawelsmolarski95.gmail.githubusersloader.domain.repository.api.GithubApiRepository

object ApiRepositoryModule {
    fun provideGithubApiRepository(): GithubApiRepository {
        return GithubApiRepositoryImpl(
            GithubRestApiModule.provideGithubService()
        )
    }
}
