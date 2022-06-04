package pawelsmolarski95.gmail.githubusersloader.ui.main.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.UserUiState

@Composable
fun MainScreen(
    uiState: State<UserUiState?>,
    onErrorClickListener: () -> Unit,
    onSearchClickListener: (query: String) -> Unit
) {
    when (val state = uiState.value) {
        is UserUiState.Error -> {
            UsersError(onErrorClickListener)
        }
        UserUiState.Loading -> {
            UsersLoading()
        }
        is UserUiState.Success -> {
            Column {
                Box(
                    modifier = Modifier.padding(16.dp)
                ) {
                    UsersSearch(query = state.query, onSearchClickListener = onSearchClickListener)
                }
                UsersList(users = state.usersUi)
            }
        }
        else -> {
            // NOP
        }
    }
}
