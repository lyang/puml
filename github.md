# GitHub

*Pattern*: /github/{owner}/{repo}/blob/{commit}/{path}

*Example*: https://puml-demo.herokuapp.com/github/lyang/puml/blob/main/github.md
```
@startuml
puml->GitHub: Hello
caption Generated at %date("yyyy-MM-dd HH:mm:ss z")
@enduml
```
[![demo](https://puml-demo.herokuapp.com/github/lyang/puml/blob/main/github.md)](https://puml-demo.herokuapp.com/github/lyang/puml/blob/main/github.md)

*Pattern*: /github/{owner}/{repo}/blob/{commit}/{path}?pumlIndex={n}

*Example*: https://puml-demo.herokuapp.com/github/lyang/puml/blob/main/github.md?pumlIndex=1
```
@startuml

participant browser as b
participant puml as p
participant GitHub as gh

b->p: GET /github/lyang/puml/blob/main/github.md?pumlIndex=1
p->gh: GET https://api.github.com/
gh->p: Plain Text
p->b: PNG

caption Generated at %date("yyyy-MM-dd HH:mm:ss z")

@enduml
```
[![demo](https://puml-demo.herokuapp.com/github/lyang/puml/blob/main/github.md?pumlIndex=1)](https://puml-demo.herokuapp.com/github/lyang/puml/blob/main/github.md?pumlIndex=1)

### Rendering protected sources
Protected sources can be accessed by setting up credentials in config file, for [example](puml-demo.yaml)

*Example*: https://puml-demo.herokuapp.com/github/lyang/puml-demo/blob/main/github.md
[![demo](https://puml-demo.herokuapp.com/github/lyang/puml-demo/blob/main/github.md)](https://puml-demo.herokuapp.com/github/lyang/puml-demo/blob/main/github.md)

### Rendering for GitHub Enterprise Instances
GHE instance, even multiple instances, are also supported, via [host mapping](puml-demo.yaml).

*Pattern*: /github/{key}/{owner}/{repo}/blob/{branch}/{path}

Host mapping for `{key}` needs to be configured in `config.yaml`, for [example](puml-demo.yaml).

*Example*: https://puml-demo.herokuapp.com/github/ghe/lyang/puml-demo/blob/main/github.md
[![demo](https://puml-demo.herokuapp.com/github/ghe/lyang/puml-demo/blob/main/github.md)](https://puml-demo.herokuapp.com/github/ghe/lyang/puml-demo/blob/main/github.md)

**NOTE**: Unfortunately I don't have a GHE instance to properly demo this, so instead I'm mapping `ghe` to `github.com` for this case.
