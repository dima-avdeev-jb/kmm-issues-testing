plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
  id("com.android.library")
  id("kotlin-parcelize")
}

group = "com.example"
version = "1.0-SNAPSHOT"

kotlin {
  android()
  jvm("desktop") {
    compilations.all {
      kotlinOptions.jvmTarget = "11"
    }
  }
  sourceSets {
    val commonMain by getting {
      dependencies {
        api(compose.runtime)
        api(compose.foundation)
        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
        api(compose.material3)

        api(Deps.Decompose.DecomposeComposeJetpack)


        implementation(Deps.Napier)
        implementation(Deps.Decompose.Decompose)
        implementation(Deps.MviKotlin.MviKotlin)
        implementation(Deps.MviKotlin.MviKotlinRx)
        implementation(Deps.MviKotlin.MviKotlinMain)
        implementation(Deps.MviKotlin.MviKotlinCoroutines)
        implementation(Deps.Koin.Core)
        implementation(Deps.Coroutines.Core)
      }
    }
    val androidMain by getting {
      dependencies {
        api("androidx.appcompat:appcompat:1.2.0")

        api("androidx.compose.material3:material3:1.1.0-alpha02")//comment this line
//        api("androidx.compose.material3:material3:1.0.1") // todo If we change material3 version to 1.0.1 - all will be fine!
      }
    }
  }
}

android {
  compileSdk = 33
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  defaultConfig {
    minSdk = 24
    targetSdk = 33
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}