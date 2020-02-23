

## CS 387: Game AI


---------


# README


## About
 - **Project**
     - HW3: Mario Behavior Trees
 - **Student**
     - Peter J. Mangelsdorf
     - pjm349
 - **Professor**
     - Ehsan Khosroshahi
     - eb452
 - **Contents**
     - [About](#about)
     - [Links](#links)
     - [Additions](#additions)
     - [Progress](#progress)
     - [Agent Design](#agent-design)
     - [Video Demonstration](#video-demonstration)


## Links
 - [README](README.md)      -- Pertains to anything I _directly_ did
 - [Notes](Notes.md)        -- Pertains to my understanding and development of the project
 - [Behavior](behavior.py)  -- Prototype of Project in Python


---------


## Additions


### Structure
```
./
└── src/
    └── agents/
        └── peterMangelsdorf/
            ├── Helpers/
            │   ├── Status.java             // Class                -- Values, String, Checks
            │   ├── Win.java                // Status               -- Represents a Win
            │   ├── Fail.java               // Status               -- Represents a Fail
            │   └── Running.java            // Status               -- Represents still Running
            ├── BasicTasks/
            │   ├── Task.java               // Abstract             -- Run() returns Action([bool])
            │   ├── Composite.java          // Task                 -- [Children]
            │   ├── Do.java                 // Composite            -- Run() visits each child until one returns FAIL
            │   ├── Choose.java             // Composite            -- Run() visits each child until one returns PASS
            │   ├── Action.java             // Task                 -- Do a thing to the external environment
            │   └── Condition.java          // Task                 -- Get a thing from the external environment
            ├── MarioTasks/
            │   ├── Wait.java               // Action               -- Returns [bool] of no action
            │   ├── Jump.java               // Action               -- Returns Jump
            │   ├── RunRight.java           // Action               -- Returns Right and Run
            │   ├── RightRunJump.java       // Action               -- Returns Right and Run and Jump
            │   ├── AttackJump.java         // Action               -- Returns Jump/Right commands to kill an enemy
            │   ├── Stopped.java            // Condition            -- Measure speed of Mario
            │   ├── EnemiesClose.java       // Condition            -- Do we need to worry?
            │   └── EnemyInRange.java       // Condition            -- Can we step/jump on an enemy?
            └── Agent.java                  // Agent                -- Provide easy access to BT functionality as a standard agent
```


---------


## Progress


### Chapter 1: Starting Anew
 - We are now in the new source repo!
 - Thanks to https://help.github.com/en/github/creating-cloning-and-archiving-repositories/duplicating-a-repository
 - Much easier to load agents...
 - If you are wondering what happened, see my old repo at this link:
```
https://github.com/peter201943/Mario-Behavior-Trees
```
Long Story Short: I couldn't get any of the code to work. There were bugs, then there was confusion, and at that point I had spent over 2 days trying to get it to work.
I decided then to look for another implementation of this project in Java.
I hope that if this project is to be done again in the future, that you use this version, as it is far more robust, up to data, and well organized.  


### Chapter 2: Hiring an Agent
 - `random.Agent.java` looks to be the easiest to understand
 - An action is returned once every frame by the looks of it.


### Chapter 3: Making Tasks
 - https://stackoverflow.com/questions/42849890/can-i-mutate-argument-in-java
 - Why...
 - omg omg omg it works it works it work!
 - Andd..... he falls into the pit. \*sigh\*... more work.


---------


## Agent Design
 - Didn't have time to write an XML/YAML parser
 - This is the logic:
 - If enemies capable of attacking, wait and step on them
 - otherwise, run right and jump (get lucky)

### Plain
```yaml
# Forward Jump
do:
    choose:
        do:
            enemiesClose?
            choose:
                do:
                    enemyInRange?
                    attackJump!
                wait!
        do:
            stopped?
            rightRunJump!
        do:
            pit?
            rightRunJump!
        do:
            runRight!
```

### Type Annotations
```yaml
# Forward Jump                          -- comment
do:                                     -- sequence
    choose:                             -- selector
        do:                             -- sequence
            enemiesClose?               -- condition
            choose:                     -- selector
                do:                     -- sequence
                    enemyInRange?       -- condition
                    attackJump!         -- action
                wait!                   -- action
        do:                             -- selector
            stopped?                    -- condition
            rightRunJump!               -- action
        do:                             -- sequence
            pit?                        -- condition
            rightRunJump!               -- action
        do:                             -- selector
            runRight!                   -- action
```

### Justifications
```yaml
# Forward Jump
do:
    choose:
        # deal with enemies
        do:
            enemiesClose?
            choose:
                do:
                    enemyInRange?
                    attackJump!
                wait!
        # deal with walls
        do:
            stopped?
            rightRunJump!
        # deal with pits
        do:
            pit?
            rightRunJump!
        # deal with clock
        do:
            runRight!
```


---------


## Video Demonstration

A video of my agent can be accessed on YouTube at this link:
```
https://www.youtube.com/watch?v=M4K63BCFPz4
```


---------


This Project can be accessed on [Github](https://github.com/peter201943/Mario-AI-Framework) _please request permission, the repo is private_.
```
https://github.com/peter201943/Mario-AI-Framework
```

