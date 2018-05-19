package com.example.gradle;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Created on 2018/5/19 下午1:18
 * leo linxiaotao1993@vip.qq.com
 */
public final class HelloWorldPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().create("pluginHello", HelloWorld.class, helloWorld ->
                helloWorld.userName = "leo");
    }
}
