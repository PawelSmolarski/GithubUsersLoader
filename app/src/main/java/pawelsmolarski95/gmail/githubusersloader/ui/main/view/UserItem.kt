package pawelsmolarski95.gmail.githubusersloader.ui.main.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pawelsmolarski95.gmail.githubusersloader.R
import pawelsmolarski95.gmail.githubusersloader.ui.main.users.UserUi
import pawelsmolarski95.gmail.githubusersloader.ui.shared.primaryRegularText
import pawelsmolarski95.gmail.githubusersloader.ui.shared.primaryRegularTextBold

@Composable
fun UserItem(userUi: UserUi, modifier: Modifier = Modifier) {
    Surface(color = colorResource(R.color.colorPrimary), modifier = modifier.fillMaxWidth()) {
        Row {
            Box(modifier = Modifier.padding(16.dp)) {
                AsyncImage(
                    model = userUi.avatarImageUrl,
                    contentDescription = stringResource(id = R.string.users_avatar_description),
                    modifier = Modifier
                        .height(64.dp)
                        .width(64.dp)
                )
            }

            Column(modifier = Modifier.width(IntrinsicSize.Max)) {
                MaterialTheme(typography = primaryRegularTextBold()) {
                    Text(
                        text = userUi.name,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
                MaterialTheme(typography = primaryRegularText()) {
                    Text(
                        text = userUi.repoNames.getOrNull(0) ?: "",
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Text(
                        text = userUi.repoNames.getOrNull(1) ?: "",
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Text(
                        text = userUi.repoNames.getOrNull(2) ?: "",
                        modifier = Modifier.padding(top = 2.dp, bottom = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun UserItemPreview(
    userUi: UserUi = UserUi(
        1,
        "https://avatars.githubusercontent.com/u/47313?v=4",
        "Name",
        listOf("First", "Second", "Third")
    )
) {
    UserItem(userUi = userUi)
}