package com.iparcoc.practivaivanpardal

import android.app.Application
import androidx.room.Room
import com.iparcoc.practivaivanpardal.database.TestDatabase

class QuestionAndAnswerApp: Application() {

    companion object {
        lateinit var database: TestDatabase
    }

    override fun onCreate() {
        super.onCreate()
        QuestionAndAnswerApp.database = Room.databaseBuilder(this, TestDatabase::class.java, "test-db").build()
    }
}