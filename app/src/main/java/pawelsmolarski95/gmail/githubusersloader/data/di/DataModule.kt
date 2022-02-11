package pawelsmolarski95.gmail.githubusersloader.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import pawelsmolarski95.gmail.githubusersloader.data.repository.local.UsersLocalRepositoryImpl
import pawelsmolarski95.gmail.githubusersloader.data.room.UsersDatabase
import pawelsmolarski95.gmail.githubusersloader.domain.repository.local.UsersLocalRepository

object DataModule {
    private lateinit var database: UsersDatabase

    private val usersLocalRepository: UsersLocalRepository by lazy {
        UsersLocalRepositoryImpl()
    }

    fun createDatabase(context: Context) {
        database = Room.databaseBuilder(context, UsersDatabase::class.java, UsersDatabase.DB_NAME)
            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .build()
    }

    fun provideUsersDatabase(): UsersDatabase = database

    fun provideUsersLocalRepository(): UsersLocalRepository = usersLocalRepository
}
