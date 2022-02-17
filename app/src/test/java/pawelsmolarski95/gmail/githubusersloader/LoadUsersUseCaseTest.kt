package pawelsmolarski95.gmail.githubusersloader

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.doThrow
import org.mockito.junit.MockitoJUnit
import pawelsmolarski95.gmail.githubusersloader.domain.features.user.LoadUsersUseCase
import pawelsmolarski95.gmail.githubusersloader.domain.features.user.User
import pawelsmolarski95.gmail.githubusersloader.domain.model.UserReposResponseModel
import pawelsmolarski95.gmail.githubusersloader.domain.model.UsersResponseModel
import pawelsmolarski95.gmail.githubusersloader.domain.repository.api.GithubApiRepository
import pawelsmolarski95.gmail.githubusersloader.domain.repository.local.UsersLocalRepository

class LoadUsersUseCaseTest {
    @Mock
    lateinit var usersLocalRepository: UsersLocalRepository

    @Mock
    lateinit var githubApiRepository: GithubApiRepository

    private lateinit var loadUsersUseCase: LoadUsersUseCase

    @Rule
    @JvmField
    var mockitoJUnitRule = MockitoJUnit.rule()

    @Before
    fun setUp() {
        loadUsersUseCase = LoadUsersUseCase(githubApiRepository, usersLocalRepository)
    }

    private val usersResponse = listOf(
        User(
            1,
            "image 1",
            "name 1",
            listOf(
                "repo 1",
                "repo 2",
                "repo 3"
            )
        ), User(
            2,
            "image 2",
            "name 2",
            listOf(
                "repo 1",
                "repo 2",
                "repo 3"
            )
        )
    )

    private val usersResponseModels: List<UsersResponseModel> = listOf(
        UsersResponseModel(
            1,
            "image 1",
            "name 1"
        ),
        UsersResponseModel(
            2,
            "image 2",
            "name 2"
        )
    )

    private val userRepos: List<UserReposResponseModel> = listOf(
        UserReposResponseModel(
            "repo 1"
        ),
        UserReposResponseModel(
            "repo 2"
        ),
        UserReposResponseModel(
            "repo 3"
        )
    )

    private suspend fun mockApiProblems() {
        doThrow(RuntimeException())
            .`when`(githubApiRepository)
            .getUsers()

        doReturn(usersResponse)
            .`when`(usersLocalRepository)
            .getUsersWithRepos()
    }

    private suspend fun mockApiWorking() {
        doReturn(usersResponseModels)
            .`when`(githubApiRepository)
            .getUsers()

        doReturn(userRepos)
            .`when`(githubApiRepository)
            .getUserRepos(usersResponseModels[0].login, 3)

        doReturn(userRepos)
            .`when`(githubApiRepository)
            .getUserRepos(usersResponseModels[1].login, 3)
    }

    @Test
    fun `should get data from local storage when API error`() {
        runBlocking {
            mockApiProblems()
            assert(loadUsersUseCase.getAllUsers() == usersResponse)
        }
    }

    @Test
    fun `should get data from API`() {
        runBlocking {
            mockApiWorking()
            assert(loadUsersUseCase.getAllUsers() == usersResponse)
        }
    }

    @Test
    fun `should get data from API by query`() {
        runBlocking {
            mockApiWorking()
            assert(loadUsersUseCase.getUsersByQuery("name 1") == listOf(usersResponse.first()))
        }
    }

    @Test
    fun `should get empty data from API by query`() {
        runBlocking {
            mockApiWorking()
            assert(loadUsersUseCase.getUsersByQuery("not possible name").isEmpty())
        }
    }
}
