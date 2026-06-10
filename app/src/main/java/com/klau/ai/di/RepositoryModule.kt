package com.klau.ai.di

import com.klau.ai.data.remote.GeminiProvider
import com.klau.ai.domain.repository.AIProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAIProvider(
        geminiProvider: GeminiProvider
    ): AIProvider
}
