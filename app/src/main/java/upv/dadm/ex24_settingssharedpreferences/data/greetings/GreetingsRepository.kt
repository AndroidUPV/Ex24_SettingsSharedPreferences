/*
 * Copyright (c) 2022-2023 Universitat Politècnica de València
 * Authors: David de Andrés and Juan Carlos Ruiz
 *          Fault-Tolerant Systems
 *          Instituto ITACA
 *          Universitat Politècnica de València
 *
 * Distributed under MIT license
 * (See accompanying file LICENSE.txt)
 */

package upv.dadm.ex24_settingssharedpreferences.data.greetings

import kotlinx.coroutines.flow.Flow

/**
 * Interface declaring the methods that the Repository exposes to ViewModels.
 */
interface GreetingsRepository {

    /**
     * Returns a Flow for the user name preference.
     */
    fun getUsername(): Flow<String>

    /**
     * Returns a Flow for the text color preference.
     */
    fun getTextColor(): Flow<String>

    /**
     * Returns a Flow for the icon visibility preference.
     */
    fun isIconVisible(): Flow<Boolean>
}