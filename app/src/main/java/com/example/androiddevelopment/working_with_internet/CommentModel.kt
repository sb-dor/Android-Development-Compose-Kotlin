package com.example.androiddevelopment.working_with_internet

class CommentModelModel(
    cPostId: Int? = null,
    cId: Int? = null,
    cName: String? = null,
    cEmail: String? = null,
    cBody: String? = null
) {
    val postId: Int? = cPostId
    val id: Int? = cId
    val name: String? = cName
    val email: String? = cEmail
    val body: String? = cBody
}