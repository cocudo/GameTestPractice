package com.iparcoc.practivaivanpardal.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.iparcoc.practivaivanpardal.database.entities.AnswerEntity

@Dao
interface AnswerDao {
    @Query("SELECT * FROM TRespuesta")
    fun getAllAnswers(): MutableList<AnswerEntity>
    @Insert
    fun addAnswer(answerEntity: AnswerEntity):Long
}