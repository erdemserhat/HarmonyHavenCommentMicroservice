package org.acme.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class CommentRequest @JsonCreator constructor(
    @JsonProperty("authorId") var authorId: Int = 0,
    @JsonProperty("quoteId") var quoteId: Int = 0,
    @JsonProperty("commentContent") var commentContent: String = "",
    @JsonProperty("parentCommentId") var parentCommentId: Int = 0,
)