package com.hssinouimohamedamine.affirmationsapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Car(
    @StringRes val dayRes: Int,
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)
