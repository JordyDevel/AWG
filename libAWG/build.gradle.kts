import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    //id("org.jetbrains.dokka")
}

java {
    JavaVersion.VERSION_1_8.also {
        sourceCompatibility = it
        targetCompatibility = it
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        "1.8".also { jvmTarget = it }
    }
}