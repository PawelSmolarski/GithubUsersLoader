package pawelsmolarski95.gmail.githubusersloader.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pawelsmolarski95.gmail.githubusersloader.domain.features.user.User

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false) val id: Long,
    val avatarImageUrl: String,
    val name: String,
    val repos: List<String>
)

suspend fun List<UserEntity>.toUsers(): List<User> {
    return withContext(Dispatchers.Default) {
        this@toUsers.map {
            it.toUser()
        }
    }
}

suspend fun UserEntity.toUser(): User {
    return withContext(Dispatchers.Default) {
        User(
            this@toUser.id,
            this@toUser.avatarImageUrl,
            this@toUser.name,
            this@toUser.repos
        )
    }
}

suspend fun List<User>.toUsersEntity(): List<UserEntity> {
    return withContext(Dispatchers.Default) {
        this@toUsersEntity.map {
            it.toUserEntity()
        }
    }
}

suspend fun User.toUserEntity(): UserEntity {
    return withContext(Dispatchers.Default) {
        UserEntity(
            this@toUserEntity.id,
            this@toUserEntity.avatarImageUrl,
            this@toUserEntity.name,
            this@toUserEntity.repoNames
        )
    }
}
