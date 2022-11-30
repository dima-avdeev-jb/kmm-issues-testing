// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
pluginManagement {
  repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
  }

  plugins {
    kotlin("multiplatform").version(extra["kotlin.version"] as String)
    kotlin("android").version(extra["kotlin.version"] as String)
    id("com.android.application").version(extra["agp.version"] as String)
  }
}

rootProject.name = "kmm-issues-testing"

include(":android")
