package com.tencent.flutter.plugin.generator.handler;

import com.intellij.codeInsight.completion.AllClassesGetter;
import com.intellij.codeInsight.completion.PlainPrefixMatcher;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.Processor;
import com.sun.istack.NotNull;

import java.util.HashMap;

public class FlutterPluginApiHandler extends BaseHandler {

    HashMap<PsiClass, PsiMethod> scanResult = new HashMap<>();

    public FlutterPluginApiHandler(Project project, DataContext dataContext) {
        super(project, dataContext);
    }

    @Override
    public void process() {
        // todo step 1: scan whole project

        Processor<PsiClass> process = new Processor<PsiClass>() {

            @Override
            public boolean process(PsiClass psiClass) {
                System.out.println("class is " + psiClass.getQualifiedName());
                PsiMethod[] methods = psiClass.getMethods();
                for (PsiMethod method: methods) {
                    if (method.getModifierList().getAnnotations().length > 0) {

                        for (PsiAnnotation annotation : method.getAnnotations()) {
                            if (NotNull.class.getName().equals(annotation.getQualifiedName())) {
                                System.out.println("method is " + method.getName());
                                scanResult.put(psiClass, method);
                            }
                        }
                    }
                }
                return true;
            }
        };

        AllClassesGetter.processJavaClasses(new PlainPrefixMatcher(""), mProject, GlobalSearchScope.projectScope(mProject), process);



        // todo step 2: create flutter plugin
        // todo step 3: generate native api
    }
}
