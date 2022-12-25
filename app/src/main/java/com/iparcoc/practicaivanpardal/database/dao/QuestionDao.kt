package com.iparcoc.practivaivanpardal.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.iparcoc.practivaivanpardal.database.entities.QuestionEntity

@Dao
interface QuestionDao {
    @Query("SELECT * FROM TPregunta")
    fun getAllQuestions(): MutableList<QuestionEntity>
    @Insert
    fun addQuestion(questionEntity: QuestionEntity):Long
}