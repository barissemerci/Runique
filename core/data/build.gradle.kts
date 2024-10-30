plugins {
    alias(libs.plugins.runique.android.library)

}

android {
    namespace = "com.barissemerci.core.database"


}

dependencies {
    implementation(libs.timber)
    implementation(projects.core.domain)
    implementation(projects.core.database)
}