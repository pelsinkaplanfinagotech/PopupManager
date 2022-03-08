package com.example.popupmanager

data class Response(
    val title: String,
    val content: String,
    val buttonList: List<Button>
)
