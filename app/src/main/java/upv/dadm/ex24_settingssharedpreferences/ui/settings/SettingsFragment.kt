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
        // Create the preferences hierarchy from the XML resource file
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }
}