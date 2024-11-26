package com.barissemerci.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.barissemerci.core.database.entity.DeletedRunSycnEntity
import com.barissemerci.core.database.entity.RunPendingSyncEntity

@Dao
interface RunPendingSyncDao {

    //CREATED RUNS

    @Query("SELECT * FROM runpendingsyncentity WHERE userId = :userId")
    suspend fun getAllRunPendingSyncEntities(userId: String): List<RunPendingSyncEntity>

    @Query("SELECT * FROM runpendingsyncentity WHERE runId = :runId")
    suspend fun getRunPendingSyncEntity(runId: String): RunPendingSyncEntity?

    @Upsert
    suspend fun upsertRunPendingSyncEntity(entity: RunPendingSyncEntity)

    @Query("DELETE FROM runpendingsyncentity WHERE runId = :runId")
    suspend fun deleteRunPendingSyncEntity(runId: String)

    //DELETED RUNS
    @Query("SELECT * FROM deletedrunsycnentity WHERE userId = :userId")
    suspend fun getAllDeletedRunSyncEntities(userId: String): List<DeletedRunSycnEntity>

    @Upsert
    suspend fun upsertDeletedRunSyncEntity(entity: DeletedRunSycnEntity)

    @Query("DELETE FROM deletedrunsycnentity WHERE runId = :runId")
    suspend fun deleteDeletedRunSyncEntity(runId: String)

}