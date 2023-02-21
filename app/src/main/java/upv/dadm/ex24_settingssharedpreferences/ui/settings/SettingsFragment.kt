/*
 * Copyright (c) 2022
 * David de Andrés and Juan Carlos Ruiz
 * Development of apps for mobile devices
 * Universitat Politècnica de València
 */

package upv.dadm.ex24_settingssharedpreferences.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import upv.dadm.ex24_settingssharedpreferences.R

/**
 * Displays an Android-like settings screen for managing
 * the user's preferences about the greetings screen.
 */
class SettingsFragment: PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // Create teh preferences hierarchy from the XML resource file
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }
}