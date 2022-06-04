package pawelsmolarski95.gmail.githubusersloader.ui.main.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import pawelsmolarski95.gmail.githubusersloader.R
import pawelsmolarski95.gmail.githubusersloader.ui.shared.primaryRegularTextBold

@Composable
fun UsersError(onClickListener: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        color = colorResource(R.color.colorPrimary),
        modifier = modifier
            .fillMaxHeight()
            .fillMaxHeight()
            .clickable { onClickListener() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MaterialTheme(typography = primaryRegularTextBold()) {
                Text(
                    text = stringResource(id = R.string.common_repeat_hint)
                )
            }
        }
    }
}
