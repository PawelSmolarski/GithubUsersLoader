package pawelsmolarski95.gmail.githubusersloader.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pawelsmolarski95.gmail.githubusersloader.domain.features.user.LoadUsersUseCase
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.UserUi
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.toUi
import pawelsmolarski95.gmail.githubusersloader.ui.shared.launchSafeWithViewModelScope

class MainViewModel : ViewModel() {
    private val loadUsersUseCase = LoadUsersUseCase()

    val users = MutableLiveData<Result<List<UserUi>>>()
    val isDataLoading = MutableLiveData<Boolean>()

    init {
        loadAllUsers()
    }

    fun loadAllUsers() {
        launchSafeWithViewModelScope(
            run = {
                isDataLoading.value = true
                users.value = Result.success(loadUsersUseCase.getAllUsers().toUi())
                isDataLoading.value = false
            },
            onError = {
                users.value = Result.failure(it)
                isDataLoading.value = false
            }
        )
    }

    fun loadUsersByQuery(query: String) {
        launchSafeWithViewModelScope(
            run = {
                isDataLoading.value = true
                users.value = Result.success(loadUsersUseCase.getUsersByQuery(query).toUi())
                isDataLoading.value = false
            },
            onError = {
                users.value = Result.failure(it)
                isDataLoading.value = false
            }
        )
    }
}
