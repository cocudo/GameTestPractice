package com.iparcoc.practivaivanpardal.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TRespuesta")
class AnswerEntity (
    @PrimaryKey(autoGenerate = true)
    var idRespuesta: Int = 0,
    var respuesta: String = "",
    var CodPregunta: String = "",
    var correcta: Boolean = false
 )