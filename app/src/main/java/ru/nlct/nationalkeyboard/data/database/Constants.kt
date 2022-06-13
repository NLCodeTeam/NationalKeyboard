package ru.nlct.nationalkeyboard.data.database

import ru.nlct.nationalkeyboard.R
import ru.nlct.nationalkeyboard.domain.model.KeyboardLanguage

object Constants {
    const val DATABASE_NAME = "keyboard.db"
    const val VERSION = 1
    val LANGUAGES = listOf(
        KeyboardLanguage(R.xml.avar, "Аварский"),
        KeyboardLanguage(R.xml.qwerty_en,"Английский"),
        KeyboardLanguage(R.xml.dargin,"Даргинский"),
        KeyboardLanguage(R.xml.ingush, "Ингушский"),
        KeyboardLanguage(R.xml.circassian,"Кабардино-черкесский"),
        KeyboardLanguage(R.xml.balkarian, "Карачаево-балкарский"),
        KeyboardLanguage(R.xml.kumyk,"Кумыкский"),
        KeyboardLanguage(R.xml.lakian, "Лакский"),
        KeyboardLanguage(R.xml.lezginian, "Лезгинский"),
        KeyboardLanguage(R.xml.russian,"Русский"),
        KeyboardLanguage(R.xml.chechenian,  "Чеченский"),
        KeyboardLanguage(R.xml.osettian,"Осетинский")
    )
}
