package pawelsmolarski95.gmail.githubusersloader.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.User

class MainViewModel : ViewModel() {
    val users = MutableLiveData<Result<List<User>>>()
    val isDataLoading = MutableLiveData<Boolean>()

    init {
        loadData()
    }

    fun loadData() {
        // TODO load data
    }
}
