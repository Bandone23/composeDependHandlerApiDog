import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {

    const val coreKtx ="androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycleruntimektx  = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    const val activityCompose  = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeBom  = "androidx.compose:compose-bom:${Versions.composeBom}"


    const val junitVersion  = "androidx.test.ext:junit:${Versions.junitVersion}"
    const val espressoCore  = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val junit  = "junit:junit:${Versions.junit}"

    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val coild = "io.coil-kt:coil-compose:${Versions.coild}"
}


fun DependencyHandler.androidtest(){
    implementation(Dependencies.junitVersion)
    implementation(Dependencies.espressoCore)
    implementation(Dependencies.junit)
}



fun DependencyHandler.androidxReferences(){
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleruntimektx)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.composeBom)
}


fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
    implementation(Dependencies.retrofitGson)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    debugImplementation(Dependencies.composeUiToolingPreview)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.coild(){
    implementation(Dependencies.coild)
}

fun DependencyHandler.doogsDataSource() {
    implementation(project(":doogs-datasource"))
}

fun DependencyHandler.doogsUi() {
    implementation(project(":doogs-ui"))
}
