plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.jvm.ktor)

}

android {
    namespace = "com.barissemerci.run.network"

}

dependencies {
    implementation(libs.bundles.koin)
    implementation(projects.core.data)
    implementation(projects.core.domain)

}