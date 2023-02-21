/*
 * Copyright (c) 2022
 * David de Andrés and Juan Carlos Ruiz
 * Development of apps for mobile devices
 * Universitat Politècnica de València
 */

package upv.dadm.ex24_settingssharedpreferences.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import upv.dadm.ex24_settingssharedpreferences.data.greetings.GreetingsRepository
import upv.dadm.ex24_settingssharedpreferences.data.greetings.GreetingsRepositoryImpl
import upv.dadm.ex24_settingssharedpreferences.data.greetings.GreetingsSharedPreferencesDataSource
import upv.dadm.ex24_settingssharedpreferences.data.greetings.GreetingsSharedPreferencesDataSourceImpl
import javax.inject.Singleton

/**
 * Hilt module that determines how to provide required dependencies for interfaces.
 */
@Module
// The Hilt annotation @SingletonComponent creates and destroy instances following the lifecycle of the Application
@InstallIn(SingletonComponent::class)
abstract class GreetingsBinderModule {

    /**
     * Provides an instance of a GreetingsSharedPreferencesDataSource.
     */
    @Binds
    @Singleton
    abstract fun bindGreetingsSharedPreferencesDataSource(
        greetingsSharedPreferencesDataSourceImpl: GreetingsSharedPreferencesDataSourceImpl
    ): GreetingsSharedPreferencesDataSource

    /**
     * Provides an instance of a GreetingsRepository.
     */
    @Binds
    @Singleton
    abstract fun bindGreetingsRepository(
        greetingsRepositoryImpl: GreetingsRepositoryImpl
    ): GreetingsRepository
}