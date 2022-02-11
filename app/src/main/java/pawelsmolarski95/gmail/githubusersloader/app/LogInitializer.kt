package pawelsmolarski95.gmail.githubusersloader.app

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber

class LogInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        Timber.plant(Timber.DebugTree())
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}
