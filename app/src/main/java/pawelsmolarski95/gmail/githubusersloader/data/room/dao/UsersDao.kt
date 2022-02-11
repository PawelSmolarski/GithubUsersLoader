package pawelsmolarski95.gmail.githubusersloader.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pawelsmolarski95.gmail.githubusersloader.data.entity.UserEntity

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(rows: List<UserEntity>)

    @Query("SELECT * FROM UserEntity")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("DELETE FROM UserEntity")
    suspend fun deleteAllData()
}
