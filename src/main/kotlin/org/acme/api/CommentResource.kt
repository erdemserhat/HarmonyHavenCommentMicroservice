package org.acme.api

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.acme.dto.CommentRequest
import org.acme.service.CommentService
import org.acme.entities.Comment

@Path("/api/v1/comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CommentResource {

    @Inject
    lateinit var commentService: CommentService

    @GET
    @Path("/all12")
    fun getAllComments(): List<Comment> {
         println()
         return commentService.getAllComments()
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    @Path("/create")
    fun createComment(request: CommentRequest): Comment {
        val comment = Comment(
            authorId = request.authorId,
            quoteId = request.quoteId,
            commentContent = request.commentContent
        )
        return commentService.createComment(comment)
    }


    @DELETE
    @Path("/{id}")
    fun deleteComment(@PathParam("id") id: Long): String {
        return commentService.deleteComment(id)
    }

    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun testEndpoint(request: CommentRequest): CommentRequest {
        return request // Echo back the received request
    }
}
