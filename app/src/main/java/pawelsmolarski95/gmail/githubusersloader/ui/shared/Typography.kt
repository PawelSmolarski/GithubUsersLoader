package pawelsmolarski95.gmail.githubusersloader.ui.shared

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pawelsmolarski95.gmail.githubusersloader.R

@Composable
fun primaryRegularText() = Typography(
    body1 = TextStyle(
        color = colorResource(id = R.color.primaryTextColor),
        fontSize = dimensionResource(id = R.dimen.normal_text_size).value.sp
    )
)

@Composable
fun secondaryRegularText() = Typography(
    body1 = TextStyle(
        color = colorResource(id = R.color.secondaryTextColor),
        fontSize = dimensionResource(id = R.dimen.normal_text_size).value.sp
    )
)

@Composable
fun primaryRegularTextBold() = primaryRegularText().let {
    it.copy(
        body1 = it.body1.copy(
            fontWeight = FontWeight.Bold
        )
    )
}
