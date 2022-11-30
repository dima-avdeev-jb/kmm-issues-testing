plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
}

dependencies {
//    implementation("androidx.compose.material3:material3:1.0.1") // todo If we change material3 version to 1.0.1 - all will be fine!
    implementation("androidx.compose.material3:material3:1.1.0-alpha02")//comment this line

    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("com.arkivanov.decompose:decompose:1.0.0-beta-01")
    implementation("com.arkivanov.decompose:extensions-compose-jetpack:1.0.0-beta-01")
    implementation("com.arkivanov.mvikotlin:mvikotlin:3.0.2")
    implementation("com.arkivanov.mvikotlin:mvikotlin-main:3.0.2")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
