package com.stimednp.mvvmwithhilt.di

import com.stimednp.mvvmwithhilt.repositories.DataRepository
import com.stimednp.mvvmwithhilt.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 * Created by rivaldy on Oct/01/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun providesUseCase(dataRepository: DataRepository): DataUseCase{
        return DataUseCase(dataRepository)
    }
}