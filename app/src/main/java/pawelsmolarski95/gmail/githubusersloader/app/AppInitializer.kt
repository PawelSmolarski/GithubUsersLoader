package pawelsmolarski95.gmail.githubusersloader.app

import android.content.Context
import androidx.startup.Initializer
import pawelsmolarski95.gmail.githubusersloader.BuildConfig

class AppInitializer : Initializer<Unit> {

    private val devOnlyInitializers = listOf(
        LogInitializer::class.java,
    )

    private val requiredInitializers = listOf(
        DatabaseInitializer::class.java,
    )

    override fun create(context: Context) {
        // nop
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        val dependencies = mutableListOf<Class<out Initializer<*>>>()
        if (BuildConfig.DEBUG) {
            dependencies.addAll(devOnlyInitializers)
        }
        dependencies.addAll(requiredInitializers)
        return dependencies
    }
}
