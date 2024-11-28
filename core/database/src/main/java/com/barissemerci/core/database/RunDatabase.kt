package com.barissemerci.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.barissemerci.core.database.dao.AnalyticsDao
import com.barissemerci.core.database.dao.RunDao
import com.barissemerci.core.database.dao.RunPendingSyncDao
import com.barissemerci.core.database.entity.DeletedRunSycnEntity
import com.barissemerci.core.database.entity.RunEntity
import com.barissemerci.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [RunEntity::class, RunPendingSyncEntity::class, DeletedRunSycnEntity::class],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {
    abstract val runDao: RunDao
    abstract val analyticsDao: AnalyticsDao
    abstract val runPendingSyncDao: RunPendingSyncDao

}