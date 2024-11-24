pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS") // <- Add this line

rootProject.name = "WeatherApp"
include(":app")
include(":core")
include(":data")
include(":data:main")
include(":core:network")
include(":feature")
include(":feature:main")
include(":core:ui")
include(":core:common")
include(":core:resource")
include(":domain:main")
