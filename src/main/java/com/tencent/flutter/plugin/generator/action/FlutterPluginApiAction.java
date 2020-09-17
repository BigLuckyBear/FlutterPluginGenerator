package com.tencent.flutter.plugin.generator.action;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.tencent.flutter.plugin.generator.handler.BaseHandler;
import com.tencent.flutter.plugin.generator.handler.FlutterPluginApiHandler;

public class FlutterPluginApiAction extends BaseAction {

    @Override
    protected BaseHandler initHandler(Project project, DataContext dataContext) {
        return new FlutterPluginApiHandler(project, dataContext);
    }
}
