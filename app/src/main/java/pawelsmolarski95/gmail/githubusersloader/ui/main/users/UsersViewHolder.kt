package pawelsmolarski95.gmail.githubusersloader.ui.main.users

import androidx.recyclerview.widget.RecyclerView
import coil.load
import pawelsmolarski95.gmail.githubusersloader.databinding.ListUsersBinding

class UsersViewHolder(
    private val binding: ListUsersBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bindTo(user: User) {
        initUserAvatarView(user)
        initUserNameView(user)
        initUserReposView(user)
    }

    private fun initUserAvatarView(user: User) {
        binding.userAvatar.load(user.avatarImageUrl)
    }

    private fun initUserNameView(user: User) {
        binding.userName.text = user.name
    }

    private fun initUserReposView(user: User) {
        binding.userRepo1.text = user.repoNames.getOrNull(0)
        binding.userRepo2.text = user.repoNames.getOrNull(1)
        binding.userRepo2.text = user.repoNames.getOrNull(2)
    }
}
