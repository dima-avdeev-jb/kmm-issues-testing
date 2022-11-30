plugins {
  id("com.android.application")
  kotlin("android")
  id("kotlin-parcelize")
}

group "com.example"
version "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
//  implementation(project(":common"))

  implementation(Deps.Decompose.Decompose)
  implementation(Deps.Decompose.DecomposeComposeJetpack)
  implementation(Deps.Koin.Core)
  implementation(Deps.Koin.Android)
  implementation(Deps.MviKotlin.MviKotlin)
  implementation(Deps.MviKotlin.MviKotlinMain)

  implementation("androidx.activity:activity-compose:1.3.0")
  implementation("androidx.compose.material3:material3:1.1.0-alpha02")
}

android {
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.3.2"
  }
  compileSdkVersion(33)
  defaultConfig {
    applicationId = "com.example.android"
    minSdkVersion(24)
    targetSdkVersion(33)
    versionCode = 1
    versionName = "1.0-SNAPSHOT"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }
}