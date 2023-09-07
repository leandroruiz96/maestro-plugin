package com.leandroleu96.github

import org.gradle.api.provider.Property

interface MaestroExtension {
    val testFolder: Property<String>
    val outputDir: Property<String>
    val fileName: Property<String>
}