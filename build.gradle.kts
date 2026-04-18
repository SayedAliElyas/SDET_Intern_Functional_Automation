plugins {
    kotlin("jvm") version "2.3.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"
val jbStarterVersion = "243.26574.91"

repositories {
    mavenCentral()
    maven(url = "https://cache-redirector.jetbrains.com/intellij-dependencies")
    maven(url = "https://www.jetbrains.com/intellij-repository/releases")
    maven(url = "https://download.jetbrains.com/teamcity-repository")
    maven(url = "https://cache-redirector.jetbrains.com/packages.jetbrains.team/maven/p/grazi/grazie-platform-public")
}

dependencies {
    // Starter + Driver (REQUIRED)
    testImplementation("com.jetbrains.intellij.tools:ide-starter-squashed:$jbStarterVersion")
    testImplementation("com.jetbrains.intellij.tools:ide-starter-junit5:$jbStarterVersion")
    testImplementation("com.jetbrains.intellij.tools:ide-starter-driver:$jbStarterVersion")
    testImplementation("com.jetbrains.intellij.driver:driver-client:$jbStarterVersion")
    testImplementation("com.jetbrains.intellij.driver:driver-sdk:$jbStarterVersion")
    testImplementation("com.jetbrains.intellij.driver:driver-model:$jbStarterVersion")

    // JUnit (REQUIRED)
    val junitBom = platform("org.junit:junit-bom:5.12.2")
    testImplementation(junitBom)
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
