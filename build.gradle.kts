plugins {
  kotlin("jvm") version "2.2.0"
  kotlin("plugin.spring") version "1.9.25"
  id("org.springframework.boot") version "3.5.4"
  id("io.spring.dependency-management") version "1.1.7"
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(24))
    vendor.set(JvmVendorSpec.AMAZON)
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-jdbc")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  runtimeOnly("org.postgresql:postgresql")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
  compilerOptions {
    freeCompilerArgs.addAll("-Xjsr305=strict")
  }
}

tasks.test {
  useJUnitPlatform()
}

springBoot {
  mainClass.set("com.example.handsOnServerSideKotlin.HandsOnServerSideKotlinApplicationKt")
}
