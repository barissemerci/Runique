plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.barissemerci.analytics.presentation"

}

dependencies {
    implementation(projects.analytics.domain)

}