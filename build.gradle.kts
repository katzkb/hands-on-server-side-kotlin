plugins {
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"

    kotlin("jvm") version "2.0.21"
    kotlin("plugin.spring") version "1.9.25"

    /**
     * detekt
     *
     * URL
     * - https://github.com/detekt/detekt
     * GradlePlugins(plugins.gradle.org)
     * - https://plugins.gradle.org/plugin/io.gitlab.arturbosch.detekt
     * Main用途
     * - Linter/Formatter
     * Sub用途
     * - 無し
     * 概要
     * KotlinのLinter/Formatter
     */
    id("io.gitlab.arturbosch.detekt") version "1.23.8"

    /**
     * dokka
     *
     * URL
     * - https://github.com/Kotlin/dokka
     * GradlePlugins(plugins.gradle.org)
     * - https://plugins.gradle.org/plugin/org.jetbrains.dokka
     * Main用途
     * - ドキュメント生成
     * Sub用途
     * - 特になし
     * 概要
     * - JDocの代替(=KDoc)
     */
    id("org.jetbrains.dokka") version "2.0.0"

    /**
     * springdoc
     *
     * URL
     * - https://springdoc.org/
     * Main 用途
     * - OpenAPI 仕様に基づいたドキュメントを生成する
     * Sub 用途
     * - なし
     * 概要
     * コードから OpenAPI 仕様に基づいたドキュメントの生成ライブラリ
     */
    id("org.springdoc.openapi-gradle-plugin") version "1.9.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
        vendor.set(JvmVendorSpec.AMAZON)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    /**
     * detektの拡張: detekt-formatting
     *
     * 概要
     * - formattingのルール
     * - 基本はktlintと同じ
     * - format自動適用オプションの autoCorrect が使えるようになる
     */
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.8")

    /**
     * dokkaHtmlPlugin
     *
     * dokka Pluginを適用するのに必要
     */
    dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:2.0.0")

    /**
     * Arrow Core
     *
     * URL
     * - https://arrow-kt.io/
     * MavenCentral
     * - https://mvnrepository.com/artifact/io.arrow-kt/arrow-core
     * Main用途
     * - Either/Validatedを使ったRailway Oriented Programming
     * Sub用途
     * - Optionを使ったletの代替
     * 概要
     * - Kotlinで関数型プログラミングをするときに便利なライブラリ
     */
    implementation("io.arrow-kt:arrow-core:2.1.2")

    /**
     * AssertJ
     *
     * URL
     * - https://assertj.github.io/doc/
     * MavenCentral
     * - https://mvnrepository.com/artifact/org.assertj/assertj-core
     * Main用途
     * - JUnitでassertThat(xxx).isEqualTo(yyy)みたいな感じで比較時に使う
     * Sub用途
     * - 特になし
     * 概要
     * - JUnit等を直感的に利用するためのライブラリ
     */
    testImplementation("org.assertj:assertj-core:3.27.3")

    /**
     * jqwik
     *
     * URL
     * - https://jqwik.net/
     * MavenCentral
     * - https://mvnrepository.com/artifact/net.jqwik/jqwik
     * - https://mvnrepository.com/artifact/net.jqwik/jqwik-kotlin
     * Main用途
     * - Property Based Testing(pbt)
     * 概要
     * - Property Based Testingをするのに便利なライブラリ
     * 参考
     * - https://medium.com/criteo-engineering/introduction-to-property-based-testing-f5236229d237
     * - https://johanneslink.net/property-based-testing-in-kotlin/#jqwiks-kotlin-support
     */
    testImplementation("net.jqwik:jqwik:1.9.3")
    testImplementation("net.jqwik:jqwik-kotlin:1.9.3")

    /**
     * Spring Boot Starter Validation
     *
     * MavenCentral
     * - https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation
     * Main用途
     * - コントローラーのバリデーションのために利用する
     * Sub用途
     * - 無し
     * 概要
     * - Validation を実装した際に、本ライブラリがなければ、バリデーションが動作しない
     */
    implementation("org.springframework.boot:spring-boot-starter-validation")

    /**
     * springdoc の gradle 拡張
     *
     * 概要
     * - CLI から springdoc を利用して OpenAPI を 生成する
     */
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.9")

    /**
     * Spring JDBC
     *
     * URL
     * - https://spring.pleiades.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/package-summary.html
     * MavenCentral
     * - https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jdbc
     * Main用途
     * - DBへ保存
     * 概要
     * - 特になし
     *
     * これを入れるだけで、application.properties/yamlや@ConfigurationによるDB接続設定が必要になる
     */
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    /**
     * postgresql
     *
     * URL
     * - https://jdbc.postgresql.org/
     * MavenCentral
     * - https://mvnrepository.com/artifact/org.postgresql/postgresql
     * Main用途
     * - DBつなぐ時のドライバ
     * 概要
     * - 特になし
     */
    implementation("org.postgresql:postgresql")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

/**
 * Dokka Jackson依存関係競合の回避策
 *
 * 問題: Spring Boot 3.5.4のJacksonバージョンとDokka 2.0.0が期待するJacksonが競合
 * エラー: 'void com.fasterxml.jackson.databind.type.TypeFactory.<init>(com.fasterxml.jackson.databind.util.LRUMap)'
 * 解決策: Dokka関連の設定でのみJackson 2.15.3を使用する
 * 参考: https://github.com/Kotlin/dokka/issues/3472
 */
configurations.matching { it.name.startsWith("dokka") }.configureEach {
    resolutionStrategy.eachDependency {
        if (requested.group.startsWith("com.fasterxml.jackson")) {
            useVersion("2.15.3")
        }
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.test {
    useJUnitPlatform()
}

/**
 * detektの設定
 *
 * 基本的に全て `detekt-override.yml` で設定する
 */
detekt {
    /**
     * ./gradlew detektGenerateConfig でdetekt.ymlが生成される(バージョンが上がる度に再生成する)
     */
    config.setFrom(
        "$projectDir/config/detekt/detekt.yml",
        "$projectDir/config/detekt/detekt-override.yml",
    )
}

springBoot {
//  mainClass.set("com.example.server.handsOn.HandsOnServerSideKotlinApplicationKt")
    mainClass.set("com.example.server.crud.ApplicationKt")
}

openApi {
    apiDocsUrl.set("http://localhost:8080/v3/api-docs.yaml")
    outputDir.set(project.layout.buildDirectory.dir("springdoc"))
    outputFileName.set("openapi.yaml")
}
