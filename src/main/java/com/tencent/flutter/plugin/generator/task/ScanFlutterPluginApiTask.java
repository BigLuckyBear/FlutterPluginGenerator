package com.tencent.flutter.plugin.generator.task;


import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;

public class ScanFlutterPluginApiTask implements Runnable {

    final Project mProject;

    public ScanFlutterPluginApiTask(Project project) {
        mProject = project;
    }

    @Override
    public void run() {
        mProject.getProjectFile();
    }

}
