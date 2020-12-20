import org.gradle.api.JavaVersion.VERSION_11
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	java
	kotlin("jvm")
}

dependencies {
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
}

java {
	sourceCompatibility = VERSION_11
	targetCompatibility = VERSION_11
}

tasks {

	withType<KotlinCompile>().configureEach {
		kotlinOptions.jvmTarget = VERSION_11.toString()
		kotlinOptions.freeCompilerArgs += "-Xinline-classes"
	}
}
