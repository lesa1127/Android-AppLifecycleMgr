package com.hm.iou.lifecycle.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AppLifecyclePlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        println "------LifeCycle plugin entrance-------"
        try {
            def android = project.extensions.getByType(AppExtension)
            android.registerTransform(new AppLifecycleTransform(project))
        }catch (Throwable ignored){
            def android = project.extensions.getByType(LibraryExtension)
            android.registerTransform(new AppLifecycleTransform(project))
        }
    }

}
