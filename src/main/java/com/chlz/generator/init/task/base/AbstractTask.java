package com.chlz.generator.init.task.base;

import com.chlz.generator.bean.TaskInfoDto;

import java.io.Serializable;

/**
 * 任务抽象类
 */
public abstract class AbstractTask implements Serializable {

    protected TaskInfoDto taskInfoDto;

    public AbstractTask(TaskInfoDto taskInfoDto) {
        this.taskInfoDto = taskInfoDto;
    }

    public abstract void run();

    public TaskInfoDto getTaskInfoDto() {
        return taskInfoDto;
    }

    public void setTaskInfoDto(TaskInfoDto taskInfoDto) {
        this.taskInfoDto = taskInfoDto;
    }
}
