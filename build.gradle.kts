plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
}

repositories {
    // Required to download KtLint
    mavenCentral()
}

group = "me.bossm0n5t3r"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(libs.kotlin.test.junit5)
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.assertj.core)
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

ktlint {
    version.set(
        libs.versions.ktlint.version
            .get(),
    )
}
