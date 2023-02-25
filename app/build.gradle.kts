import org.gradle.api.JavaVersion.VERSION_19

plugins {
    kotlin("jvm") version "1.8.10"
}

configure<JavaPluginExtension> {
    sourceCompatibility = VERSION_19
    targetCompatibility = VERSION_19
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.guava:guava:31.1-jre")

    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "18"
    }
}
