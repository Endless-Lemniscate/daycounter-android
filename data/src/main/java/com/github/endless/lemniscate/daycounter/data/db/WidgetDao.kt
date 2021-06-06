package com.github.endless.lemniscate.daycounter.data.db

import androidx.room.*
import com.github.endless.lemniscate.daycounter.data.models.RoomWidget
import kotlinx.coroutines.flow.Flow

@Dao
interface WidgetDao {

    @Query("Select * from widget")
    fun getAllWidgets(): Flow<List<RoomWidget>>

    @Transaction
    @Query("Select * from widget WHERE id=:id ")
    fun getWidgetById(id: Int): RoomWidget

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertWidget(widget: RoomWidget)

    @Delete
    suspend fun deleteWidget(widget: RoomWidget)
}