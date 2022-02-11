package pawelsmolarski95.gmail.githubusersloader.data.repository.local

import pawelsmolarski95.gmail.githubusersloader.data.di.DataModule
import pawelsmolarski95.gmail.githubusersloader.data.entity.toUsers
import pawelsmolarski95.gmail.githubusersloader.data.entity.toUsersEntity
import pawelsmolarski95.gmail.githubusersloader.data.room.UsersDatabase
import pawelsmolarski95.gmail.githubusersloader.domain.features.user.User
import pawelsmolarski95.gmail.githubusersloader.domain.repository.local.UsersLocalRepository

class UsersLocalRepositoryImpl(
    private val database: UsersDatabase = DataModule.provideUsersDatabase()
) : UsersLocalRepository {
    override suspend fun getUsersWithRepos(): List<User> {
        return database.usersDao().getAllUsers().toUsers()
    }

    override suspend fun insertUsersWithRepos(users: List<User>) {
        database.usersDao().deleteAllData()
        database.usersDao().insertUsers(users.toUsersEntity())
    }
}
