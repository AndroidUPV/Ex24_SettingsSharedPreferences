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

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Data source that provides access to SharedPreferences to get the user's preferences
 * about the greetings screen.
 * It implements the GreetingsSharedPreferencesDataSource interface.
 */
class GreetingsSharedPreferencesDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : GreetingsSharedPreferencesDataSource {

    // Constant defining the preferences keys
    private object PreferenceKeys {
        const val USER_NAME = "prefs_username"
        const val TEXT_COLOR = "prefs_color"
        const val ICON_VISIBILITY = "prefs_isIconVisible"
    }

    /**
     * Returns the user name preference.
     */
    private fun getUserNamePreference() =
        sharedPreferences.getString(PreferenceKeys.USER_NAME, "") ?: ""

    /**
     * Returns the text color preference.
     */
    private fun getTextColorPreference() =
        sharedPreferences.getString(PreferenceKeys.TEXT_COLOR, "") ?: ""

    /**
     * Returns the icon visibility preference.
     */
    private fun isIconVisiblePreference() =
        sharedPreferences.getBoolean(PreferenceKeys.ICON_VISIBILITY, true)

    /**
     * Returns a Flow for the user name preference.
     */
    override fun getUsername(): Flow<String> = callbackFlow {
        // Define the listener that will be executed whenever a Preference changes its value
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if (PreferenceKeys.USER_NAME == key) {
                    // Send the updated value for the desired Preference
                    trySend(getUserNamePreference())
                }
            }
        }
        // Register the listener
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        // Send an initial value
        trySend(getUserNamePreference())
        // Unregister the listener when the channel is closed or cancelled
        awaitClose { sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener) }
    }
        // Operations must be moved to an IO optimised thread
        .flowOn(Dispatchers.IO)

    /**
     * Returns a Flow for the text color preference.
     */
    override fun getTextColor(): Flow<String> = callbackFlow {
        // Define the listener that will be executed whenever a Preference changes its value
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if (PreferenceKeys.TEXT_COLOR == key) {
                    // Send the updated value for the desired Preference
                    trySend(getTextColorPreference())
                }
            }
        }
        // Register the listener
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        // Send an initial value
        trySend(getTextColorPreference())
        // Unregister the listener when the channel is closed or cancelled
        awaitClose { sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener) }
    }
        // Operations must be moved to an IO optimised thread
        .flowOn(Dispatchers.IO)

    /**
     * Returns a Flow for the icon visibility preference.
     */
    override fun isIconVisible(): Flow<Boolean> = callbackFlow {
        // Define the listener that will be executed whenever a Preference changes its value
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if (PreferenceKeys.ICON_VISIBILITY == key) {
                    // Send the updated value for the desired Preference
                    trySend(isIconVisiblePreference())
                }
            }
        }
        // Register the listener
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        // Send an initial value
        trySend(isIconVisiblePreference())
        // Unregister the listener when the channel is closed or cancelled
        awaitClose { sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener) }
    }
        // Operations must be moved to an IO optimised thread
        .flowOn(Dispatchers.IO)
}