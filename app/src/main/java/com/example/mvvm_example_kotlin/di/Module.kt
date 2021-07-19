package com.example.mvvm_example_kotlin.di

import androidx.room.Room
import com.example.mvvm_example_kotlin.model.AppDatabase
import com.example.mvvm_example_kotlin.remote.HeaderOfKakaoSearch
import com.example.mvvm_example_kotlin.remote.KakaoSearchService
import com.example.mvvm_example_kotlin.repository.KaKaoRepository
import com.example.mvvm_example_kotlin.repository.KakaoRepositoryImpl
import com.example.mvvm_example_kotlin.repository.SaveRepository
import com.example.mvvm_example_kotlin.repository.SaveRepositoryImpl
import com.example.mvvm_example_kotlin.viewmodel.MainViewModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofit = module {
    single<KakaoSearchService> {
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com/v2/search/")
            .client(OkHttpClient.Builder().addInterceptor(HeaderOfKakaoSearch()).build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(KakaoSearchService::class.java);
    }
}

val room = module {
    single{
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "save.db"
        ).build()
    }
    single {
        get<AppDatabase>().searchDao()
    }
}

val kakaoRepository = module{
    factory<KaKaoRepository> {
        KakaoRepositoryImpl(get())
    }
}

val saveRepository = module {
    factory<SaveRepository> {
        SaveRepositoryImpl(get())
    }
}

val mainViewModel = module {
    viewModel{
        MainViewModel(get(),get())
    }
}

val modules = listOf(retrofit, room ,kakaoRepository,saveRepository,mainViewModel)