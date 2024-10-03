import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
	id("org.springframework.boot") version "2.7.6"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.21"
	kotlin("plugin.spring") version "1.7.21"

	/**
	 * detekt
	 *
	 * URL
	 * - https://github.com/detekt/detekt
	 * GradlePlugins(plugins.gradle.org)
	 * - https://plugins.gradle.org/plugin/io.gitlab.arturbosch.detekt
	 * Main 用途
	 * - Linter/Formatter
	 * Sub 用途
	 * - 無し
	 * 概要
	 * KotlinのLinter/Formatter
	 */
	id("io.gitlab.arturbosch.detekt").version("1.22.0")

	/**
	 * dokka
	 *
	 * URL
	 * - https://github.com/Kotlin/dokka
	 * GradlePlugins(plugins.gradle.org)
	 * - https://plugins.gradle.org/plugin/org.jetbrains.dokka
	 * Main 用途
	 * - ドキュメント生成ツール
	 * Sub 用途
	 * - 無し
	 * 概要
	 * Kotlin のドキュメント生成ツール
	 */
	id("org.jetbrains.dokka") version "1.7.20"

	/**
	 * openapi.generator
	 *
	 * 公式ページ
	 * - https://openapi-generator.tech/
	 * GradlePlugins(plugins.gradle.org)
	 * - https://plugins.gradle.org/plugin/org.openapi.generator
	 * GitHub
	 * - https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin
	 * Main用途
	 * - スキーマファイルからコード生成
	 * Sub用途
	 * - スキーマファイルからドキュメント生成
	 * 概要
	 * - スキーマ駆動開発するために使う
	 * - API仕様をスキーマファイル(yaml)に書いて、コード生成し、それを利用するようにする
	 * - 可能な限りプロダクトコードに依存しないようにする(生成したコードにプロダクトコードを依存させる)
	 */
	id("org.openapi.generator") version "6.2.0"
}

group = "dev.sunabak0"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	/**
	 * detektの拡張: detekt-formatting
	 *
	 * 概要
	 * - formattingのルール
	 * - 基本はktlintと同じ
	 * - format自動適用オプションの autoCorrect が使えるようになる
	 */
	detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")

	/**
	 * Swagger Annotations
	 * Swagger Models
	 * Jakarta Annotations API
	 *
	 * MavenCentral
	 * - https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-annotations
	 * - https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-models
	 * - https://mvnrepository.com/artifact/jakarta.annotation/jakarta.annotation-api
	 * Main用途
	 * - OpenAPI Generatorで作成されるコードで利用
	 * Sub用途
	 * - 無し
	 * 概要
	 * - OpenAPI Generatorで作成されるコードがimportしている
	 * - 基本的にプロダクションコードでは使わない想定
	 */
	compileOnly("io.swagger.core.v3:swagger-annotations:2.2.25")
	compileOnly("io.swagger.core.v3:swagger-models:2.2.6")
	compileOnly("jakarta.annotation:jakarta.annotation-api:2.1.1")

	/**
	 * Spring Boot Starter Validation
	 *
	 * MavenCentral
	 * - https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation
	 * Main用途
	 * - OpenAPI Generatorで作成されるコードで利用
	 * Sub用途
	 * - 無し
	 * 概要
	 * - OpenAPI Generatorで作成されるコードがimportしている
	 * - javax.validation*を利用するため
	 * [Spring-Boot-2.3ではjavax.validationを依存関係に追加しなければならない](https://qiita.com/tatetsujitomorrow/items/a397c311a95d66e4f955)
	 */
	implementation("org.springframework.boot:spring-boot-starter-validation")

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
	testImplementation("org.assertj:assertj-core:3.23.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

/**
 * detekt の設定
 *
 * 基本的に全て `detekt-override.yml` で設定する
 */
detekt {
	/**
	 * ./gradlew detektGenerateConfig で detekt.yml が生成される(バージョンが上がる度に再生成する)
	 */
	config = files(
		"$projectDir/config/detekt/detekt.yml",
		"$projectDir/config/detekt/detekt-override.yml",
	)
}

/**
 * OpenAPI Generator を使ってコード生成
 */
task<GenerateTask>("generateApiServer") {
	generatorName.set("kotlin-spring")
	inputSpec.set("$projectDir/akiyadego-openapi/openapi.yml")
	outputDir.set("$buildDir/openapi/server-code/") // .gitignoreされているので注意(わざとここにあります)
	apiPackage.set("dev.sunabak0.akiyadego.openapi.generated.controller")
	modelPackage.set("dev.sunabak0.akiyadego.openapi.generated.model")
	configOptions.set(
		mapOf(
			"interfaceOnly" to "true",
		)
	)
	/**
	 * true にすると tags 準拠で、API の interface を生成する
	 */
	additionalProperties.set(
		mapOf(
			"useTags" to "true"
		)
	)
}

/**
 * Kotlinをコンパイルする前に、generateApiServerタスクを実行
 * 必ずスキーマファイルから最新のコードが生成され、もし変更があったらコンパイル時に失敗して気付けるため
 */
tasks.compileKotlin {
	dependsOn("generateApiServer")
}

/**
 * OpenAPI Generator によって生成されたコードを import できるようにする
 */
kotlin.sourceSets.main {
	kotlin.srcDir("$buildDir/openapi/server-code/src/main")
}
