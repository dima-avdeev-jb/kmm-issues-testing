## Describle Issue https://github.com/JetBrains/compose-jb/issues/2505

Pay attention to:
 - [build.gradle.kts](android%2Fbuild.gradle.kts) implementation("androidx.compose.material3...)
 - [UserInterface.kt](android%2Fsrc%2Fmain%2Fjava%2Fcom%2Fexample%2Fandroid%2FUserInterface.kt)

I think Exception throws, because of early version of material3 ("androidx.compose.material3:material3:1.1.0-alpha02")  
If we change version to stable 1.0.1 - all will be fine.  

