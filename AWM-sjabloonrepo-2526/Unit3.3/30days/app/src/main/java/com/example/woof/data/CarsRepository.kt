package com.hssinouimohamedamine.affirmationsapp.data

import com.hssinouimohamedamine.affirmationsapp.R

object CarsRepository {
    val cars = listOf(
        Car(R.string.day1, R.string.car1_name, R.string.car1_desc, R.drawable.car1),
        Car(R.string.day2, R.string.car2_name, R.string.car2_desc, R.drawable.car1), // Utilise car1 une deuxième fois ici
        Car(R.string.day3, R.string.car3_name, R.string.car3_desc, R.drawable.car3),
        Car(R.string.day4, R.string.car4_name, R.string.car4_desc, R.drawable.car4),
        Car(R.string.day5, R.string.car5_name, R.string.car5_desc, R.drawable.car5),
        Car(R.string.day6, R.string.car6_name, R.string.car6_desc, R.drawable.car6),
        Car(R.string.day7, R.string.car7_name, R.string.car7_desc, R.drawable.car7),
        Car(R.string.day8, R.string.car8_name, R.string.car8_desc, R.drawable.car8),
        Car(R.string.day9, R.string.car9_name, R.string.car9_desc, R.drawable.car9),
        Car(R.string.day10, R.string.car10_name, R.string.car10_desc, R.drawable.car10)
    )
}
