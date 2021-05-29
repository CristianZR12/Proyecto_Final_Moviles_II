package edu.memento.thedogapi.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import edu.memento.thedogapi.retorfit.DogRetrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RetrofitModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideDogService(retrofit: Retrofit.Builder):DogRetrofit {
        return retrofit.build().create(DogRetrofit::class.java)
    }
}