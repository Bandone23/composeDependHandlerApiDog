package com.example.doogs_datasource.data.repository

import com.example.doogs_datasource.data.remote.source.DogsDataSource
import javax.inject.Inject

class DogsRepository @Inject constructor(private val dataSource: DogsDataSource) {

    suspend fun getRandomDogs() = dataSource.getRandomDogs()

}