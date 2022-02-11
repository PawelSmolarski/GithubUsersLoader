package pawelsmolarski95.gmail.githubusersloader.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pawelsmolarski95.gmail.githubusersloader.domain.features.user.LoadUsersUseCase
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.UserUi
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.toUi
import pawelsmolarski95.gmail.githubusersloader.ui.shared.launchSafeWithViewModelScope

class MainViewModel : ViewModel() {
    private val loadUsersUseCase = LoadUsersUseCase() // TODO move to DI

    val users = MutableLiveData<Result<List<UserUi>>>()
    val isDataLoading = MutableLiveData<Boolean>()

    init {
        loadData()
    }

    fun loadData() {
        launchSafeWithViewModelScope(
            run = {
                isDataLoading.value = true
                users.value = Result.success(loadUsersUseCase.execute().toUi())
                isDataLoading.value = false
            },
            onError = {
                users.value = Result.failure(it)
                isDataLoading.value = false
            }
        )
    }
}
