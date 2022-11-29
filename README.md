## Describle problem in Issue https://github.com/JetBrains/compose-jb/issues/2505

Pay attention to:
 - [build.gradle.kts](common%2Fbuild.gradle.kts) api("androidx.compose.material3...)
 - [App.kt](common%2Fsrc%2FcommonMain%2Fkotlin%2Fcom%2Fexample%2Fcommon%2FApp.kt)

I think Exception throws, because of early version of material3 ("androidx.compose.material3:material3:1.1.0-alpha02")  
If we change version to stable 1.0.1 - all will be fine.  

