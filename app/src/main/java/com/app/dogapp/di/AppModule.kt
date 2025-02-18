package com.app.dogapp.di
import android.content.Context
import com.app.dogapp.data.local.MyPreferences
import com.app.dogapp.data.repository.DogRepository
import com.app.dogapp.domain.usecase.ClearCachedImagesUseCase
import com.app.dogapp.domain.usecase.FetchRandomDogImageUseCase
import com.app.dogapp.domain.usecase.GetCachedImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): MyPreferences {
        return MyPreferences(context)
    }

    @Provides
    @Singleton
    fun provideDogRepository(preferences: MyPreferences): DogRepository {
        return DogRepository(preferences)
    }

    @Provides
    @Singleton
    fun provideFetchRandomDogImageUseCase(repository: DogRepository): FetchRandomDogImageUseCase {
        return FetchRandomDogImageUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCachedImagesUseCase(repository: DogRepository): GetCachedImagesUseCase {
        return GetCachedImagesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideClearCachedImagesUseCase(repository: DogRepository): ClearCachedImagesUseCase {
        return ClearCachedImagesUseCase(repository)
    }
}