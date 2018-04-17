package com.logmaster.api.request;


/**
 * @param <T> t
 * @author wanglu
 * @Description:
 * @Date: 2017/11/30.
 */

public class TaskRequest<T> {
    /**
     * 任务类型id.
     */
    private String processName;
    /**
     * 任务类型ID.
     */
    private Integer taskTypeId;
    /**
     * 任务名称.
     */
    private String taskName;
    /**
     * 任务名称.
     */
    private Integer subGroupId;
    /**
     * 任务备注信息.
     */
    private String taskComment;
    /**
     * META类型.
     */
    private String metaType;
    /**
     * METAID.
     */
    private Integer metaId;
    /**
     * auditStatus.
     */
    private Integer auditStatus;
    /**
     * taskId.
     */
    private String taskId;
    /**
     * submitStatus.
     */
    private Integer submitStatus;
    /**
     * 驳回人.
     */
    private String rejector;

    private T entity;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getSubGroupId() {
        return subGroupId;
    }

    public void setSubGroupId(Integer subGroupId) {
        this.subGroupId = subGroupId;
    }

    public String getTaskComment() {
        return taskComment;
    }

    public void setTaskComment(String taskComment) {
        this.taskComment = taskComment;
    }

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }

    public Integer getMetaId() {
        return metaId;
    }

    public void setMetaId(Integer metaId) {
        this.metaId = metaId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(Integer submitStatus) {
        this.submitStatus = submitStatus;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getRejector() {
        return rejector;
    }

    public void setRejector(String rejector) {
        this.rejector = rejector;
    }
}
