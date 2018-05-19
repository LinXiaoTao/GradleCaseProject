package com.example.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

/**
 * Created on 2018/5/19 下午1:06
 * leo linxiaotao1993@vip.qq.com
 */
public class HelloWorld extends DefaultTask {


    public String userName;

    @TaskAction
    public void run() {
        System.out.println("Hello World，" + userName);
    }
}
