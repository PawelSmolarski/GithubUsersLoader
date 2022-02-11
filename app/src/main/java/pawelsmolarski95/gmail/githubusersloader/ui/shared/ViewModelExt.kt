package pawelsmolarski95.gmail.githubusersloader.ui.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

fun ViewModel.launchSafeWithViewModelScope(
    run: suspend () -> Unit,
    onError: suspend (Throwable) -> Unit = {}
): Job {
    return viewModelScope.launch {
        try {
            run()
        } catch (expected: Throwable) {
            Timber.e(expected)
            onError(expected)
        }
    }
}
