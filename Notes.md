


## CS 387: Game AI


---------


# Notes


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
     - [Project Structure](#project-structure)
     - [Structure Analysis](#structure-analysis)
     - [Messaging](#messaging)
     - [LibGDX Tree Representation](#libgdx-tree-representation)
     - [Language Representations](#language-representations)
     - [Explicit Sorting Representation](#explicit-sorting-representation)
     - [Help and Understanding](#help-and-understanding)


## Links
 - [README](README.md)      -- Pertains to anything I _directly_ did
 - [Notes](Notes.md)        -- Pertains to my understanding and development of the project
 - [Behavior](behavior.py)  -- Prototype of Project in Python


---------


## Project Structure
```bash
Standard Access@SHODAN /cygdrive/c/Users/Standard Access/Peter/School/College/3 - Junior/CS 387/Projects/HW 3
$ tree .
.
├── bin
│   ├── AmiCoBuild
│   │   └── PyJava
│   │       ├── AmiCoPyJava.dll
│   │       ├── AmiCoPyJava.exp
│   │       ├── AmiCoPyJava.lib
│   │       ├── ch
│   │       │   └── idsia
│   │       │       ├── agents
│   │       │       │   ├── Agent.class
│   │       │       │   ├── AgentsPool.class
│   │       │       │   ├── AmiCoAgent.class
│   │       │       │   ├── BasicLearningAgent.class
│   │       │       │   ├── controllers
│   │       │       │   │   ├── BasicMarioAIAgent.class
│   │       │       │   │   ├── ForwardAgent.class
│   │       │       │   │   ├── ForwardJumpingAgent.class
│   │       │       │   │   ├── human
│   │       │       │   │   │   ├── CheaterKeyboardAgent.class
│   │       │       │   │   │   └── HumanKeyboardAgent.class
│   │       │       │   │   ├── RandomAgent.class
│   │       │       │   │   ├── ReplayAgent.class
│   │       │       │   │   ├── ScaredAgent.class
│   │       │       │   │   ├── ScaredShooty.class
│   │       │       │   │   └── TimingAgent.class
│   │       │       │   ├── learning
│   │       │       │   │   ├── LargeMLPAgent.class
│   │       │       │   │   ├── LargeSRNAgent.class
│   │       │       │   │   ├── MediumMLPAgent.class
│   │       │       │   │   ├── MediumSRNAgent.class
│   │       │       │   │   ├── SimpleMLPAgent.class
│   │       │       │   │   ├── SmallMLPAgent.class
│   │       │       │   │   ├── SmallSRNAgent.class
│   │       │       │   │   └── SRNAgent.class
│   │       │       │   ├── LearningAgent.class
│   │       │       │   ├── MLPESLearningAgent.class
│   │       │       │   ├── SimpleAgent.class
│   │       │       │   └── SRNESLearningAgent.class
│   │       │       ├── benchmark
│   │       │       │   ├── experiments
│   │       │       │   │   ├── EpisodicExperiment.class
│   │       │       │   │   └── Experiment.class
│   │       │       │   ├── mario
│   │       │       │   │   ├── engine
│   │       │       │   │   │   ├── Art.class
│   │       │       │   │   │   ├── BgRenderer.class
│   │       │       │   │   │   ├── GeneralizerEnemies.class
│   │       │       │   │   │   ├── GeneralizerLevelScene.class
│   │       │       │   │   │   ├── GlobalOptions.class
│   │       │       │   │   │   ├── level
│   │       │       │   │   │   │   ├── BgLevelGenerator.class
│   │       │       │   │   │   │   ├── ImprovedNoise.class
│   │       │       │   │   │   │   ├── Level$objCounters.class
│   │       │       │   │   │   │   ├── Level.class
│   │       │       │   │   │   │   ├── LevelGenerator.class
│   │       │       │   │   │   │   └── SpriteTemplate.class
│   │       │       │   │   │   ├── LevelRenderer.class
│   │       │       │   │   │   ├── LevelScene.class
│   │       │       │   │   │   ├── mapedit
│   │       │       │   │   │   │   ├── LevelEditor$1.class
│   │       │       │   │   │   │   ├── LevelEditor.class
│   │       │       │   │   │   │   ├── LevelEditView.class
│   │       │       │   │   │   │   └── TilePicker.class
│   │       │       │   │   │   ├── MarioVisualComponent.class
│   │       │       │   │   │   ├── Recorder.class
│   │       │       │   │   │   ├── Replayer.class
│   │       │       │   │   │   ├── resources
│   │       │       │   │   │   │   ├── bgsheet.png
│   │       │       │   │   │   │   ├── endscene.gif
│   │       │       │   │   │   │   ├── enemysheet.png
│   │       │       │   │   │   │   ├── firemariosheet.png
│   │       │       │   │   │   │   ├── font.gif
│   │       │       │   │   │   │   ├── itemsheet.png
│   │       │       │   │   │   │   ├── logo.gif
│   │       │       │   │   │   │   ├── mapsheet.png
│   │       │       │   │   │   │   ├── mariosheet.png
│   │       │       │   │   │   │   ├── particlesheet.png
│   │       │       │   │   │   │   ├── princess.png
│   │       │       │   │   │   │   ├── racoonmariosheet.png
│   │       │       │   │   │   │   ├── smallmariosheet.png
│   │       │       │   │   │   │   ├── test.lvl
│   │       │       │   │   │   │   ├── tiles.dat
│   │       │       │   │   │   │   └── worldmap.png
│   │       │       │   │   │   └── sprites
│   │       │       │   │   │       ├── BulletBill.class
│   │       │       │   │   │       ├── CoinAnim.class
│   │       │       │   │   │       ├── Enemy.class
│   │       │       │   │   │       ├── Fireball.class
│   │       │       │   │   │       ├── FireFlower.class
│   │       │       │   │   │       ├── FlowerEnemy.class
│   │       │       │   │   │       ├── GreenMushroom.class
│   │       │       │   │   │       ├── Mario.class
│   │       │       │   │   │       ├── Mushroom.class
│   │       │       │   │   │       ├── Particle.class
│   │       │       │   │   │       ├── Princess.class
│   │       │       │   │   │       ├── Shell.class
│   │       │       │   │   │       ├── Sparkle.class
│   │       │       │   │   │       ├── Sprite.class
│   │       │       │   │   │       ├── SpriteContext.class
│   │       │       │   │   │       └── WaveGoomba.class
│   │       │       │   │   ├── environments
│   │       │       │   │   │   ├── Environment.class
│   │       │       │   │   │   └── MarioEnvironment.class
│   │       │       │   │   └── simulation
│   │       │       │   │       ├── AmiCoSimulator.class
│   │       │       │   │       └── SimulationOptions.class
│   │       │       │   └── tasks
│   │       │       │       ├── BasicTask.class
│   │       │       │       ├── GamePlayTask.class
│   │       │       │       ├── LearningTask.class
│   │       │       │       ├── MarioCustomSystemOfValues.class
│   │       │       │       ├── MarioSystemOfValues$timeLengthMapping.class
│   │       │       │       ├── MarioSystemOfValues.class
│   │       │       │       ├── MultiDifficultyProgressTask.class
│   │       │       │       ├── MultiSeedProgressTask.class
│   │       │       │       ├── MushroomTask.class
│   │       │       │       ├── ProgressTask.class
│   │       │       │       ├── ReplayTask.class
│   │       │       │       ├── SystemOfValues.class
│   │       │       │       └── Task.class
│   │       │       ├── evolution
│   │       │       │   ├── ea
│   │       │       │   │   └── ES.class
│   │       │       │   ├── EA.class
│   │       │       │   ├── Evolvable.class
│   │       │       │   ├── FA.class
│   │       │       │   ├── MLP.class
│   │       │       │   └── SRN.class
│   │       │       ├── scenarios
│   │       │       │   ├── champ
│   │       │       │   │   ├── GamePlayTrack.class
│   │       │       │   │   ├── LearningTrack.class
│   │       │       │   │   └── TuringTestTrack.class
│   │       │       │   ├── Custom.class
│   │       │       │   ├── Main.class
│   │       │       │   ├── oldscenarios
│   │       │       │   │   ├── CompetitionScore.class
│   │       │       │   │   ├── Evolve.class
│   │       │       │   │   ├── EvolveIncrementally.class
│   │       │       │   │   ├── EvolveMultiSeed.class
│   │       │       │   │   ├── GeneralScenario.class
│   │       │       │   │   ├── MainRun.class
│   │       │       │   │   └── Stats.class
│   │       │       │   ├── Play.class
│   │       │       │   ├── Replay.class
│   │       │       │   └── test
│   │       │       │       ├── EvaluateJLink.class
│   │       │       │       ├── EvolveSingle.class
│   │       │       │       ├── EvolveWithChangingSeeds.class
│   │       │       │       ├── PaperEvolve.class
│   │       │       │       ├── PaperEvolveBatch.class
│   │       │       │       ├── PlayJLink.class
│   │       │       │       ├── StatsJLink.class
│   │       │       │       └── StochasticityTest.class
│   │       │       ├── tools
│   │       │       │   ├── amico
│   │       │       │   │   └── AmiCoJavaPy.class
│   │       │       │   ├── EvaluationInfo.class
│   │       │       │   ├── EvaluationInfoStatisticalSummary.class
│   │       │       │   ├── Evaluator.class
│   │       │       │   ├── GameViewer$1.class
│   │       │       │   ├── GameViewer$GameViewerActions.class
│   │       │       │   ├── GameViewer$GameViewerView.class
│   │       │       │   ├── GameViewer.class
│   │       │       │   ├── MarioAIOptions.class
│   │       │       │   ├── RandomCreatureGenerator.class
│   │       │       │   ├── ReplayerOptions$Interval.class
│   │       │       │   ├── ReplayerOptions.class
│   │       │       │   ├── Scale2x.class
│   │       │       │   ├── StateEncoderDecoder.class
│   │       │       │   ├── ToolsConfigurator$INTERFACE_TYPE.class
│   │       │       │   ├── ToolsConfigurator$ToolsConfiguratorActions.class
│   │       │       │   └── ToolsConfigurator.class
│   │       │       ├── unittests
│   │       │       │   ├── CmdLineOptionsTest.class
│   │       │       │   ├── LevelGeneratorTest.class
│   │       │       │   ├── LevelSceneTest.class
│   │       │       │   ├── MarioAIBenchmarkTest.class
│   │       │       │   └── MarioEnvironmentTest.class
│   │       │       └── utils
│   │       │           ├── ErrorCodes.class
│   │       │           ├── MathX.class
│   │       │           ├── ParameterContainer.class
│   │       │           ├── statistics
│   │       │           │   ├── StatisticalSummary$Watch.class
│   │       │           │   ├── StatisticalSummary.class
│   │       │           │   ├── StatisticalTests.class
│   │       │           │   └── Stats.class
│   │       │           └── wox
│   │       │               └── serial
│   │       │                   ├── AccessTest$Sub.class
│   │       │                   ├── AccessTest$Super.class
│   │       │                   ├── AccessTest.class
│   │       │                   ├── ArrayListTest.class
│   │       │                   ├── Easy.class
│   │       │                   ├── EasyTest.class
│   │       │                   ├── EncodeBase64.class
│   │       │                   ├── ObjectReader.class
│   │       │                   ├── ObjectWriter.class
│   │       │                   ├── ReadTest.class
│   │       │                   ├── Serial.class
│   │       │                   ├── ShadowTest$X.class
│   │       │                   ├── ShadowTest$Y.class
│   │       │                   ├── ShadowTest.class
│   │       │                   ├── SimpleReader.class
│   │       │                   ├── SimpleWriter.class
│   │       │                   ├── TestObject$Inner.class
│   │       │                   ├── TestObject.class
│   │       │                   ├── Util.class
│   │       │                   └── WriterTest.class
│   │       ├── DemoForwardAgent.py
│   │       ├── DemoForwardJumpingAgent.py
│   │       ├── Dima_agent.py
│   │       ├── Dima_agent.pyc
│   │       ├── DimaAgent.py
│   │       ├── evaluationinfo.py
│   │       ├── evaluationinfo.pyc
│   │       ├── forwardagent.py
│   │       ├── forwardjumpingagent.py
│   │       ├── forwardjumpingagent.pyc
│   │       ├── marioagent.py
│   │       └── marioagent.pyc
│   └── MarioAI
│       ├── ch
│       │   └── idsia
│       │       ├── agents
│       │       │   ├── Agent.class
│       │       │   ├── AgentLoader.class
│       │       │   ├── AgentsPool.class
│       │       │   ├── AmiCoAgent.class
│       │       │   ├── BasicLearningAgent.class
│       │       │   ├── controllers
│       │       │   │   ├── BasicMarioAIAgent.class
│       │       │   │   ├── ForwardAgent.class
│       │       │   │   ├── ForwardJumpingAgent.class
│       │       │   │   ├── human
│       │       │   │   │   ├── CheaterKeyboardAgent.class
│       │       │   │   │   └── HumanKeyboardAgent.class
│       │       │   │   ├── RandomAgent.class
│       │       │   │   ├── ReplayAgent.class
│       │       │   │   ├── ScaredAgent.class
│       │       │   │   ├── ScaredShooty.class
│       │       │   │   └── TimingAgent.class
│       │       │   ├── learning
│       │       │   │   ├── LargeMLPAgent.class
│       │       │   │   ├── LargeSRNAgent.class
│       │       │   │   ├── MediumMLPAgent.class
│       │       │   │   ├── MediumSRNAgent.class
│       │       │   │   ├── SimpleMLPAgent.class
│       │       │   │   ├── SmallMLPAgent.class
│       │       │   │   ├── SmallSRNAgent.class
│       │       │   │   └── SRNAgent.class
│       │       │   ├── LearningAgent.class
│       │       │   ├── MLPESLearningAgent.class
│       │       │   ├── SimpleAgent.class
│       │       │   └── SRNESLearningAgent.class
│       │       ├── benchmark
│       │       │   ├── experiments
│       │       │   │   ├── EpisodicExperiment.class
│       │       │   │   └── Experiment.class
│       │       │   ├── mario
│       │       │   │   ├── engine
│       │       │   │   │   ├── Art.class
│       │       │   │   │   ├── BgRenderer.class
│       │       │   │   │   ├── GeneralizerEnemies.class
│       │       │   │   │   ├── GeneralizerLevelScene.class
│       │       │   │   │   ├── GlobalOptions.class
│       │       │   │   │   ├── level
│       │       │   │   │   │   ├── BgLevelGenerator.class
│       │       │   │   │   │   ├── ImprovedNoise.class
│       │       │   │   │   │   ├── Level$objCounters.class
│       │       │   │   │   │   ├── Level.class
│       │       │   │   │   │   ├── LevelGenerator.class
│       │       │   │   │   │   └── SpriteTemplate.class
│       │       │   │   │   ├── LevelRenderer.class
│       │       │   │   │   ├── LevelScene.class
│       │       │   │   │   ├── mapedit
│       │       │   │   │   │   ├── LevelEditor$1.class
│       │       │   │   │   │   ├── LevelEditor.class
│       │       │   │   │   │   ├── LevelEditView.class
│       │       │   │   │   │   └── TilePicker.class
│       │       │   │   │   ├── MarioVisualComponent.class
│       │       │   │   │   ├── Recorder.class
│       │       │   │   │   ├── Replayer.class
│       │       │   │   │   ├── resources
│       │       │   │   │   │   ├── bgsheet.png
│       │       │   │   │   │   ├── endscene.gif
│       │       │   │   │   │   ├── enemysheet.png
│       │       │   │   │   │   ├── firemariosheet.png
│       │       │   │   │   │   ├── font.gif
│       │       │   │   │   │   ├── itemsheet.png
│       │       │   │   │   │   ├── logo.gif
│       │       │   │   │   │   ├── mapsheet.png
│       │       │   │   │   │   ├── mariosheet.png
│       │       │   │   │   │   ├── particlesheet.png
│       │       │   │   │   │   ├── princess.png
│       │       │   │   │   │   ├── racoonmariosheet.png
│       │       │   │   │   │   ├── smallmariosheet.png
│       │       │   │   │   │   ├── test.lvl
│       │       │   │   │   │   ├── tiles.dat
│       │       │   │   │   │   └── worldmap.png
│       │       │   │   │   └── sprites
│       │       │   │   │       ├── BulletBill.class
│       │       │   │   │       ├── CoinAnim.class
│       │       │   │   │       ├── Enemy.class
│       │       │   │   │       ├── Fireball.class
│       │       │   │   │       ├── FireFlower.class
│       │       │   │   │       ├── FlowerEnemy.class
│       │       │   │   │       ├── GreenMushroom.class
│       │       │   │   │       ├── Mario.class
│       │       │   │   │       ├── Mushroom.class
│       │       │   │   │       ├── Particle.class
│       │       │   │   │       ├── Princess.class
│       │       │   │   │       ├── Shell.class
│       │       │   │   │       ├── Sparkle.class
│       │       │   │   │       ├── Sprite.class
│       │       │   │   │       ├── SpriteContext.class
│       │       │   │   │       └── WaveGoomba.class
│       │       │   │   ├── environments
│       │       │   │   │   ├── Environment.class
│       │       │   │   │   └── MarioEnvironment.class
│       │       │   │   └── simulation
│       │       │   │       ├── AmiCoSimulator.class
│       │       │   │       └── SimulationOptions.class
│       │       │   └── tasks
│       │       │       ├── BasicTask.class
│       │       │       ├── GamePlayTask.class
│       │       │       ├── LearningTask.class
│       │       │       ├── MarioCustomSystemOfValues.class
│       │       │       ├── MarioSystemOfValues$timeLengthMapping.class
│       │       │       ├── MarioSystemOfValues.class
│       │       │       ├── MultiDifficultyProgressTask.class
│       │       │       ├── MultiSeedProgressTask.class
│       │       │       ├── MushroomTask.class
│       │       │       ├── ProgressTask.class
│       │       │       ├── ReplayTask.class
│       │       │       ├── SystemOfValues.class
│       │       │       └── Task.class
│       │       ├── evolution
│       │       │   ├── ea
│       │       │   │   └── ES.class
│       │       │   ├── EA.class
│       │       │   ├── Evolvable.class
│       │       │   ├── FA.class
│       │       │   ├── MLP.class
│       │       │   └── SRN.class
│       │       ├── scenarios
│       │       │   ├── champ
│       │       │   │   ├── GamePlayTrack.class
│       │       │   │   ├── LearningTrack.class
│       │       │   │   └── TuringTestTrack.class
│       │       │   ├── Custom.class
│       │       │   ├── Main.class
│       │       │   ├── oldscenarios
│       │       │   │   ├── CompetitionScore.class
│       │       │   │   ├── Evolve.class
│       │       │   │   ├── EvolveIncrementally.class
│       │       │   │   ├── EvolveMultiSeed.class
│       │       │   │   ├── GeneralScenario.class
│       │       │   │   ├── MainRun.class
│       │       │   │   └── Stats.class
│       │       │   ├── Play.class
│       │       │   ├── Replay.class
│       │       │   └── test
│       │       │       ├── EvaluateJLink.class
│       │       │       ├── EvolveSingle.class
│       │       │       ├── EvolveWithChangingSeeds.class
│       │       │       ├── PaperEvolve.class
│       │       │       ├── PaperEvolveBatch.class
│       │       │       ├── PlayJLink.class
│       │       │       ├── StatsJLink.class
│       │       │       └── StochasticityTest.class
│       │       ├── tools
│       │       │   ├── amico
│       │       │   │   └── AmiCoJavaPy.class
│       │       │   ├── EvaluationInfo.class
│       │       │   ├── EvaluationInfoStatisticalSummary.class
│       │       │   ├── Evaluator.class
│       │       │   ├── GameViewer$1.class
│       │       │   ├── GameViewer$GameViewerActions.class
│       │       │   ├── GameViewer$GameViewerView.class
│       │       │   ├── GameViewer.class
│       │       │   ├── MarioAIOptions.class
│       │       │   ├── punj
│       │       │   │   └── PunctualJudge.class
│       │       │   ├── RandomCreatureGenerator.class
│       │       │   ├── ReplayerOptions$Interval.class
│       │       │   ├── ReplayerOptions.class
│       │       │   ├── Scale2x.class
│       │       │   ├── StateEncoderDecoder.class
│       │       │   ├── ToolsConfigurator$INTERFACE_TYPE.class
│       │       │   ├── ToolsConfigurator$ToolsConfiguratorActions.class
│       │       │   └── ToolsConfigurator.class
│       │       ├── unittests
│       │       │   ├── CmdLineOptionsTest.class
│       │       │   ├── LevelGeneratorTest.class
│       │       │   ├── LevelSceneTest.class
│       │       │   ├── MarioAIBenchmarkTest.class
│       │       │   └── MarioEnvironmentTest.class
│       │       └── utils
│       │           ├── ErrorCodes.class
│       │           ├── MathX.class
│       │           ├── ParameterContainer.class
│       │           ├── statistics
│       │           │   ├── StatisticalSummary$Watch.class
│       │           │   ├── StatisticalSummary.class
│       │           │   ├── StatisticalTests.class
│       │           │   └── Stats.class
│       │           └── wox
│       │               └── serial
│       │                   ├── AccessTest$Sub.class
│       │                   ├── AccessTest$Super.class
│       │                   ├── AccessTest.class
│       │                   ├── ArrayListTest.class
│       │                   ├── Easy.class
│       │                   ├── EasyTest.class
│       │                   ├── EncodeBase64.class
│       │                   ├── ObjectReader.class
│       │                   ├── ObjectWriter.class
│       │                   ├── ReadTest.class
│       │                   ├── Serial.class
│       │                   ├── ShadowTest$X.class
│       │                   ├── ShadowTest$Y.class
│       │                   ├── ShadowTest.class
│       │                   ├── SimpleReader.class
│       │                   ├── SimpleWriter.class
│       │                   ├── TestObject$Inner.class
│       │                   ├── TestObject.class
│       │                   ├── Util.class
│       │                   └── WriterTest.class
│       └── competition
│           ├── cig
│           │   └── sergeykarakovskiy
│           │       └── SergeyKarakovskiy_JumpingAgent.class
│           ├── evostar
│           │   └── sergeykarakovskiy
│           │       └── SergeyKarakovskiy_JumpingAgent.class
│           ├── gic2010
│           │   ├── gameplay
│           │   │   └── sergeykarakovskiy
│           │   │       └── SergeyKarakovskiy_ForwardAgent.class
│           │   ├── learning
│           │   │   └── sergeykarakovskiy
│           │   │       └── SergeyKarakovskiy_MLPAgent.class
│           │   └── turing
│           │       └── sergeykarakovskiy
│           │           └── SergeyKarakovskiy_ForwardAgent.class
│           └── wcci
│               └── NikolaySohryakov
│                   └── NikolaySohryakovAgent.class
├── lib
│   ├── asm-all-3.3.jar
│   ├── jdom.jar
│   └── junit-4.8.2.jar
├── LICENSE
├── MarioAI.zip
├── README.md
├── src
│   ├── amico
│   │   ├── cpp
│   │   ├── haskell
│   │   ├── mono
│   │   ├── ocaml
│   │   ├── pascal
│   │   ├── python
│   │   │   ├── agents
│   │   │   │   ├── DemoForwardAgent.py
│   │   │   │   ├── DemoForwardJumpingAgent.py
│   │   │   │   ├── evaluationinfo.py
│   │   │   │   ├── forwardagent.py
│   │   │   │   ├── forwardjumpingagent.py
│   │   │   │   └── marioagent.py
│   │   │   ├── JavaPy
│   │   │   │   ├── make.cmd
│   │   │   │   ├── Makefile
│   │   │   │   ├── Makefile.Darwin
│   │   │   │   ├── Makefile.Linux
│   │   │   │   ├── Makefile.Win
│   │   │   │   ├── run.cmd
│   │   │   │   ├── run.sh
│   │   │   │   └── src
│   │   │   │       ├── AmiCoJavaPy.def
│   │   │   │       ├── arrayutils.h
│   │   │   │       ├── ch_idsia_tools_amico_AmiCoJavaPy.cc
│   │   │   │       └── ch_idsia_tools_amico_AmiCoJavaPy.h
│   │   │   └── PyJava
│   │   │       ├── AmiCoRunner.sh
│   │   │       ├── make.cmd
│   │   │       ├── Makefile
│   │   │       ├── Makefile.Darwin
│   │   │       ├── Makefile.Linux
│   │   │       ├── Makefile.Win
│   │   │       ├── PythonCallsJava.obj
│   │   │       ├── run.cmd
│   │   │       ├── run.sh
│   │   │       └── src
│   │   │           ├── AmiCoPyJava.def
│   │   │           ├── arrayutils.h
│   │   │           ├── PythonCallsJava.cc
│   │   │           └── PythonCallsJava.h
│   │   └── scala
│   ├── ch
│   │   └── idsia
│   │       ├── agents
│   │       │   ├── Agent.java
│   │       │   ├── AgentLoader.java
│   │       │   ├── AgentsPool.java
│   │       │   ├── AmiCoAgent.java
│   │       │   ├── BasicLearningAgent.java
│   │       │   ├── controllers
│   │       │   │   ├── BasicMarioAIAgent.java
│   │       │   │   ├── ForwardAgent.java
│   │       │   │   ├── forwardagent.py
│   │       │   │   ├── ForwardJumpingAgent.java
│   │       │   │   ├── human
│   │       │   │   │   ├── CheaterKeyboardAgent.java
│   │       │   │   │   └── HumanKeyboardAgent.java
│   │       │   │   ├── marioagent.py
│   │       │   │   ├── RandomAgent.java
│   │       │   │   ├── ReplayAgent.java
│   │       │   │   ├── ScaredAgent.java
│   │       │   │   ├── ScaredShooty.java
│   │       │   │   └── TimingAgent.java
│   │       │   ├── learning
│   │       │   │   ├── LargeMLPAgent.java
│   │       │   │   ├── LargeSRNAgent.java
│   │       │   │   ├── MediumMLPAgent.java
│   │       │   │   ├── MediumSRNAgent.java
│   │       │   │   ├── SimpleMLPAgent.java
│   │       │   │   ├── SmallMLPAgent.java
│   │       │   │   ├── SmallSRNAgent.java
│   │       │   │   └── SRNAgent.java
│   │       │   ├── LearningAgent.java
│   │       │   ├── MLPESLearningAgent.java
│   │       │   ├── SimpleAgent.java
│   │       │   ├── simplepythonagent.py
│   │       │   └── SRNESLearningAgent.java
│   │       ├── benchmark
│   │       │   ├── experiments
│   │       │   │   ├── EpisodicExperiment.java
│   │       │   │   └── Experiment.java
│   │       │   ├── mario
│   │       │   │   ├── engine
│   │       │   │   │   ├── Art.java
│   │       │   │   │   ├── BgRenderer.java
│   │       │   │   │   ├── GeneralizerEnemies.java
│   │       │   │   │   ├── GeneralizerLevelScene.java
│   │       │   │   │   ├── GlobalOptions.java
│   │       │   │   │   ├── level
│   │       │   │   │   │   ├── BgLevelGenerator.java
│   │       │   │   │   │   ├── ImprovedNoise.java
│   │       │   │   │   │   ├── Level.java
│   │       │   │   │   │   ├── LevelGenerator.java
│   │       │   │   │   │   └── SpriteTemplate.java
│   │       │   │   │   ├── LevelRenderer.java
│   │       │   │   │   ├── LevelScene.java
│   │       │   │   │   ├── mapedit
│   │       │   │   │   │   ├── LevelEditor.java
│   │       │   │   │   │   ├── LevelEditView.java
│   │       │   │   │   │   └── TilePicker.java
│   │       │   │   │   ├── MarioVisualComponent.java
│   │       │   │   │   ├── Recorder.java
│   │       │   │   │   ├── Replayer.java
│   │       │   │   │   ├── resources
│   │       │   │   │   │   ├── bgsheet.png
│   │       │   │   │   │   ├── endscene.gif
│   │       │   │   │   │   ├── enemysheet.png
│   │       │   │   │   │   ├── firemariosheet.png
│   │       │   │   │   │   ├── font.gif
│   │       │   │   │   │   ├── itemsheet.png
│   │       │   │   │   │   ├── logo.gif
│   │       │   │   │   │   ├── mapsheet.png
│   │       │   │   │   │   ├── mariosheet.png
│   │       │   │   │   │   ├── particlesheet.png
│   │       │   │   │   │   ├── princess.png
│   │       │   │   │   │   ├── racoonmariosheet.png
│   │       │   │   │   │   ├── smallmariosheet.png
│   │       │   │   │   │   ├── test.lvl
│   │       │   │   │   │   ├── tiles.dat
│   │       │   │   │   │   └── worldmap.png
│   │       │   │   │   └── sprites
│   │       │   │   │       ├── BulletBill.java
│   │       │   │   │       ├── CoinAnim.java
│   │       │   │   │       ├── Enemy.java
│   │       │   │   │       ├── Fireball.java
│   │       │   │   │       ├── FireFlower.java
│   │       │   │   │       ├── FlowerEnemy.java
│   │       │   │   │       ├── GreenMushroom.java
│   │       │   │   │       ├── Mario.java
│   │       │   │   │       ├── Mushroom.java
│   │       │   │   │       ├── Particle.java
│   │       │   │   │       ├── Princess.java
│   │       │   │   │       ├── Shell.java
│   │       │   │   │       ├── Sparkle.java
│   │       │   │   │       ├── Sprite.java
│   │       │   │   │       ├── SpriteContext.java
│   │       │   │   │       └── WaveGoomba.java
│   │       │   │   ├── environments
│   │       │   │   │   ├── Environment.java
│   │       │   │   │   └── MarioEnvironment.java
│   │       │   │   └── simulation
│   │       │   │       ├── AmiCoSimulator.java
│   │       │   │       └── SimulationOptions.java
│   │       │   └── tasks
│   │       │       ├── BasicTask.java
│   │       │       ├── GamePlayTask.java
│   │       │       ├── LearningTask.java
│   │       │       ├── MarioCustomSystemOfValues.java
│   │       │       ├── MarioSystemOfValues.java
│   │       │       ├── MultiDifficultyProgressTask.java
│   │       │       ├── MultiSeedProgressTask.java
│   │       │       ├── MushroomTask.java
│   │       │       ├── ProgressTask.java
│   │       │       ├── ReplayTask.java
│   │       │       ├── SystemOfValues.java
│   │       │       └── Task.java
│   │       ├── evolution
│   │       │   ├── ea
│   │       │   │   └── ES.java
│   │       │   ├── EA.java
│   │       │   ├── Evolvable.java
│   │       │   ├── FA.java
│   │       │   ├── MLP.java
│   │       │   └── SRN.java
│   │       ├── scenarios
│   │       │   ├── champ
│   │       │   │   ├── GamePlayTrack.java
│   │       │   │   ├── LearningTrack.java
│   │       │   │   └── TuringTestTrack.java
│   │       │   ├── Custom.java
│   │       │   ├── Main.java
│   │       │   ├── oldscenarios
│   │       │   │   ├── CompetitionScore.java
│   │       │   │   ├── Evolve.java
│   │       │   │   ├── EvolveIncrementally.java
│   │       │   │   ├── EvolveMultiSeed.java
│   │       │   │   ├── GeneralScenario.java
│   │       │   │   ├── MainRun.java
│   │       │   │   └── Stats.java
│   │       │   ├── Play.java
│   │       │   ├── Replay.java
│   │       │   └── test
│   │       │       ├── EvaluateJLink.java
│   │       │       ├── EvolveSingle.java
│   │       │       ├── EvolveWithChangingSeeds.java
│   │       │       ├── PaperEvolve.java
│   │       │       ├── PaperEvolveBatch.java
│   │       │       ├── PlayJLink.java
│   │       │       ├── StatsJLink.java
│   │       │       └── StochasticityTest.java
│   │       ├── tools
│   │       │   ├── amico
│   │       │   │   └── AmiCoJavaPy.java
│   │       │   ├── EvaluationInfo.java
│   │       │   ├── EvaluationInfoStatisticalSummary.java
│   │       │   ├── Evaluator.java
│   │       │   ├── GameViewer.java
│   │       │   ├── MarioAIOptions.java
│   │       │   ├── punj
│   │       │   │   └── PunctualJudge.java
│   │       │   ├── RandomCreatureGenerator.java
│   │       │   ├── ReplayerOptions.java
│   │       │   ├── Scale2x.java
│   │       │   ├── StateEncoderDecoder.java
│   │       │   └── ToolsConfigurator.java
│   │       ├── unittests
│   │       │   ├── CmdLineOptionsTest.java
│   │       │   ├── LevelGeneratorTest.java
│   │       │   ├── LevelSceneTest.java
│   │       │   ├── MarioAIBenchmarkTest.java
│   │       │   └── MarioEnvironmentTest.java
│   │       └── utils
│   │           ├── ErrorCodes.java
│   │           ├── MathX.java
│   │           ├── ParameterContainer.java
│   │           ├── statistics
│   │           │   ├── StatisticalSummary.java
│   │           │   ├── StatisticalTests.java
│   │           │   └── Stats.java
│   │           └── wox
│   │               └── serial
│   │                   ├── AccessTest.java
│   │                   ├── ArrayListTest.java
│   │                   ├── Easy.java
│   │                   ├── EasyTest.java
│   │                   ├── EncodeBase64.java
│   │                   ├── ObjectReader.java
│   │                   ├── ObjectWriter.java
│   │                   ├── ReadTest.java
│   │                   ├── Serial.java
│   │                   ├── ShadowTest.java
│   │                   ├── SimpleReader.java
│   │                   ├── SimpleWriter.java
│   │                   ├── TestObject.java
│   │                   ├── Util.java
│   │                   └── WriterTest.java
│   └── competition
│       ├── cig
│       │   └── sergeykarakovskiy
│       │       └── SergeyKarakovskiy_JumpingAgent.java
│       ├── evostar
│       │   └── sergeykarakovskiy
│       │       └── SergeyKarakovskiy_JumpingAgent.java
│       ├── gic2010
│       │   ├── gameplay
│       │   │   └── sergeykarakovskiy
│       │   │       └── SergeyKarakovskiy_ForwardAgent.java
│       │   ├── learning
│       │   │   └── sergeykarakovskiy
│       │   │       └── SergeyKarakovskiy_MLPAgent.java
│       │   └── turing
│       │       └── sergeykarakovskiy
│       │           └── SergeyKarakovskiy_ForwardAgent.java
│       └── wcci
│           └── NikolaySohryakov
│               └── NikolaySohryakovAgent.java
└── target
    └── scripts
        ├── catResults.sh
        ├── game-play-track-evaluation.sh
        ├── learning-track-evaluation.sh
        ├── runClient.sh
        ├── runExperiments.sh
        ├── runServer.sh
        └── turing-test-track-evaluation.sh

141 directories, 584 files
```


## Structure Analysis
 - There are 3 `ch.idsia.scenarios.Main` files.
     1. `bin/AmiCo/Buil/PyJava/ch/idsia/scenarios/Main.class`
     2. `bin/MarioAI/ch/idsia/scenarios/Main.class`
     3. `src/ch/idsia/scenarios/Main.java`
 - There is no `CustomRun` file.
 - There are 3 `Play` files.
     1. `bin/AmiCoBuild/ch/idsia/scenarios/Play.class`
     2. `bin/MarioAI/ch/idsia/scenarios/Play.class`
     3. `src/ch/idsia/scenarios/Play.java`


---------


## Messaging


### Task Messaging System
 - Basic
     - Running
     - Not Running
 - Advanced
     - Running
     - Succeeded
     - Failed


### Tree System Interaction
 - Game:
     - World
         - Player
         - Enemies
         - Items
         - Geometry
     - Tree
         - Tasks
     - Agent
         - BT Interface
 - Tree is 'run once' by interface
 - Tree changes state of Agent
 - Task is 'run once' by tree (recursive)
 - Task returns status of computation (needs more, needs less)
 - Task computation is bound to change in game state
 - Tasks are resumed by the agent every Game Cycle _(see Update() method)_
 - Tasks check if their prior state was `running` and run themselves again if so
 - Tasks change state based on their children - if child fails, parent fails


--------


## LibGDX Tree Representation


### Raw Data YAML:
 - Notation:
     - `composite:`
     - `condition?`
     - `action!`
```yaml
# FILE : Patrol Tree

# Standard Utils
(JV) import "BT.java" as "root"
(JV) import "SelectorComposite.java" as "selector"
(JV) import "SequenceComposite.java" as "sequence"

# Condition Utils
(JV) import "CanSeePlayerCondition.java" as "canSeePlayer?"
(JV) import "IsTargetCloseCondition.java" as "isTargetClose?"

# Action Utils
(JV) import "AttackAction.java" as "attack!"
(JV) import "PatrolAction.java" as "patrol!"
(JV) import "MoveAction.java" as "move!"

# Definition
root:
    selector:
        sequence:
            isTargetClose?
            selector:
                sequence:
                    canSeePlayer?
                    attack!
                patrol!
        move!
```


### Layers of Logic:
 - **(1)** choose `move!` or `sequence:`
 - **(2)** wait until `isTargetClose?` then `select:`
 - **(3)** choose `sequence:` or `patrol!`
 - **(4)** wait until `canSeePlayer?` then `attack!`


### Names By Family:
 - root.selector:
 - root.selector.sequence:
 - root.selector.sequence.isTargetClose?
 - root.selector.sequence.selector:
 - root.selector.sequence.selector.sequence:
 - root.selector.sequence.selector.sequence.canSeePlay?
 - root.selector.sequence.selector.sequence.attack!
 - root.selector.sequence.selector.patrol!
 - root.selector.move!


---------


## Language Representations


### Lisp?
```lisp
(root (selector ((sequence isTargetClose?
                           (selector (sequence   canSeePlayer?
                                                 attack!)))
                                     patrol!
                move!)))
```


### Python
```python
def PatrolTree():
    while(True):
        selector(
            sequence(
                isTargetClose(),
                selector(
                    sequence(
                        canSeePlayer(),
                        attack()),
                    patrol())),
            move())
```


```python
def PatrolTree():
    while(True): selector(sequence(isTargetClose(), selector(sequence(canSeePlayer(), attack()), patrol())), move())
```


### Switches
```python
def PatrolTree(self, world):
    while(True):                        # root
        switch(isTargetClose()):        # selector on isTargetClose?
            case True:                  # sequence
                switch(canSeePlayer()): # selector on canSeePlayer?
                    case True:          # sequence
                        attack()        # attack!
                    default:
                        patrol()        # patrol!
            case False:
                move()                  # move!
```


### If Statements
```python
def PatrolTree(self, world):
    while(True):                        # root
        if(isTargetClose()):            # selector on isTargetClose?
            if(canSeePlayer()):
                attack()
            else:
                patrol()
        else:
            move()
```


### Scheme
```scheme
(define (PatrolTree self world)
    (if isTargetClose
        (if canSeePlayer
            attack
            patrol)
        move))
```


### Haskell
```haskell
PatrolTree :: World -> Action
PatrolTree _                    = PatrolTree IsTargetClose?
PatrolTree IsTargetClose        = PatrolTree CanSeePlayer?
PatrolTree CanSeePlayer         = Attack
PatrolTree (not canSeePlayer)   = Patrol
PatrolTree (not isTargetClose)  = Move
```


---------


## Explicit Sorting Representation


### Conditional Sorting
```yaml
root:
    targetIsClose
    default

default:
    move!

targetIsClose:
    canSeePlayer
    cannotSeePlayer

canSeePlayer:
    attack!

cannotSeePlayer:
    patrol!
```


### Long Conditional Sorting
```yaml
root:
    targetIsClose and canSeePlayer -> attack!
    targetIsClose and cannotSeePlayer -> patrol!
    targetIsNotClose and cannotSeePlayer -> move!
```


### Short Conditional Sorting
```yaml
root:
    targetIsClose and canSeePlayer -> attack!
    targetIsClose -> patrol!
    _ -> move!
```


### Parental Conditional Sorting
```bash
root:
├── isTargetClose?
│   ├── canSeePlayer?
│   │   └── attack!
│   └── patrol!
└── move!
```


 - How to represent ordering?
     - Short Circuiting?
     - Most Specific Case First?
         - How to build this model of evaluation?
 - How to represent parallel actions?
     - Eg, we want the agent to _always_ move?


```yaml
root:
 - isTargetClose?
     - canSeePlayer?
         - attack!
     - patrol!
     - move!
```


```yaml
root:
    isTargetClose?
        canSeePlayer?
            attack!
        patrol!
    move!
```


 - Are these just implicit selectors and sequencers?
 - How to indicate a random selection?
 - How to indicate an open selection? (eg, accepts a generic method of selecting -- returns a list)


```
root:
    random?
        attack!
        retreat!
```


 - Implicit Implications...
     - What if ALL nodes were selectors and sequencers, just with only one child?
     - Hence, any node could quickly and easily transform in role, even dynamically.
     - Yet...
         - Optimization? - Have check for no children? No Check for Parents?
     - Do we even need a `tree` class? Or do we just need a handler for it?
 - How to handle complexity?
     - EG, loooong or heavily in d  e   n    t      e       d ?


```yaml
root:
    attack
    patrol
    move
attack:
    isTargetClose?
        canSeePlayer?
            attack!
patrol:
    isTargetClose?
        patrol!
move:
    move!
```


```yaml
in_order:
    move
    shoot
random_order:
    move
    shoot
pick:
    move
    shoot
pick_random:
    move
    shoot
parallel:
    move
    shoot
```


---------


## Help and Understanding


### Readings
 - https://github.com/libgdx/gdx-ai/wiki/Behavior-Trees
     - This is a GREAT resource!
 - https://www.gameaipro.com/GameAIPro/GameAIPro_Chapter06_The_Behavior_Tree_Starter_Kit.pdf
 - http://www.what-could-possibly-go-wrong.com/fluent-behavior-trees-for-ai-and-game-logic/
 - https://www.youtube.com/watch?v=bT7WRAeQo3c
 - https://sites.google.com/a/marioai.com/www/marioai-benchmark/overview


### Class Notes
 - Press "G" for Gridview
 - `Ego` - refers to Center of Mario (Screen Position)
 - Blocks might appear invisible running under Java 8
 - I configured the build path in the project to use JRE System Library [jdk1.8.0_241]
 - and also had to set the compliance level of the compiler to 1.8
 - main -> declare your agent
 - marioAIOptions -> set agent


### Getting the Game to Work
 - Use Java 1.8
 - Try ForwardAgent.java
 - Delete ANY `testing` references
 - Advice:
     - The way I do it is in the runtime parameters.  
     - `-ag ch.idsia.agents.controllers.BehaviorTreeAgent`  
     - my file is called `BehaviorTreeAgent.java`  
 - https://stackoverflow.com/questions/22584427/what-is-compiler-compliance-level-in-eclipse


### Code Annotations
 - Wow, this stuff is pretty bad
 - No comments, anywhere
 - And so much of the code is commented-out


### Correct File?
 - `Custom.Java`


### Missing Packages
 - https://asm.ow2.io/
 - https://testng.org/doc/
 - https://junit.org/junit5/
 - http://jdom.org/downloads/
 - Apparently these are tied up in the `.jar` files
 - These only import properly inside of _eclipse_.
 - https://github.com/redhat-developer/vscode-java/issues/346


### Zoom Level
 - So, apparently your own fireball are enemies
 - You need to set the zoom level to see anything appropriately
 - z_level = 1 sees >= 80
 - enemy = 2, fireball = 25


### Generate More Levels
 - I got a different level
 - Just uncomment almost all the code in main
 - Then change the seed value
 - You also have to make the one method public and you also have to import a couple more modules
 - Eclipse will tell you which ones, so it is really quick and easy


### Keyboard Commands
 - Movement
     - `<-`:    left
     - `->`:    right
     - `^`:     fly up
     - `v`:     fly down
     - `a`:     run
     - `s`:     jump
     - `f`:     fly
 - Screen
     - `z`:     bigger
     - `c`:     center
     - `r`:     record
 - Debug
     - `g`:     grid
     - `l`:     positions
     - `v`:     new seed
     - `w`:     quit
    


---------


## Trees


### Notation Styles
```yaml

# === Keywords ===
# text                          # Human Comment
let "peter.tasks.loop" = loop   # Import
blah                            # Task
root:                           # Entry Point

# === Syntax ===
blah:                           # Composite Task
blah!                           # Active Task
blah?                           # C

# ===

```


### Basic Guard AI (Full)
```yaml
root:
    select:
        select:
            enemies?
            select:
                iSeeEnemies?
                attack!
            guard!
        returnToPost!
```


### Basic Guard AI (Condensed)
```yaml
root:
    enemies?
        iSeeEnemies?
            attack!
        guard!
    returnToPost!
```


### Basic Agent Tree
```yaml
# Basic Agent Tree
root:
    select:
        strat1 # coins
        strat2 # kills
        strat3 # time

# Collecting Coins
strat1:
    empty

# Collecting Kill
strat2:
    empty

# Saving Time
strat3:
    empty
```

---------

