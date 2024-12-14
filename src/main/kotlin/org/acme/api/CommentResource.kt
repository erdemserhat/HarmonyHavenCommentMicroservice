package org.acme.api

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.acme.dto.CommentRequest
import org.acme.service.CommentService
import org.acme.entities.Comment

@Path("/api/v1/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CommentResource {
    @Inject
    lateinit var commentService: CommentService

    //all comments
    @GET
    @Path("comments/all")
    fun getAllComments(): List<Comment> {
         println()
         return commentService.getAllComments()
    }

    //comments of quote
    @GET
    @Path("comments/{id}")
    fun getQuoteComments(@PathParam("id") id: Int): List<Comment> {
        return commentService.getQuoteComments(id)

    }


    //creates comments and comment replies
    //if comment is top level then specify it's parentCommentId as zero
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    @Path("comments")
    fun createComment(request: CommentRequest): Comment {
        //TODO EVALUATE COMMENT BEFORE ADDING
        val comment = Comment(
            authorId = request.authorId,
            quoteId = request.quoteId,
            commentContent = request.commentContent,
            parentCommentId = request.parentCommentId
        )
        return commentService.createComment(comment)
    }



    //delete comments
    @DELETE
    @Path("comments/{id}")
    fun deleteComment(@PathParam("id") id: Long): String {
        return commentService.deleteComment(id)
    }



}
