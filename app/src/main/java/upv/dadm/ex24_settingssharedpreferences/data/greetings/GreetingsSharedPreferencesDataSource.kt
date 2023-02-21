/*
 * Copyright (c) 2022
 * David de Andrés and Juan Carlos Ruiz
 * Development of apps for mobile devices
 * Universitat Politècnica de València
 */

package upv.dadm.ex24_settingssharedpreferences.data.greetings

import kotlinx.coroutines.flow.Flow

/**
 * Interface declaring the methods that the DataSource exposes to Repositories.
 */
interface GreetingsSharedPreferencesDataSource {

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
