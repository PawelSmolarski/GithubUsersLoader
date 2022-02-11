package pawelsmolarski95.gmail.githubusersloader.ui.main.users

import androidx.recyclerview.widget.RecyclerView
import coil.load
import pawelsmolarski95.gmail.githubusersloader.databinding.ListUsersBinding

class UsersViewHolder(
    private val binding: ListUsersBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bindTo(userUi: UserUi) {
        initUserAvatarView(userUi)
        initUserNameView(userUi)
        initUserReposView(userUi)
    }

    private fun initUserAvatarView(userUi: UserUi) {
        binding.userAvatar.load(userUi.avatarImageUrl)
    }

    private fun initUserNameView(userUi: UserUi) {
        binding.userName.text = userUi.name
    }

    private fun initUserReposView(userUi: UserUi) {
        binding.userRepo1.text = userUi.repoNames.getOrNull(0)
        binding.userRepo2.text = userUi.repoNames.getOrNull(1)
        binding.userRepo2.text = userUi.repoNames.getOrNull(2)
    }
}
