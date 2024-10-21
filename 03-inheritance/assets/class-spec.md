```
@startuml
'left to right direction

class Cat {
	-sleep: int
    -awake: int
    -digest: int

    -currentState: State

    -name: String
    
    +void feed()
    +void tick()

    +boolean isAsleep()
    +boolean isPlayful()
    +boolean isHungry()
    +boolean isDigesting()
    +boolean isDead()

    +int getSleep()
    +int getDigest()
    +int getAwake()
    +String getName()
}

abstract class State {
	#{static}logger: Logger
    #t: int
    #duration: int
    State tick(cat: Cat)
    abstract State successor(cat: Cat)
}

class DigestingState extends State {
}

class HungryState extends State {
    State feed(c: Cat)
}

class PlayfulState extends State {
}

class SleepingState extends State {
}

class DeathState extends State {
}

State --* Cat : current state

@enduml
