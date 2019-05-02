# puml

```
@startuml

participant browser as b
participant "puml" as p
participant api.github.com as g

b->p: GET /github/gh/lyang/puml/README.md
p->g: GET /repos/lyang/puml/contents/README.md
g->p: file
p->p: file->PNG
p->b: PNG

caption Generated at %date[yyyy-MM-dd HH:mm:ss z]%

@enduml
```