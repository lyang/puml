# puml
Render diagrams from the Internet using [plantuml](https://github.com/plantuml/plantuml).

## From the Internet
```
@startuml
puml->World: Hello
caption Generated at %date[yyyy-MM-dd HH:mm:ss z]%
@enduml
```
The above is rendered below
[![demo](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md)](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md)

```
@startuml

participant browser as b
participant puml as p
participant Internet as i

b->p: GET /raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md?pumlIndex=1
p->i: GET https://raw.githubusercontent.com/lyang/puml/master/README.md
i->p: Plain Text
p->b: PNG

caption Generated at %date[yyyy-MM-dd HH:mm:ss z]%

@enduml
```
The above is rendered below
[![demo](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md?pumlIndex=1)](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md?pumlIndex=1)
