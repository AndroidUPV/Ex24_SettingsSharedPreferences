/*
 * Copyright (c) 2022
 * David de Andrés and Juan Carlos Ruiz
 * Development of apps for mobile devices
 * Universitat Politècnica de València
 */

package upv.dadm.ex24_settingssharedpreferences.ui.greetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import upv.dadm.ex24_settingssharedpreferences.data.greetings.GreetingsRepository
import javax.inject.Inject

/**
 * Holds information about the greetings screen.
 */
// The Hilt annotation @HiltEntryPoint is required to receive dependencies from its parent class
@HiltViewModel
class GreetingsViewModel @Inject constructor(
    private val greetingsRepository: GreetingsRepository
) : ViewModel() {

    // User name
    val userName = greetingsRepository.getUsername().asLiveData()

    // Text color
    val textColor = greetingsRepository.getTextColor().asLiveData()

    // Icon visibility
    val isIconVisible = greetingsRepository.isIconVisible().asLiveData()

}