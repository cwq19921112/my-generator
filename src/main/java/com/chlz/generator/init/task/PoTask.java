package com.chlz.generator.init.task;

import com.chlz.generator.bean.ColumnInfo;
import com.chlz.generator.bean.TaskInfo;
import com.chlz.generator.config.CommonConfig;
import com.chlz.generator.config.ProjectConfig;
import com.chlz.generator.enums.TemplateTypeEnum;
import com.chlz.generator.init.task.base.AbstractTask;
import com.chlz.generator.utils.ConfigUtil;
import com.chlz.generator.utils.FileUtil;
import com.chlz.generator.utils.GeneratorUtil;
import com.chlz.generator.utils.PathUtil;
import freemarker.template.TemplateException;
import freemarker.template.utility.StringUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Po任务执行类
 */
public class PoTask extends AbstractTask {

    public PoTask(TaskInfo taskInfo) {
        super(taskInfo);
    }

    @Override
    public void run() throws IOException, TemplateException {
        String className = taskInfo.getClassName();
        System.out.println("生成 " + className + ".java");
        Map<String, String> poData = new HashMap<>();
        ProjectConfig projectConfig = ConfigUtil.getProjectConfig();
        CommonConfig commonConfig = ConfigUtil.getCommonConfig();

        poData.put("BasePackageName", projectConfig.getBasePackageName());
        poData.put("PoPackageName", commonConfig.getPo());
        poData.put("Author", projectConfig.getAuthor());
        poData.put("Date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        poData.put("ClassName", className);

        List<ColumnInfo> columnInfos = taskInfo.getColumnInfos();
        poData.put("Properties", GeneratorUtil.generatePoProperties(columnInfos));
        poData.put("Methods", GeneratorUtil.generatePoMethods(columnInfos));

        String projectSaveDir = projectConfig.getProjectSaveDir();
        String basePackagePath = PathUtil.package2Path(projectConfig.getBasePackageName());
        String poPackagePath = PathUtil.package2Path(commonConfig.getPo());
        String fileName = className + ".java";

        String filePath = PathUtil.appendPath(projectSaveDir, basePackagePath, poPackagePath);
        // 生成Po文件
        FileUtil.generateToJava(TemplateTypeEnum.PO, poData, filePath + fileName);
    }

}
