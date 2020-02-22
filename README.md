
# **__ATTENTION: THIS REPO IS NOW DEPRECATED!!!__**
# **__SEE [Mario-AI-Framework](https://github.com/peter201943/Mario-AI-Framework) FOR NEW PROJECT__**

---------


## CS 387: Game AI


---------


# README


## About
 - **Project**
     - HW3: Mario Behavior Trees
 - **Student**
     - Peter J. Mangelsdorf
     - pjm349@drexel.edu
     - 717-385-7068
 - **Professor**
     - Ehsan Khosroshahi
     - eb452@drexel.edu
 - **Contents**
     - [About](#about)
     - [Links](#links)
     - [Additions](#additions)
     - [Progress](#progress)
     - [Design](#design)


## Links
 - [README](README.md)      -- Pertains to anything I _directly_ did
 - [Notes](Notes.md)        -- Pertains to my understanding and development of the project
 - [Behavior](behavior.py)  -- Prototype of Project in Python


---------


## Additions


### Structure
```
.
└── src
    └── ch
        └── idsia
            └── competition
                └── peter
                    ├── BasicTasks
                    │   ├── Task.java               // Abstract             -- Run() returns Action([bool])
                    │   ├── Composite.java          // Task                 -- [Children]
                    │   ├── Do.java                 // Composite            -- Run() visits each child until one returns FAIL
                    │   ├── Choose.java             // Composite            -- Run() visits each child until one returns PASS
                    │   ├── ChooseRandomly.java     // Choose               -- Do one child randomly
                    │   ├── Action.java             // Task                 -- Do a thing to the external environment
                    │   └── Condition.java          // Task                 -- Get a thing from the external environment
                    ├── MarioTasks
                    │   ├── RunRight.java           // Action               -- Returns Right and Run
                    │   ├── Jump.java               // Action               -- Returns Jump
                    │   ├── AttackJump.java         // Action               -- Returns Jump/Right commands to kill an enemy
                    │   ├── Wait.java               // Action               -- Returns [bool] of no action
                    │   ├── EnemyInRange.java       // Condition            -- Can we step/jump on an enemy?
                    │   └── EnemiesClose.java       // Condition            -- Do we need to worry?
                    ├── Trees
                    │   ├── Tree.java               // Abstract             -- Builds a Tree from Tasks, Points to the Root, has Run()
                    │   └── ForwardJump.java        // Tree                 -- Run Right and Jump
                    ├── Agents
                    │   ├── BTAgent.java            // Interface            -- Tree, Run() -> [bool]]
                    │   └── MarioBTAgent.java       // BasicMarioAIAgent    -- Uses Regular Mario Agent and BT Functionality
                    └── Helpers
                        ├── Print.java              // Interface            -- Print(depth, name, status)
                        └── Status.java             // Class                -- Running, Pass, Fail (Just data)
```


### Status
 folder     | name              | progress
------------|-------------------|----------
 Agents     | BTAgent           | ---
 .          | MarioBTAgent      | ---
 .          | .                 | .
 BasicTasks | Action            | ---
 .          | Choose            | ---
 .          | ChooseRandomly    | ---
 .          | Composite         | ---
 .          | Condition         | ---
 .          | Do                | ---
 .          | Task              | ---
 .          | .                 | .
 Helpers    | Print             | ---
 .          | Status            | ---
 .          | .                 | .
 MarioTasks | AttackJump        | ---
 .          | EnemiesClose      | ---
 .          | EnemyInRange      | ---
 .          | Jump              | ---
 .          | RunRight          | ---
 .          | Wait              | ---
 .          | .                 | .
 Trees      | ForwardJump       | ---
 .          | Tree              | ---


---------


## Progress


### Chapter 1: Getting this to Work
 - Got all these damn notes done
 - Did a crud-ton of reading
 - Now to get the damn thing to run
 - Nothing works
 - IntelliJ just deleted EVERYTHING I did
 - Using a different editor now
 - [Running and Debugging Java](https://code.visualstudio.com/docs/java/java-debugging)
 - Which JDK to Install?
     - `1.8` - compatibility
     - `11` - another class
     - `13` - latest edition
 - Installing all Java Related files into: `C:\Program Files\Java`
 - Something about the `.jar` files is wrong
 - Run this File: `src/ch/idsia/scenarios/Custom.java`
 - Oh great. I'm getting exactly _612_ errors. _WHY_.
     - Apparently `jdom` is needed: http://jdom.org/
     - And `testng` and a billion other things.
     - What is this `org` namespace?!?!?
     - Nevermind, I'm gonna regex and delete any references of it
     - No time for this nonsense
 - https://github.com/redhat-developer/vscode-java/issues/346
 - https://stackoverflow.com/questions/50232557/visual-studio-code-java-extension-howto-add-jar-to-classpath
 - https://github.com/leonardost/kifu-recorder-tests/commit/c09792b08e9a0e44ad1d4f0ccad8d55d8af0084a
 - And now I also need a _proper_ build system in order to load the `.jar`'s properly. _uuuggghhhhhh_
     - https://maven.apache.org/download.cgi
 - FINALLY!
 - Ughhh. Great, down from `618` bugs to _only_ `371`.
 - Seems related to `testng`. Was NOT included as a library.
 - Strat 1: Delete _ALL_ references to `testng`.
 - Offending Files:
     - `CmdLineOptionsTest.java`
     - `LevelGeneratorTest.java`
     - `LevelSceneTest.java`
     - `MarioAIBenchmarkTest.java`
     - `MarioEnvironmentTest.java`
 - Commenting failed. There are more conflicts than just `testng`
 - Add `gradle` to properly specify dependencies
 - Gradle installed, maven not working
 - https://stackoverflow.com/questions/18487406/how-do-i-tell-gradle-to-use-specific-jdk-version#21212790
 - Now to set the freaking compatibility for this thing
 - https://stackoverflow.com/questions/11364761/how-do-i-compile-a-java-with-support-for-older-versions-of-java
 - I have no idea how to do any of this
 - How about we just DELETE these classes:
     - AccessTest.java
     - Util.java
 - No, can't. Can't even tell how many files may or may not use these.
     - attempting to `grep` for usages of `AccessTest`, this will take a long time (584 files)
         - No results (too many files)
 - Plan B? D? Z? (How many of these stupid attempts at compatibility have borne no fruit?)
 - Download and attempt it in Eclipse
     - Wow.
     - It. Just. Works...
     - I hate everything, and most of all, Java.
 - Spent some more time debugging. Guess what?
     - I could have selected `proceed over errors` at ***ANY TIME***
     - I hate this
     - I hate ALL of this...
 - Getting the Agent to Launch
     - https://code.visualstudio.com/docs/cpp/launch-json-reference
     - Need to set the arguments to `-ag` when launching
 - Nothing works
     - Nothing. Nothing at all.
     - I hate everything. Did I mention that?
     - I'm going to find another Java Mario Project, one that works.
 - Alternative Mario Projects:
     - [Refactored Competition AI](https://github.com/kefik/MarioAI)
         - Someone took the exact same code and refactored it into readable, clean Java
         - It still suffers from the same problems, namely, that I cannot load an agent
     - [Anniversary Edition AI](https://github.com/amidos2006/Mario-AI-Framework)
         - This looks very different from the other two
         - But it actually works...
         - And the code has no errors...
         - And the agents are super easy to load and launch.
         - I am going to use this one.


### Chapter 2: Hiring an Agent
 - Potential Agents to Hire:
     - `C:\Users\Standard Access\Peter\School\College\3 - Junior\CS 387\Projects\HW 3\src\competition\gic2010\turing\sergeykarakovskiy\SergeyKarakovskiy_ForwardAgent.java`
     - `C:\Users\Standard Access\Peter\School\College\3 - Junior\CS 387\Projects\HW 3\src\competition\gic2010\gameplay\sergeykarakovskiy\SergeyKarakovskiy_ForwardAgent.java`
     - `C:\Users\Standard Access\Peter\School\College\3 - Junior\CS 387\Projects\HW 3\src\ch\idsia\agents\controllers\ForwardAgent.java`
 - Plan:
     - Study `ForwardAgent.java`
     - Redesign `ForwardAgent` in terms of Behavior Trees
     - Implement only the required Behavior Trees
     - Test this new framework/agent


### Chapter 3: Adding our First Task
 - I'm gonna cry, I haven't even touched this yet.
 - The game just WONT COMPILE


---------


## Design
 - Didn't have time to write an XML/YAML parser
 - This is the logic:


### Current
```yaml
# Forward Jump
root:
    choose:
        do:
            enemiesClose?
            choose:
                do:
                    enemyInRange?
                    attackJump!
                wait!
        chooseRandomly:
            jump!
            runRight!
```
 - If enemies capable of attacking, wait and step on them
 - otherwise, run right and jump (get lucky)


### Alternative
 - Treat Conditions as Containers, too
 - Decorators!
```yaml
# Forward Jump
root:
    either:
        enemiesClose?
            either:
                enemyInRange?
                    attackJump!
                wait!
        randomlyEither:
            jump!
            runRight!
```


---------

