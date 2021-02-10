plugins {
	`kotlin-dsl`
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
}

kotlinDslPluginOptions {
	experimentalWarning.set(false)
}
