// Build.gradle.kts feito em sala de aula
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.41"
    application
}

version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("io.javalin:javalin:3.5.0")
    compile("ch.qos.logback:logback-classic:1.2.3")
    compile("com.fasterxml.jackson.core:jackson-databind:2.10.0")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "GatoAppKt"
}
