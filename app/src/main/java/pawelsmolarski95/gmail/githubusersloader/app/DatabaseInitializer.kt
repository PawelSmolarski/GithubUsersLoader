package pawelsmolarski95.gmail.githubusersloader.app

import android.content.Context
import androidx.startup.Initializer
import pawelsmolarski95.gmail.githubusersloader.data.di.DataModule
import timber.log.Timber

class DatabaseInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        DataModule.createDatabase(context)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}
