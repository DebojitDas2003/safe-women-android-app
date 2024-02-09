import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Contact(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)