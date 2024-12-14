package org.acme.entities

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.*
import java.io.Serializable
@Table(name = "liked_comments")
@Entity
data class LikedComment(
    @EmbeddedId
    var id: LikedCommentId = LikedCommentId(),
) : PanacheEntityBase(){

    @Embeddable
    data class LikedCommentId(
        @Column(name = "user_id", nullable = false)
        var userId: Int?=null,

        @Column(name = "comment_id", nullable = false)
        var commentId: Int?=null
    ) : Serializable

}

