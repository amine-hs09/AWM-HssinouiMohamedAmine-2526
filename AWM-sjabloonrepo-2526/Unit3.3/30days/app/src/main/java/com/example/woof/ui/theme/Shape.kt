package com.hssinouimohamedamine.affirmationsapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp), // Coins asymétriques style sport
    large = RoundedCornerShape(0.dp) // Cartes plus rectilignes
)
