package pawelsmolarski95.gmail.githubusersloader.ui.main.users

sealed class UserUiState {
    object Loading : UserUiState()
    data class Error(val throwable: Throwable): UserUiState()
    data class Success(val usersUi: List<UserUi>, val query: String) : UserUiState()
}
