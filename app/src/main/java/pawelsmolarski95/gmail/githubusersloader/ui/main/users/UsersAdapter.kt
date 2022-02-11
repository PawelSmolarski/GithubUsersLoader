package pawelsmolarski95.gmail.githubusersloader.ui.main.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pawelsmolarski95.gmail.githubusersloader.databinding.ListUsersBinding

class UsersAdapter(
) : ListAdapter<UserUi, UsersViewHolder>(
    object :
        DiffUtil.ItemCallback<UserUi>() {
        override fun areItemsTheSame(
            oldItem: UserUi,
            newItem: UserUi
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: UserUi,
            newItem: UserUi
        ) = oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(
            ListUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }
}
