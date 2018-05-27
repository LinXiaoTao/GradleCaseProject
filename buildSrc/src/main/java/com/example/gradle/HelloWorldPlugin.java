package com.example.gradle;

import org.gradle.api.GradleException;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.function.Consumer;

/**
 * Created on 2018/5/19 下午1:18
 * leo linxiaotao1993@vip.qq.com
 */
public final class HelloWorldPlugin implements Plugin<Project> {

    private Logger mLogger;

    @Override
    public void apply(Project project) {

        mLogger = project.getLogger();

        project.getTasks().create("pluginHello", HelloWorld.class, helloWorld ->
                helloWorld.userName = "leo");

        project.getExtensions().create("hello", HelloModel.class, project);

        project.afterEvaluate(project1 -> {
            HelloModel helloModel = project1.getExtensions().getByType(HelloModel.class);
            mLogger.quiet("hello : " + helloModel);
            if (helloModel.getOutFile() == null || helloModel.getOutFile().isEmpty()) {
                throw new GradleException("outFile 不能等于空");
            }
            FileOutputStream fileOutputStream = null;
            try {
                File outFile = project1.file(helloModel.getOutFile());
                if (!outFile.exists()) {
                    outFile.createNewFile();
                }
                fileOutputStream = new FileOutputStream(outFile);
                StringBuilder otherString = new StringBuilder();
                helloModel.getOther().forEach(valueModel ->
                        otherString.append(valueModel.getName())
                                .append("：")
                                .append(valueModel.getValue())
                                .append("\n"));
                fileOutputStream.write(String.format(
                        Locale.getDefault(),
                        "Hello World\ncreate by %s %s\n%s",
                        helloModel.getInfo().getUsername(),
                        helloModel.getInfo().getEmail(),
                        otherString.toString()).getBytes()
                );
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
