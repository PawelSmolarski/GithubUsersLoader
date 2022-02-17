package pawelsmolarski95.gmail.githubusersloader.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pawelsmolarski95.gmail.githubusersloader.domain.features.user.LoadUsersUseCase
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.UserUiState
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.toUi
import pawelsmolarski95.gmail.githubusersloader.ui.shared.launchSafeWithViewModelScope

class MainViewModel(
    private val loadUsersUseCase: LoadUsersUseCase = LoadUsersUseCase()
) : ViewModel() {
    val usersUiState = MutableLiveData<UserUiState>(UserUiState.Loading)

    init {
        loadAllUsers()
    }

    fun loadAllUsers() {
        launchSafeWithViewModelScope(
            run = {
                usersUiState.value = UserUiState.Loading
                usersUiState.value = UserUiState.Success(loadUsersUseCase.getAllUsers().toUi())
            },
            onError = {
                usersUiState.value = UserUiState.Error(it)
            }
        )
    }

    fun loadUsersByQuery(query: String) {
        launchSafeWithViewModelScope(
            run = {
                usersUiState.value = UserUiState.Loading
                usersUiState.value = UserUiState.Success(loadUsersUseCase.getUsersByQuery(query).toUi())
            },
            onError = {
                usersUiState.value = UserUiState.Error(it)
            }
        )
    }
}
