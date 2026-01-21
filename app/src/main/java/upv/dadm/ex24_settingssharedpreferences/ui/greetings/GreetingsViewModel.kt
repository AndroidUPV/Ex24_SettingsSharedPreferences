/*
 * Copyright (c) 2022-2026 Universitat Politècnica de València
 * Authors: David de Andrés and Juan Carlos Ruiz
 *          Fault-Tolerant Systems
 *          Instituto ITACA
 *          Universitat Politècnica de València
 *
 * Distributed under MIT license
 * (See accompanying file LICENSE.txt)
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
    greetingsRepository: GreetingsRepository
) : ViewModel() {

    // User name
    val userName = greetingsRepository.getUsername().asLiveData()

    // Text color
    val textColor = greetingsRepository.getTextColor().asLiveData()

    // Icon visibility
    val isIconVisible = greetingsRepository.isIconVisible().asLiveData()

}