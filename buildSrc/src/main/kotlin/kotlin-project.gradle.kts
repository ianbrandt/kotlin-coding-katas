import org.gradle.api.JavaVersion.VERSION_1_8
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	java
	kotlin("jvm")
}

dependencies {
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
}

java {
	sourceCompatibility = VERSION_1_8
	targetCompatibility = VERSION_1_8
}

tasks {

	withType<KotlinCompile>().configureEach {
		kotlinOptions.jvmTarget = VERSION_1_8.toString()
		kotlinOptions.freeCompilerArgs += "-Xinline-classes"
	}
}
