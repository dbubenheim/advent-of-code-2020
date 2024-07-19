plugins {
    kotlin("jvm") version "1.8.20"
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of("19"))
    }
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.25")

    implementation("com.google.guava:guava:31.1-jre")

    testImplementation(kotlin("test"))
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
}
