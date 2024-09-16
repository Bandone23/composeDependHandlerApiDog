package com.example.doogs_datasource.data.repository

import com.example.doogs_datasource.data.remote.source.DogsDataSource

class DogsRepository(private val dataSource: DogsDataSource = DogsDataSource()) {

    suspend fun getRandomDogs() = dataSource.getRandomDogs()

}