package org.jetbinary.wali.model

data class DisplayText(
    val text: String,
    val accessibilityText: String = text
)