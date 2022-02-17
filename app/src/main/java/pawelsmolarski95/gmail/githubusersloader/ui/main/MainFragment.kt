package pawelsmolarski95.gmail.githubusersloader.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import pawelsmolarski95.gmail.githubusersloader.databinding.FragmentMainBinding
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.UserUiState
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.UsersAdapter
import pawelsmolarski95.gmail.githubusersloader.ui.shared.KeyboardUtil.hideKeyboard
import pawelsmolarski95.gmail.githubusersloader.ui.shared.gone
import pawelsmolarski95.gmail.githubusersloader.ui.shared.visible

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var usersAdapter: UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
    }

    private fun initObservers() {
        initUsersDataObserver()
    }

    private fun initUsersDataObserver() {
        viewModel.usersUiState.observe(viewLifecycleOwner, { userUiState ->
            when (userUiState) {
                is UserUiState.Error -> {
                    binding.mainLoader.gone()
                    binding.mainRepeatLayout.visible()
                }
                UserUiState.Loading -> {
                    binding.mainLoader.visible()
                }
                is UserUiState.Success -> {
                    binding.mainLoader.gone()
                    usersAdapter?.submitList(userUiState.usersUi)
                }
            }
        })
    }

    private fun initView() {
        initListeners()
        initList()
        initSearchEditText()
    }

    private fun initListeners() {
        binding.mainRepeatLayout.setOnClickListener {
            binding.mainRepeatLayout.gone()
            viewModel.loadAllUsers()
        }

        binding.mainSearchIcon.setOnClickListener {
            performSearch()
        }

        binding.mainSearchClose.setOnClickListener {
            clearSearchText()
        }
    }

    private fun clearSearchText() {
        binding.mainSearchEditField.text = null
    }

    private fun initSearchEditText() {
        binding.mainSearchEditField.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch()
            }
            false
        }
    }

    private fun performSearch() {
        hideKeyboard()
        viewModel.loadUsersByQuery(binding.mainSearchEditField.text?.toString() ?: "")
    }

    private fun initList() {
        if (usersAdapter != null) {
            binding.mainUserList.adapter = usersAdapter
        } else {
            usersAdapter = (binding.mainUserList.adapter as? UsersAdapter) ?: UsersAdapter()
            binding.mainUserList.adapter = usersAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
