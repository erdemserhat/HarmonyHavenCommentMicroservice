package org.acme.data

import io.quarkus.hibernate.orm.panache.PanacheEntity
import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import jakarta.persistence.*
import java.util.Date


@Entity
@Table(name = "comments")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var authorId: Int? = null,
    var quoteId: Int? = null,

    var commentContent: String = "",

    @OneToMany(mappedBy = "parentComment", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    var replies: MutableList<CommentReply> = mutableListOf()
) : PanacheEntityBase()