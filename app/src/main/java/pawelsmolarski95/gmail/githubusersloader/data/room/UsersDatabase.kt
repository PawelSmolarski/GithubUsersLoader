package pawelsmolarski95.gmail.githubusersloader.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pawelsmolarski95.gmail.githubusersloader.data.entity.UserEntity
import pawelsmolarski95.gmail.githubusersloader.data.room.dao.UsersDao

@Database(
    entities = [
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    Converters::class
)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao

    companion object {
        const val DB_NAME = "GH_LocalStorage.db"
    }
}
