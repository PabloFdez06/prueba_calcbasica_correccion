plugins {
    kotlin("jvm") version "2.0.20"
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application {
    mainClass.set("org.example.MainKt")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}

tasks.named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
    archiveBaseName.set("PruebaCalc") // Nombre del jar final
    archiveVersion.set("1.0")
    archiveClassifier.set("")

    mergeServiceFiles()
    exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA") // Evita errores de firma
}