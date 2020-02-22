

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
            ├── BasicTasks/
            │   ├── Task.java               // Abstract             -- Run() returns Action([bool])
            │   ├── Composite.java          // Task                 -- [Children]
            │   ├── Do.java                 // Composite            -- Run() visits each child until one returns FAIL
            │   ├── Choose.java             // Composite            -- Run() visits each child until one returns PASS
            │   ├── ChooseRandomly.java     // Choose               -- Do one child randomly
            │   ├── Action.java             // Task                 -- Do a thing to the external environment
            │   └── Condition.java          // Task                 -- Get a thing from the external environment
            ├── MarioTasks/
            │   ├── RunRight.java           // Action               -- Returns Right and Run
            │   ├── Jump.java               // Action               -- Returns Jump
            │   ├── AttackJump.java         // Action               -- Returns Jump/Right commands to kill an enemy
            │   ├── Wait.java               // Action               -- Returns [bool] of no action
            │   ├── EnemyInRange.java       // Condition            -- Can we step/jump on an enemy?
            │   └── EnemiesClose.java       // Condition            -- Do we need to worry?
            ├── Trees/
            │   ├── Tree.java               // Abstract             -- Builds a Tree from Tasks, Points to the Root, has Run()
            │   └── ForwardJump.java        // Tree                 -- Run Right and Jump
            ├── Agents/
            │   ├── BTAgent.java            // Interface            -- Tree, Run() -> [bool]]
            │   └── MarioBTAgent.java       // BasicMarioAIAgent    -- Uses Regular Mario Agent and BT Functionality
            ├── Helpers/
            │   ├── Print.java              // Interface            -- Print(depth, name, status)
            │   └── Status.java             // Class                -- Running, Pass, Fail (Just data)
            └── Agent.java                  // Agent                -- Provide easy access to BT functionality as a standard agent
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
```yaml
# Forward Jump                          -- comment
root:                                   -- container
    choose:                             -- selector
        do:                             -- sequence
            enemiesClose?               -- condition
            choose:                     -- selector
                do:                     -- sequence
                    enemyInRange?       -- condition
                    attackJump!         -- action
                wait!                   -- action
        chooseRandomly:                 -- selector
            jump!                       -- action
            runRight!                   -- action
```


---------

