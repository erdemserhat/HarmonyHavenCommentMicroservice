package org.acme.data

import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CommentRepository : PanacheRepository<Comment>

@ApplicationScoped
class CommentReplyRepository : PanacheRepository<CommentReply>

@ApplicationScoped
class LikedCommentRepository : PanacheRepository<LikedComment>
