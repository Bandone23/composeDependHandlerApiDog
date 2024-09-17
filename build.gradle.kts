buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.hiltAgp)

    }
}
    plugins {

        id("com.google.dagger.hilt.android") version "2.41" apply false // Versión actualizada de Hilt
    }