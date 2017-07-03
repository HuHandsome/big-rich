package com.lottery.db.entity;

import java.io.Serializable;

public class BoardManagerEntityKey implements Serializable {
    //
    private Integer boardId;

    //
    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", boardId=").append(boardId);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}