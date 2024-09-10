import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

subprojects {
    apply<SpotlessPlugin>()
    configure<SpotlessExtension> {
        kotlin {
            target("src/**/*.kt")
            targetExclude("build/**/*.kt")
            ktlint()
                .editorConfigOverride(
                    mapOf(
                        "max_line_length" to "120",
                        "ij_kotlin_allow_trailing_comma" to "false",
                        "ktlint_standard_filename" to "disabled",
                        "ij_kotlin_allow_trailing_comma_on_call_site" to "false",
                        "ktlint_function_naming_ignore_when_annotated_with" to "Composable, Test"
                    )
                )

        }

        kotlinGradle {
            target("*.kts")
            ktlint()
        }
    }

    afterEvaluate {
        tasks.withType<KotlinCompile>(){
            finalizedBy("spotlessApply")
        }
    }
}
