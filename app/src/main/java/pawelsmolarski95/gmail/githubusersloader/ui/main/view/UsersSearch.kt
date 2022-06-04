package pawelsmolarski95.gmail.githubusersloader.ui.main.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pawelsmolarski95.gmail.githubusersloader.R
import pawelsmolarski95.gmail.githubusersloader.ui.shared.secondaryRegularText

@Composable
fun UsersSearch(
    query: String,
    modifier: Modifier = Modifier,
    onSearchClickListener: (query: String) -> Unit
) {
    var searchText by rememberSaveable { mutableStateOf(query) }

    Box(
        modifier = modifier
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = colorResource(R.color.colorPrimary)
                )
            )
            .background(colorResource(id = R.color.colorSecondary))
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_clear),
                contentDescription = stringResource(id = R.string.common_clear_text_description),
                modifier = Modifier
                    .clickable { searchText = "" }
                    .padding(start = 16.dp, end = 16.dp))
            MaterialTheme(typography = secondaryRegularText()) {
                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = colorResource(id = R.color.colorSecondary),
                        cursorColor = colorResource(id = R.color.secondaryTextColor),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .width(IntrinsicSize.Max)
                        .weight(1F),
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(id = R.string.common_search_description),
                modifier = Modifier
                    .clickable { onSearchClickListener(searchText) }
                    .padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun UsersSearchPreview() {
    UsersSearch(onSearchClickListener = {}, query = "")
}
