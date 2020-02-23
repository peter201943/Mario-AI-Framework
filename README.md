

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
            │   ├── AttackJump.java         // Action               -- Returns Jump/Right commands to kill an enemy
            │   ├── Stopped.java            // Condition            -- Measure speed of Mario
            │   ├── EnemyInRange.java       // Condition            -- Can we step/jump on an enemy?
            │   └── EnemiesClose.java       // Condition            -- Do we need to worry?
            └── Agent.java                  // Agent                -- Provide easy access to BT functionality as a standard agent
```


---------


## Progress


### Chapter 1: Starting Anew
 - We are now in the new source repo!
 - Thanks to https://help.github.com/en/github/creating-cloning-and-archiving-repositories/duplicating-a-repository
 - Much easier to load agents...


### Chapter 2: Hiring an Agent
 - `random.Agent.java` looks to be the easiest to understand
 - An action is returned once every frame by the looks of it.


### Chapter 3: Adding our First Task
 - ...


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
            jump!
            runRight!
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
            jump!                       -- action
            runRight!                   -- action
        do:                             -- selector
            runRight!                   -- action
```

### Justifications
```yaml
# Forward Jump
do:
    choose:
        do:                             -- deal with enemies
            enemiesClose?
            choose:
                do:
                    enemyInRange?
                    attackJump!
                wait!
        do:                             -- deal with walls
            stopped?
            jump!
            runRight!
        do:                             -- deal with clock
            runRight!
```


---------

