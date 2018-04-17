package com.logmaster.api.request;


import java.io.Serializable;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/12/01.
 */

public class BaseTaskRequest implements Serializable {

    private static final long serialVersionUID = 4969557030971162163L;

    private String taskId;

    private String taskStep;

    private String creator;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskStep() {
        return taskStep;
    }

    public void setTaskStep(String taskStep) {
        this.taskStep = taskStep;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
