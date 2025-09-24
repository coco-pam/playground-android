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

rootProject.name = "tabacco-spot-android-test"
include(":app")
include(":core")
include(":core:common")
include(":core:database")
include(":core:model")
include(":core:network")
include(":feature-auth")
include(":feature-favorite")
include(":feature-home")
include(":feature-list")
include(":feature-profile")
include(":ui")
