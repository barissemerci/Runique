plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.android.room)

}

android {
    namespace = "com.barissemerci.analytics.data"


}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.analytics.domain)
    implementation(libs.bundles.koin)
}