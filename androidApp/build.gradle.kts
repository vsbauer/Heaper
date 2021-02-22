plugins {
    id("com.android.application")
    kotlin("android")
}

group = "com.vsbauer"
version = "1.0"


dependencies {
    val mviKotlinVersion = "2.0.1"

    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    implementation("com.arkivanov.mvikotlin:mvikotlin:$mviKotlinVersion")
    implementation("com.arkivanov.mvikotlin:mvikotlin-main:$mviKotlinVersion")
    implementation("com.arkivanov.mvikotlin:mvikotlin-logging:$mviKotlinVersion")
    implementation("com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:$mviKotlinVersion")

    implementation ("androidx.compose.compiler:compiler:1.0.0-alpha12")
    implementation ("androidx.compose.ui:ui:1.0.0-alpha12")
    implementation ("androidx.compose.ui:ui-tooling:1.0.0-alpha12")
    implementation ("androidx.compose.foundation:foundation:1.0.0-alpha12")
    implementation ("androidx.compose.material:material:1.0.0-alpha12")

}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.vsbauer.heaper"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    composeOptions {
        kotlinCompilerVersion = "1.4.30"
        kotlinCompilerExtensionVersion = "1.0.0-alpha12"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

