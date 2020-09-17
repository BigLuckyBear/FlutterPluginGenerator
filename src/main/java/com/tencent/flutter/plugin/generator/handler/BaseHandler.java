package com.tencent.flutter.plugin.generator.handler;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;

public abstract class BaseHandler {

    protected final Project mProject;
    protected final DataContext mDataContext;

    public BaseHandler(Project project, DataContext dataContext) {
        mProject = project;
        mDataContext = dataContext;
    }

    public abstract void process();
}
