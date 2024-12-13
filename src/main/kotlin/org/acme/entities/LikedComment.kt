package org.acme.entities

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable
@Table(name = "liked_comments")
@Entity
data class LikedComment(
    @EmbeddedId
    var id: LikedCommentId = LikedCommentId(),
) : PanacheEntityBase()

@Embeddable
data class LikedCommentId(
    var userId: Int?=null,
    var commentId: Int?=null
) : Serializable