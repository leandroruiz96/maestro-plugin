import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    id("maven-publish")
    id("java-gradle-plugin")
}

group = "com.leandroleu96.github"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

gradlePlugin {
    plugins {
        create("maestro-plugin") {
            id = "com.leandroleu96.github.maestro"
            implementationClass = "com.leandroleu96.github.MaestroPlugin"
            description = "Plugin for running maestro tests"
            displayName = "Maestro Tests Plugin"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maestroPlugin") {
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
    }
}


tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}