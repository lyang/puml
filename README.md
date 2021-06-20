# Puml [![Build Status](https://travis-ci.com/lyang/puml.svg?branch=master)](https://travis-ci.com/lyang/puml)
A java app for rendering [plantuml](https://github.com/plantuml/plantuml) diagrams sourced from the Internet.

## Usage
*Pattern*: /github/{owner}/{repo}/blob/{commit}/{path}
  
*Example*: https://puml-demo.herokuapp.com/github/lyang/puml/blob/master/README.md
```
@startuml
puml->World: Hello
caption Generated at %date[yyyy-MM-dd HH:mm:ss z]%
@enduml
```
[![demo](https://puml-demo.herokuapp.com/github/lyang/puml/blob/master/README.md)](https://puml-demo.herokuapp.com/github/lyang/puml/blob/master/README.md)

*Pattern*: /github/{owner}/{repo}/blob/{commit}/{path}?pumlIndex={n}

*Example*: https://puml-demo.herokuapp.com/github/lyang/puml/blob/master/README.md?pumlIndex=1
```
@startuml

participant browser as b
participant puml as p
participant Internet as i

b->p: GET /github/lyang/puml/blob/master/README.md?pumlIndex=1
p->i: GET https://api.github.com/
i->p: Plain Text
p->b: PNG

caption Generated at %date[yyyy-MM-dd HH:mm:ss z]%

@enduml
```
[![demo](https://puml-demo.herokuapp.com/github/lyang/puml/blob/master/README.md?pumlIndex=1)](https://puml-demo.herokuapp.com/github/lyang/puml/blob/master/README.md?pumlIndex=1)

### Rendering protected sources
Protected sources can be accessed by setting up credentials in config file, for [example](https://github.com/lyang/puml/blob/master/puml-demo.yaml)

[![demo](https://puml-demo.herokuapp.com/github/lyang/puml-demo/blob/master/README.md)](https://puml-demo.herokuapp.com/github/lyang/puml-demo/blob/master/README.md)

## Development
Dependency: `gradle-7.1`, `graphviz`

### Java
Building the fat jar:
```
gradle build
```
Run it locally:
```
gradle run --args="server config.yaml"
```
For IDE, I use IntelliJ CE

### Docker
Prebuilt images are at: `linyang1218/puml:latest` (Docker Hub)

## Deployment
A demo app is deployed to https://puml-demo.herokuapp.com via `.travis.yml`
