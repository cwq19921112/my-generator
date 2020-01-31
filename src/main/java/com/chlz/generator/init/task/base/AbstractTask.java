package com.chlz.generator.init.task.base;

import com.chlz.generator.bean.TaskInfo;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Serializable;

/**
 * 任务抽象类
 */
public abstract class AbstractTask implements Serializable {

    protected TaskInfo taskInfo;

    public AbstractTask(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    public abstract void run() throws IOException, TemplateException;

    public TaskInfo getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }
}
