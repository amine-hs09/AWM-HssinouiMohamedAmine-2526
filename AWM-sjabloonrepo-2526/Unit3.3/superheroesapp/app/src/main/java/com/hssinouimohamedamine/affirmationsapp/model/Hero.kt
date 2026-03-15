package com.hssinouimohamedamine.affirmationsapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Modèle de données pour un héros
data class Hero(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)