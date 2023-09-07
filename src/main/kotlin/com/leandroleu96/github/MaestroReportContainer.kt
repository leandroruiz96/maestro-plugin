package com.leandroleu96.github

import org.gradle.api.Task
import org.gradle.api.internal.CollectionCallbackActionDecorator
import org.gradle.api.reporting.ConfigurableReport
import org.gradle.api.reporting.internal.TaskReportContainer

class MaestroReportContainer(task: Task, collectionCallbackActionDecorator: CollectionCallbackActionDecorator): TaskReportContainer<ConfigurableReport>(
    ConfigurableReport::class.java,
    task,
    collectionCallbackActionDecorator
) {

}