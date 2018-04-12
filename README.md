# IntelliJ Lift plugin

# Installing the plugin
You can install this plugin using the [Jetbrains plugin repository](https://plugins.jetbrains.com/idea) or directly from 
IntelliJ. At the time of publishing of this plugin, the plugin is still pending confirmation from JetBrains, thus the direct
link cannot be provided just yet.

# Features
- Syntax highlighting;
- Error/warning highlighting;
- Code completion based on import statement;
- Colour settings page;
- Bracket matching and highlighting;

# How to build project
1. Clone this project;
1. Go to root of project and start sbt;
1. Run task `updateIdea` from the sbt console;
1. Run task `compile` from the sbt console;
1. Install/enable the following plugins in IntelliJ: Plugin Devkit, Grammar-Kit and PsiViewer;
1. Import this project as an sbt project in IntelliJ;
1. Be sure `JVM SDK` inside `Languages & Frameworks`>`Scala Compiler Server` is set to `1.8`, since the Scala compiler version (2.12.3) which this plugin is currently using is not compatible with Java 7 or lower, Java 9 is not yet supported;
1. Select `Build`>`Build Project`;


# How to prepare plugin for deployment
1. Right click on top of `intellij-lift.iml` inside `intellij-lift` folder;
1. Select `Import module`;
1. Be sure `unmanaged-jars` dependency is set to `provided` inside `Project structure`>`Project settings`>`Modules`>`Dependencies` (btw, setting `provided` inside sbt file gives error); 
1. Right click on top of `intellij-lift` plugin module and select `Prepare Plugin Module 'intellij-lift' for deployment`; 


# How to run/debug plugin inside IntelliJ
1. Set Plugin SDK settings right inside `Project structure`>`Platform settings`>`SDKs`. For example to, set  SDK home path to `idea/142.5239.7` inside project root folder;
1. Set `Module-SDK` right for `intellij-lift` plugin module inside `Project structure`>`Project structure`>`Project settings`>`Modules`; 
1. To run plugin inside IntelliJ, first run configuration has to be created. Navigate to `Run`>`Edit configurations` and create `plugin` configuration for `intellij-lift`;


# Development remarks
1. After making changes to `Lift.flex`, run `Run JFlex Generator`. This will generate `LiftLexer.java`;
1. After making changes to `Lift.bnf`, run `Generate Parser Code`. This will generate parser Java files in `gen` directory;
