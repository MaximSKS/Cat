// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.googleDevtoolsKsp) apply false
    alias(libs.plugins.androidxRoom) apply false
//    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
//    id("androidx.room") version "2.6.1" apply false

}