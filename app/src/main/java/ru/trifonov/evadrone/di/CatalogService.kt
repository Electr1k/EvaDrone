package ru.trifonov.evadrone.di

import android.annotation.SuppressLint
import android.content.Context
import ru.trifonov.evadrone.repository.ComponentsRepositoryImpl

class CatalogService private constructor(context: Context): ComponentsRepositoryImpl(context){


    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: CatalogService? = null

        fun getInstance(context: Context): CatalogService {
            return instance ?: synchronized(this) {
                instance ?: CatalogService(context).also { instance = it }
            }
        }
    }


}