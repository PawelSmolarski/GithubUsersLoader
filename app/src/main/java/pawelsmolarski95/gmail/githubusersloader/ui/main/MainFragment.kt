package pawelsmolarski95.gmail.githubusersloader.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pawelsmolarski95.gmail.githubusersloader.databinding.FragmentMainBinding
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.UsersAdapter
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
        initLoadingObserver()
        initUsersDataObserver()
    }

    private fun initUsersDataObserver() {
        viewModel.users.observe(viewLifecycleOwner, {
            it.fold(
                onSuccess = { users ->
                    usersAdapter?.submitList(users)
                },
                onFailure = {
                    binding.mainRepeatLayout.visible()
                }
            )
        })
    }

    private fun initLoadingObserver() {
        viewModel.isDataLoading.observe(viewLifecycleOwner, {
            if (it) {
                binding.mainLoader.visible()
            } else {
                binding.mainLoader.gone()
            }
        })
    }

    private fun initView() {
        initListeners()
        initList()
    }

    private fun initListeners() {
        binding.mainRepeatLayout.setOnClickListener {
            binding.mainRepeatLayout.gone()
            viewModel.loadData()
        }
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
