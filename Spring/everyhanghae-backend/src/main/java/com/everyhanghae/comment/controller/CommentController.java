package com.everyhanghae.comment.controller;

import com.everyhanghae.comment.dto.RequestComment;
import com.everyhanghae.comment.dto.ResponseComment;
import com.everyhanghae.comment.service.CommentService;
import com.everyhanghae.common.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.everyhanghae.common.response.ResponseMessage.CREATE_COMMENT_SUCCESS_MSG;
import static com.everyhanghae.common.response.ResponseMessage.UPDATE_COMMENT_SUCCESS_MSG;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards/{boardId}/comment")
public class CommentController {
    private final CommentService commentService;

    //댓글 작성
    @PostMapping
    public DataResponse<ResponseComment> writeComment(@PathVariable Long boardId, @RequestBody RequestComment requestDto) {
        ResponseComment commentResponseDto = commentService.createComment(boardId, requestDto);
        return new DataResponse<>(CREATE_COMMENT_SUCCESS_MSG, commentResponseDto);
    }

    //댓글 수정
    @PutMapping("/{commentId}")
    public DataResponse<ResponseComment> editComment(@PathVariable Long boardId, @PathVariable Long commentId, @RequestBody RequestComment requestDto){
        ResponseComment commentResponseDto = commentService.editComment(boardId, commentId, requestDto);
        return new DataResponse<>(UPDATE_COMMENT_SUCCESS_MSG, commentResponseDto);
    }

}