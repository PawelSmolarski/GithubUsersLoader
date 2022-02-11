package pawelsmolarski95.gmail.githubusersloader.domain.model

import com.squareup.moshi.Json

data class UsersResponseModel(
    val id: Long,
    @field:Json(name = "avatar_url") val avatarUrl: String,
    val login: String
)
