package pawelsmolarski95.gmail.githubusersloader.data.di

import pawelsmolarski95.gmail.githubusersloader.BuildConfig

object ConfigModule {
    fun provideAuthenticationToken() = BuildConfig.API_TOKEN

    fun provideGithubBaseUrl() = BuildConfig.BASE_URL
}
