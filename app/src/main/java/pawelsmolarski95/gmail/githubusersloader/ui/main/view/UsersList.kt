package pawelsmolarski95.gmail.githubusersloader.ui.main.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.UserUi

@Composable
fun UsersList(users: List<UserUi>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier.fillMaxWidth(),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
    ) {
        items(users, key = { it.id }) { user ->
            UserItem(userUi = user)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun UsersListComposable() {
    UsersList(
        users = listOf(
            UserUi(
                1,
                "https://avatars.githubusercontent.com/u/47313?v=4",
                "Name",
                listOf("First", "Second", "Third")
            ),
            UserUi(
                2,
                "https://avatars.githubusercontent.com/u/47313?v=4",
                "Name",
                listOf("First", "Second", "Third")
            )
        )
    )
}