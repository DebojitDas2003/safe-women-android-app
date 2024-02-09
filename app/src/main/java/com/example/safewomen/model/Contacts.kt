import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Contacts(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)