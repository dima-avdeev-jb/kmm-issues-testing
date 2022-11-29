plugins {
  id("org.jetbrains.compose")
  id("com.android.application")
  kotlin("android")
}

group "com.example"
version "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":common"))

  implementation(Deps.Decompose.Decompose)
  implementation(Deps.Koin.Core)
  implementation(Deps.Koin.Android)
  implementation(Deps.MviKotlin.MviKotlin)
  implementation(Deps.MviKotlin.MviKotlinMain)

  implementation("androidx.activity:activity-compose:1.3.0")
}

android {
  buildFeatures {
    compose = true
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