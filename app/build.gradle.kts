import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

    id("com.google.gms.google-services")
}


android {
    namespace = "app.agro.samruddhi"
    compileSdk = 34


    defaultConfig {
        applicationId = "app.agro.samruddhi"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }


    }

    val properties = readLocalProperties()
    buildTypes {
        debug {
            val localProperties = Properties()
            buildConfigField("String", "apikey",  "\"${properties.getProperty("apikey")}\"")

        }
        release {
            buildConfigField("String", "apikey",  "\"${properties.getProperty("apikey")}\"")

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )


        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }


    buildFeatures {
        compose = true
        buildConfig= true

    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Compose Bom
    implementation(platform(libs.compose.bom))

    // Compose
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    // UI
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)

    // Material
    implementation(libs.material3)
    implementation(libs.androidx.material3)

    //material for icons
    implementation ("androidx.compose.material:material-icons-core:1.7.0-alpha02")
    implementation ("androidx.compose.material:material-icons-extended:1.7.0-alpha02")
    implementation ("androidx.compose.material:material:1.7.0-alpha07")
    implementation("androidx.compose.material:material:1.6.6")


    // Accompanist
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.accompanist.navigation.animation)
    implementation(libs.accompanist.permissions)

    // Coil
    implementation(libs.coil.compose)

    //Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.0-alpha01")

    // dagger hilt
    implementation(libs.hilt.android)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.play.services.auth)
    implementation(platform(libs.compose.bom))
    androidTestImplementation(platform(libs.compose.bom))
    kapt(libs.hilt.compiler)

    // hilt navigation compose
    implementation(libs.androidx.hilt.navigation.compose)

    // Material Icons Extended
    implementation(libs.androidx.material.icons.extended)

    //lottieCompose
    implementation(libs.lottie.compose)

    // DataStore
    implementation(libs.androidx.datastore.preferences)

    //pager(autoslider)
    implementation ("com.google.accompanist:accompanist-pager:0.28.0")


    // Room
    val room_version = "2.5.1"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")


    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)



    //for chatAI
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")



    //genai
    implementation("com.google.ai.client.generativeai:generativeai:0.2.0")
}




fun readLocalProperties(): java.util.Properties {

    return  Properties().apply {
        load(rootProject.file("local.properties").reader())
    }
}
