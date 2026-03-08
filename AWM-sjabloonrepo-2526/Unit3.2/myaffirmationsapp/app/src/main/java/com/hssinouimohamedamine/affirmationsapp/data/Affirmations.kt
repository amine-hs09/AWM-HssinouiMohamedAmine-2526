package com.hssinouimohamedamine.affirmationsapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmations (
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)