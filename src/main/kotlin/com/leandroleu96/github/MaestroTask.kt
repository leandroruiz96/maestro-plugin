package com.leandroleu96.github

import groovy.lang.Closure
import org.gradle.api.DefaultTask
import org.gradle.api.internal.CollectionCallbackActionDecorator
import org.gradle.api.provider.Property
import org.gradle.api.reporting.Reporting
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import java.io.OutputStream
import javax.inject.Inject


abstract class MaestroTask: DefaultTask() {

    @get:Inject
    abstract val execOperations: ExecOperations

    @get:Input
    abstract val maestroTestsDir: Property<String>

    @get:Input
    abstract val outputDir: Property<String>

    @get:Input
    abstract val fileName: Property<String>

    @TaskAction
    fun executeCommand() {
        println("Building directory: ${outputDir.get()}")
        execOperations.exec {
            it.commandLine("mkdir", "-p", outputDir.get())
            it.standardOutput = OutputStream.nullOutputStream()
        }
        println("Running tests...")
        execOperations.exec {
            it.commandLine(
                "maestro", "test",
                "--format", "junit",
                maestroTestsDir.get(),
                "--output", outputDir.get() + fileName.get()
            )
            it.isIgnoreExitValue = true
            it.standardOutput = OutputStream.nullOutputStream()
        }
        println("Report generated at: ${outputDir.get() + fileName.get()}")
    }

}