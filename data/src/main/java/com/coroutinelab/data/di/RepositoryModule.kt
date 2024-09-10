package com.coroutinelab.data.di

import com.coroutinelab.data.repository.EmailRepositoryImpl
import com.coroutinelab.domain.repository.EmailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class  RepositoryModule {
    @Binds
    abstract fun bindUserRepository(emailRepositoryImpl: EmailRepositoryImpl): EmailRepository

}