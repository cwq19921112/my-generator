package com.chlz.generator.init.task;

import com.chlz.generator.bean.TaskInfoDto;
import com.chlz.generator.init.task.base.AbstractTask;

/**
 * Po任务执行类
 */
public class PoTask extends AbstractTask {

    public PoTask(TaskInfoDto taskInfoDto) {
        super(taskInfoDto);
    }

    @Override
    public void run() {
        System.out.println("生成 " + taskInfoDto.getClassName() + ".java");
    }

}
