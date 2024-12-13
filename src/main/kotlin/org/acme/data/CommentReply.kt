package org.acme.data

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.*

@Entity
@Table(name = "comment_replies")

data class CommentReply(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var authorId: Int? = null,

    var commentContent: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    var parentComment: Comment? = null
) : PanacheEntityBase()