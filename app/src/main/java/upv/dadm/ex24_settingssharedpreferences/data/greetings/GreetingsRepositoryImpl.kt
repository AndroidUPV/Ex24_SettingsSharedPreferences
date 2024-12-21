/*
 * Copyright (c) 2022-2024 Universitat Politècnica de València
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
import javax.inject.Inject

/**
 * Repository for retrieving the user's preference about the greetings screen.
 * It implements the GreetingsRepository interface.
 */
class GreetingsRepositoryImpl @Inject constructor(
    private val greetingsSharedPreferencesDataSource: GreetingsSharedPreferencesDataSource
) : GreetingsRepository {

    /**
     * Returns a Flow for the user name preference.
     */
    override fun getUsername(): Flow<String> =
        greetingsSharedPreferencesDataSource.getUsername()

    /**
     * Returns a Flow for the text color preference.
     */
    override fun getTextColor(): Flow<String> =
        greetingsSharedPreferencesDataSource.getTextColor()

    /**
     * Returns a Flow for the icon visibility preference.
     */
    override fun isIconVisible(): Flow<Boolean> =
        greetingsSharedPreferencesDataSource.isIconVisible()

}