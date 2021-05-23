package com.github.endless.lemniscate.daycounter.data.db

import androidx.room.*
import com.github.endless.lemniscate.daycounter.data.models.RoomWidget

@Dao
interface WidgetDao {

    @Transaction
    @Query("Select * from widget WHERE id=:id ")
    fun getWidgetById(id: Int): RoomWidget

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertWidget(widget: RoomWidget)

    @Delete
    suspend fun deleteWidget(widget: RoomWidget)
}