group "com.example"
version "1.0-SNAPSHOT"

allprojects {
  repositories {
    google()
    mavenCentral()
  }
}

plugins {
  kotlin("multiplatform") apply false
  kotlin("android") apply false
  id("com.android.application") apply false
}