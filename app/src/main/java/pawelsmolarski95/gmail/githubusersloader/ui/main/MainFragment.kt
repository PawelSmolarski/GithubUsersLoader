package pawelsmolarski95.gmail.githubusersloader.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pawelsmolarski95.gmail.githubusersloader.ui.main.view.MainScreen
import pawelsmolarski95.gmail.githubusersloader.ui.shared.KeyboardUtil.hideKeyboard

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val userUiState = viewModel.usersUiState.observeAsState()
                MainScreen(
                    uiState = userUiState,
                    onSearchClickListener = {
                        hideKeyboard()
                        viewModel.loadUsersByQuery(it)
                    }, onErrorClickListener = {
                        viewModel.loadAllUsers()
                    }
                )
            }
        }
    }
}
