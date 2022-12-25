package com.iparcoc.practivaivanpardal.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TPregunta")
data class QuestionEntity (
    @PrimaryKey(autoGenerate = true)
    var idPregunta: Int = 0,
    var pregunta: String = "",
    var ficheroImagen: String = ""
)