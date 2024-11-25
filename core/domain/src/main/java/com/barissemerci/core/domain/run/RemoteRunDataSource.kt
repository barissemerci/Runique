package com.barissemerci.core.domain.run

import com.barissemerci.core.domain.util.DataError
import com.barissemerci.core.domain.util.EmptyDataResult
import com.barissemerci.core.domain.util.Result

interface RemoteRunDataSource {
    suspend fun getRuns(): Result<List<Run>, DataError.Network>
    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>
    suspend fun deleteRun(id: String): EmptyDataResult<DataError.Network>
}