plugins {
    kotlin("jvm") version "2.0.20"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
}

repositories {
    // Required to download KtLint
    mavenCentral()
}

group = "me.bossm0n5t3r"
version = "1.0-SNAPSHOT"

private val junitVersion = "5.11.0"
private val assertJVersion = "3.26.3"

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

ktlint {
    version.set("1.3.1")
}
