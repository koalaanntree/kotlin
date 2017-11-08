
apply { plugin("kotlin") }

dependencies {
    testCompile(commonDep("junit:junit"))
    testCompile(projectDist(":kotlin-test:kotlin-test-jvm"))
    testCompile(projectDist(":kotlin-test:kotlin-test-junit"))
    testCompile(project(":core"))
    testCompile(project(":compiler:util"))
    testCompile(project(":compiler:backend"))
    testCompile(project(":compiler:frontend"))
    testCompile(project(":compiler:frontend.java"))
    testCompile(project(":compiler:cli"))
    testCompile(project(":compiler:serialization"))
    testCompile(ideaSdkDeps("openapi", "idea", "util", "asm-all"))
    // deps below are test runtime deps, but made test compile to split compilation and running to reduce mem req
    testCompile(projectDist(":kotlin-stdlib"))
    testCompile(projectDist(":kotlin-script-runtime"))
    testCompile(projectDist(":kotlin-reflect"))
    testCompile(projectTests(":compiler"))
    testCompile(projectTests(":compiler:tests-common"))
    testCompile(projectTests(":generators:test-generator"))
    testRuntime(projectRuntimeJar(":kotlin-preloader"))
    testRuntime(preloadedDeps("dx", subdir = "android-5.0/lib"))
    testRuntime(ideaSdkCoreDeps("*.jar"))
    testRuntime(ideaSdkDeps("*.jar"))
}

sourceSets {
    "main" { }
    "test" { projectDefault() }
}

projectTest {
    workingDir = rootDir
}
