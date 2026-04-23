This is the program made by the Javastrophe group for Chula's Information and Communication Engingeering program's Advanced Computer Programming Course, it is called "Boss Fight". In this program, you pick 3 characters who will fight various foes. You can even create your own character to join the fight. It takes place inside the terminal, basically a text adventure.

Create a party of three heroes as you venture into the throes of battle. Choose pre-built, or make your own. With 3 unique bosses to fight, can you overcome this challenge?
Run the file "RunGame.bat" to run the game

The program is built on java and uses 3 main patterns, Factory, Strategy, and Singleton.

Javastrophe Group Members :
Satetawut Kosintrakarn (Atom) #6838312121
Vathadee Chokwatana (Web) #6838283621
Elena-Alexandra Ciobotaru (Alexandra) #6802027529

Boss-Fight-Simulator
└── src
    ├── Characters
    │   ├── Character
    │   ├── CharacterCreator
    │   └── CharacterFactory
    │
    ├── Game
    │   └── Main
    │
    ├── Manager
    │   ├── GamePrinter
    │   ├── InputUtil
    │   ├── StatusDisplay
    │   │
    │   ├── MainLoop
    │   │   ├── GameLoop
    │   │   ├── GameManager
    │   │   ├── GameSetup
    │   │   └── GameState
    │   │
    │   └── TurnLogic
    │       ├── BossAI
    │       └── TurnHandler
    │
    └── Skills
        ├── Skill (interface)
        │
        ├── Attacks
        │   ├── ChaosSkill
        │   ├── CrossSlashSkill
        │   ├── FireBreathSkill
        │   ├── FireballSkill
        │   ├── HolyPierceSkill
        │   ├── KnifeThrowSkill
        │   ├── LifeSapSkill
        │   ├── MagicMissileSkill
        │   ├── PreciseCutSkill
        │   ├── RockThrowSkill
        │   ├── SlashSkill
        │   ├── SmashSkill
        │   └── TailSwipeSkill
        │
        ├── Buffs
        │   ├── ChargeSkill
        │   └── GuardSkill
        │
        └── Healing
            ├── FirstAidSkill
            ├── HideSkill
            ├── HolyBlessingSkill
            └── MarshallingShoutSkill
