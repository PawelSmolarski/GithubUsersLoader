package pawelsmolarski95.gmail.githubusersloader.ui.main.users

data class User(
    val id: Long,
    val avatarImageUrl: String,
    val name: String,
    val repoNames: List<String>
)
