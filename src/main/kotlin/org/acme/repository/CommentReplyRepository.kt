package org.acme.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import org.acme.entities.CommentReply

@ApplicationScoped
class CommentReplyRepository : PanacheRepository<CommentReply>