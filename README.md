# Puml [![Build Status](https://travis-ci.com/lyang/puml.svg?branch=master)](https://travis-ci.com/lyang/puml)
A java app for rendering [plantuml](https://github.com/plantuml/plantuml) diagrams sourced from the Internet.

## Usage
*Pattern*: https://\<host>/raw/\<url-encoded-target-address>
  
*Example*: https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md
```
@startuml
puml->World: Hello
caption Generated at %date[yyyy-MM-dd HH:mm:ss z]%
@enduml
```
[![demo](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md)](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md)

*Pattern*: https://\<host>/raw/\<url-encoded-target-address>?pumlIndex=1

*Example*: https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md?pumlIndex=1
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
[![demo](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md?pumlIndex=1)](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmaster%2FREADME.md?pumlIndex=1)

### Rendering protected sources
Protected sources can be accessed by setting up credentials in config file, for [example](https://github.com/lyang/puml/blob/master/puml-demo.yaml)

[![demo](http://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml-demo%2Fmaster%2FREADME.md)](http://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml-demo%2Fmaster%2FREADME.md)

## Development
Dependency: `bazel-0.21.0`, `graphviz`

### Java
Building the fat jar:
```
bazel build //:puml_deploy.jar
```
Run it locally:
```
bazel run //:puml -- server ${PWD}/config.yaml
```
To update dependency version, edit `third-party/deps.yaml`. To add new dependencies:
```
./script/deps.sh add <maven-coordinate>
```
For IDE, I use IntelliJ CE + [bazel plugin](https://plugins.jetbrains.com/plugin/8609-bazel)

### Docker
Prebuilt images are at: `linyang1218/puml:latest` (Docker Hub)

Building the image locally
```
bazel run //:docker
```
Push the image
```
bazel run //:docker-push
```

## Deployment
A demo app is deployed to https://puml-demo.herokuapp.com via `.travis.yml`
