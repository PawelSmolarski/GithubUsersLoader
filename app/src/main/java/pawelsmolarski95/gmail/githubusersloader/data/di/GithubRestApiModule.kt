package pawelsmolarski95.gmail.githubusersloader.data.di

import okhttp3.OkHttpClient
import pawelsmolarski95.gmail.githubusersloader.data.api.GithubService
import pawelsmolarski95.gmail.githubusersloader.data.di.ConfigModule.provideAuthenticationToken
import pawelsmolarski95.gmail.githubusersloader.data.di.ConfigModule.provideGithubBaseUrl
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object GithubRestApiModule {
    private val githubService: GithubService by lazy {
        Retrofit.Builder()
            .baseUrl(provideGithubBaseUrl())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder().makeResponseConfig().build())
            .build()
            .create(GithubService::class.java)
    }

    fun provideGithubService(): GithubService {
        return githubService
    }

    private fun OkHttpClient.Builder.makeResponseConfig(): OkHttpClient.Builder {
        this.addNetworkInterceptor { chain ->
            val token = provideAuthenticationToken()
            val request = chain.request()
            if (token.isNotBlank()) {
                val requestBuilder = request.newBuilder()
                requestBuilder.addHeader("authorization", token)
                val newRequest = requestBuilder.build()
                chain.proceed(newRequest)
            } else {
                chain.proceed(request)
            }
        }

        return this
    }
}
