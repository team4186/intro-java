plugins {
  kotlin("jvm") version "1.5.31"
  id("org.jetbrains.compose") version "1.0.0-alpha4-build362"
  java
}

group = "frc4186"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  google()
}

dependencies {
  implementation(compose.desktop.currentOs)
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

compose.desktop {
  application {
    mainClass = "EntryPointKt"
  }
}

tasks.getByName<Test>("test") {
  useJUnitPlatform()
  systemProperties("java.util.logging.config.file" to "${project.buildDir}/resources/test/logging-test.properties")
  testLogging {
    showStandardStreams = true
  }
}

tasks.withType<JavaCompile> {
  options.encoding = "UTF-8"
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(15))
  }
}

tasks.getByName<Jar>("jar") {
  from(sourceSets.main.get().output)

  duplicatesStrategy = DuplicatesStrategy.WARN

  dependsOn(configurations.runtimeClasspath)
  from({
    configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
  })
}