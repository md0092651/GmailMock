import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.org.jetbrains.kotlin.kapt) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.spotless) apply false
}
val ktLintVersion = libs.versions.ktlint.get()

subprojects {
    apply<SpotlessPlugin>()
    configure<SpotlessExtension> {
        kotlin {
            target("src/**/*.kt")
            targetExclude("build/**/*.kt")
            ktlint()
        }

        kotlinGradle {
            target("*.kts")
            ktlint()
        }
    }
}
