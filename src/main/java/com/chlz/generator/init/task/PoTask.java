package com.chlz.generator.init.task;

import com.chlz.generator.bean.TaskInfo;
import com.chlz.generator.init.task.base.AbstractTask;
import com.chlz.generator.utils.ConfigUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Po任务执行类
 */
public class PoTask extends AbstractTask {

    public PoTask(TaskInfo taskInfo) {
        super(taskInfo);
    }

    @Override
    public void run() {
        System.out.println("生成 " + taskInfo.getClassName() + ".java");
        Map<String, String> poData = new HashMap<>();
        poData.put("BasePackageName", ConfigUtil.getProjectConfig().getBasePackageName());
        poData.put("EntityPackageName", ConfigUtil.getCommonConfig().getPo());
        poData.put("Author", ConfigUtil.getProjectConfig().getAuthor());
        poData.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        poData.put("ClassName", taskInfo.getClassName());


    }

}
