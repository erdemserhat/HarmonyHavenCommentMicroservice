package org.acme.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.acme.entities.Comment
import org.acme.data.CommentRepository

@ApplicationScoped
class CommentService(private val commentRepository: CommentRepository) {

    fun getAllComments(): List<Comment> {
        return commentRepository.listAll()
    }

    @Transactional
    fun createComment(comment: Comment): Comment {
        commentRepository.persist(comment)
        return comment
    }

    fun findCommentById(id: Long): Comment? {
        return commentRepository.findById(id)
    }

    @Transactional
    fun deleteComment(id: Long): String {
        return if (commentRepository.deleteById(id)) {
            "Comment deleted successfully"
        } else {
            "Comment not found"
        }
    }
}