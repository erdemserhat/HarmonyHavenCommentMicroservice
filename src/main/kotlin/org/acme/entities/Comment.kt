package org.acme.entities

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.*


@Entity
@Table(name = "comments")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "author_id", nullable = false)
    var authorId: Int? = null,

    @Column(name = "comment_id", nullable = false)
    var quoteId: Int? = null,

    @Column(name = "comment_content", nullable = false)
    var commentContent: String = "",

    @Column(name = "parent_comment_id", nullable = true)
    var parentCommentId: Int? = null

)
