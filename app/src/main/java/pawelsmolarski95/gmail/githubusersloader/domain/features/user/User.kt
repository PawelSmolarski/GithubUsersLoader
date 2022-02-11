package pawelsmolarski95.gmail.githubusersloader.domain.features.user

data class User(
    val id: Long,
    val avatarImageUrl: String,
    val name: String,
    val repoNames: List<String>
)
