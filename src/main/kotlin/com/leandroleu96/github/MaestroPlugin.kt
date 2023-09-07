package com.leandroleu96.github

import org.gradle.api.Plugin
import org.gradle.api.Project

class MaestroPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create("maestro", MaestroExtension::class.java)
        target.tasks.register("maestroTests", MaestroTask::class.java) {
            it.maestroTestsDir.set(extension.testFolder)
            it.outputDir.set(extension.outputDir)
            it.fileName.set(extension.fileName)
        }
    }
}