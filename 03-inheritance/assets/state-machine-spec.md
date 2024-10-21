```
@startuml
[*] --> Sleeping
Hungry --> Dead : not fed
Dead --> [*]
Hungry --> Digesting : fed
Digesting --> Playful
Playful --> Sleeping
Sleeping --> Hungry
@enduml
```