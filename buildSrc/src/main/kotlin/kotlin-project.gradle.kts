import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm")
}

dependencies {
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
}

java {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

tasks {

	withType<KotlinCompile>().configureEach {
		with(kotlinOptions) {
			useIR = true
			jvmTarget = JavaVersion.VERSION_11.toString()
			freeCompilerArgs = freeCompilerArgs + "-Xinline-classes"
		}
	}
}
