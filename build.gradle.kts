plugins {
    kotlin("jvm") version "2.0.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.microutils:kotlin-logging:2.0.10")
    implementation("ch.qos.logback:logback-classic:1.4.12")

    implementation("com.github.ajalt.clikt:clikt:5.0.0")


    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")  // JUnit 5 test engine

    testImplementation("org.xerial:sqlite-jdbc:3.41.2.2")
}

application {
    mainClass.set("org.expense.MainKt")
}

tasks.test {
    useJUnitPlatform()
}