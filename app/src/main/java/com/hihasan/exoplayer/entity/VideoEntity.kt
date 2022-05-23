package com.hihasan.exoplayer.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hihasan.exoplayer.constant.DatabaseConstants

@Entity(tableName = DatabaseConstants.TBL_VIDEO_LIST)
data class VideoEntity(
    @PrimaryKey(autoGenerate = true)
    val sl_no : Int,
    val video_name : String,
    val video_uri : String
)
