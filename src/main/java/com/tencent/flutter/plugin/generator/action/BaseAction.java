package com.tencent.flutter.plugin.generator.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.tencent.flutter.plugin.generator.handler.BaseHandler;
import org.jetbrains.annotations.NotNull;

public abstract class BaseAction extends AnAction {

    protected abstract BaseHandler initHandler(Project project, DataContext dataContext);

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Project project = e.getProject();
        final DataContext dataContext = e.getDataContext();

        final BaseHandler handler = initHandler(project, dataContext);

        // 交由各个handler进行对应的处理
        handler.process();
    }
}
