package com.lottery.db.entity;

import java.io.Serializable;

public class BoardEntity implements Serializable {
    //
    private Integer boardId;

    //板块名称
    private String boardName;

    //板块描述
    private String boardDesc;

    //板块主题数
    private Integer topicNum;

    private static final long serialVersionUID = 1L;

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName == null ? null : boardName.trim();
    }

    public String getBoardDesc() {
        return boardDesc;
    }

    public void setBoardDesc(String boardDesc) {
        this.boardDesc = boardDesc == null ? null : boardDesc.trim();
    }

    public Integer getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(Integer topicNum) {
        this.topicNum = topicNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", boardId=").append(boardId);
        sb.append(", boardName=").append(boardName);
        sb.append(", boardDesc=").append(boardDesc);
        sb.append(", topicNum=").append(topicNum);
        sb.append("]");
        return sb.toString();
    }
}