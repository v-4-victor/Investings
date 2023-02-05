plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.v4_victor.websocket"
}

dependencies {
    implementation("com.squareup.moshi:moshi-kotlin:1.11.0")
    implementation("org.java-websocket:Java-WebSocket:1.5.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.3")
}