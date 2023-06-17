rootProject.name = "itunes"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {

            version("plugin-git", "4.1.1")
            version("plugin-shadow", "8.1.1")

            // Dependencies: Logging
            version("slf4j", "2.0.7")
            version("logback", "1.4.7")

            version("apache-commons-lang", "3.12.0")

            version("junit", "5.9.3")
            version("jfairy", "0.6.5")
            version("mockito", "5.3.1")

            // Plugins
            plugin("git", "org.ajoberstar.grgit").versionRef("plugin-git")
            plugin("shadow", "com.github.johnrengelman.shadow").versionRef("plugin-shadow")

            // Logging
            library("slf4j-api", "org.slf4j", "slf4j-api").versionRef("slf4j")
            library("slf4j-log4j-over-slf4j", "org.slf4j", "log4j-over-slf4j").versionRef("slf4j")
            library("slf4j-jcl-over-slf4j", "org.slf4j", "jcl-over-slf4j").versionRef("slf4j")
            library("slf4j-nop", "org.slf4j", "slf4j-nop").versionRef("slf4j")
            library("logback-classic", "ch.qos.logback", "logback-classic").versionRef("logback")
            library("logback-core", "ch.qos.logback", "logback-core").versionRef("logback")


            library("apache-commons-lang", "org.apache.commons", "commons-lang3").versionRef("apache-commons-lang")

            // Test
            library("junit-jupiter-api", "org.junit.jupiter", "junit-jupiter-api").versionRef("junit")
            library("junit-jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
            library("mockito", "org.mockito", "mockito-core").versionRef("mockito")
            library("jfairy", "com.devskiller", "jfairy").versionRef("jfairy")

            // Bundles
            bundle("junit", listOf("junit-jupiter-api", "junit-jupiter-engine", "jfairy", "mockito"))
            bundle("logging", listOf("slf4j-api", "slf4j-log4j-over-slf4j", "slf4j-jcl-over-slf4j", "logback-classic", "logback-core"))
        }
    }
}
