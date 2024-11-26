package com.barissemerci.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DeletedRunSycnEntity(
    @PrimaryKey(autoGenerate = false)
    val runId: String,
    val userId: String
)
