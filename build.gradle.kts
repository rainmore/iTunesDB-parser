import java.nio.file.Path
import org.gradle.api.tasks.wrapper.Wrapper

plugins {
    alias(libs.plugins.shadow) apply false
    alias(libs.plugins.git)

    id("idea")
    id("application")
}

group = "au.com.rainnore"
version = "1.2.8-a"
description = "iTunes DB"

val configDir: Path by extra(projectDir.toPath().resolve("project"))

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

tasks.named<Wrapper>("wrapper").configure {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = project.properties["gradleVersion"] as String
}

application {
    mainClass.set(listOf(project.group.toString(), "Main").joinToString("."))
}

configurations.all {
    exclude("org.apache.logging.log4j:*")
}

apply(from = configDir.resolve("utils.gradle"))
apply(from = configDir.resolve("assemble.gradle"))
apply(from = configDir.resolve("tests.gradle"))


dependencies {

    // logging
    implementation(libs.bundles.logging)
    implementation(libs.apache.commons.lang)

    // Test
    testImplementation(libs.bundles.junit)
}
