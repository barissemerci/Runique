package com.barissemerci.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.barissemerci.core.database.entity.RunEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {
    @Upsert
    suspend fun upsertRun(run: RunEntity)

    @Upsert
    suspend fun upsertRuns(runs: List<RunEntity>)

    @Query("SELECT * FROM runEntity ORDER BY dateTimeUtc DESC")
    fun getRuns() : Flow<List<RunEntity>> //it is not suspend function because it returns a flow

    @Query("DELETE FROM runEntity WHERE id = :id")
    suspend fun deleteRun(id: String)

    @Query("DELETE FROM runEntity")
    suspend fun deleteAllRuns()

}