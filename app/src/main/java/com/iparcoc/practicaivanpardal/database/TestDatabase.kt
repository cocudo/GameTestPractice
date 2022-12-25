package com.iparcoc.practivaivanpardal.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iparcoc.practivaivanpardal.database.dao.AnswerDao
import com.iparcoc.practivaivanpardal.database.dao.QuestionDao
import com.iparcoc.practivaivanpardal.database.entities.QuestionEntity
import com.iparcoc.practivaivanpardal.database.entities.AnswerEntity

@Database(entities = arrayOf(QuestionEntity::class, AnswerEntity::class), version = 1)
abstract class TestDatabase : RoomDatabase() {
    abstract fun QuestionDao(): QuestionDao
    abstract fun AnswerDao(): AnswerDao
}