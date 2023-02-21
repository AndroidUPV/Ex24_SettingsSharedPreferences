/*
 * Copyright (c) 2022
 * David de Andrés and Juan Carlos Ruiz
 * Development of apps for mobile devices
 * Universitat Politècnica de València
 */

package upv.dadm.ex24_settingssharedpreferences

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Custom Application required for Hilt to inject dependencies.
 * The Manifest must declare it: <application android:name = ".SettingsSharedPreferencesApplication"/>
 */
// The Hilt annotation @HiltAndroidApp identifies this class as the dependency container
@HiltAndroidApp
class SettingsSharedPreferencesApplication : Application()