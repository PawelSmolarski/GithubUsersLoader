package pawelsmolarski95.gmail.githubusersloader.ui.main.users

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pawelsmolarski95.gmail.githubusersloader.domain.features.user.User

data class UserUi(
    val id: Long,
    val avatarImageUrl: String,
    val name: String,
    val repoNames: List<String>
)

suspend fun List<User>.toUi(): List<UserUi> {
    return withContext(Dispatchers.Default) {
        this@toUi.map {
            it.toUi()
        }
    }
}

fun User.toUi(): UserUi {
    return UserUi(
        id, avatarImageUrl, name, repoNames
    )
}
