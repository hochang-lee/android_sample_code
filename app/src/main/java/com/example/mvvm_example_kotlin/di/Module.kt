package com.example.mvvm_example_kotlin.di

import androidx.room.Room
import com.example.mvvm_example_kotlin.data.db.AppDatabase
import com.example.mvvm_example_kotlin.data.api.HeaderOfKakaoSearch
import com.example.mvvm_example_kotlin.data.api.SearchApi
import com.example.mvvm_example_kotlin.data.respository.SearchRepository
import com.example.mvvm_example_kotlin.data.respository.SearchRepositoryImpl
import com.example.mvvm_example_kotlin.data.respository.SaveRepository
import com.example.mvvm_example_kotlin.data.respository.SaveRepositoryImpl
import com.example.mvvm_example_kotlin.presentation.main.MainViewModel
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofit = module {
    single<SearchApi> {
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com/v2/search/")
            .client(OkHttpClient.Builder().addInterceptor(HeaderOfKakaoSearch()).build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(SearchApi::class.java);
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
    factory<SearchRepository> {
        SearchRepositoryImpl(get())
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