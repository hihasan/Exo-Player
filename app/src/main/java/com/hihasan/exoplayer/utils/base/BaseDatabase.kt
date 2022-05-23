package com.hihasan.exoplayer.utils.base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.hihasan.exoplayer.constant.DatabaseConstants

@Database(
    entities = [

    ],
    version = DatabaseConstants.DATABASE_VERSION,
)

abstract class BaseDatabase : RoomDatabase() {


    companion object {
        private var INSTANCE: BaseDatabase? = null

        fun getDatabase(ctx: Context): BaseDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        ctx, BaseDatabase::class.java, DatabaseConstants.DATABASE_NAME
                    ).build()
                }
            }

            return INSTANCE!!
        }
    }


}