# Puml [![Build](https://github.com/lyang/puml/actions/workflows/build.yml/badge.svg)](https://github.com/lyang/puml/actions/workflows/build.yml) ![CodeQL](https://github.com/lyang/puml/actions/workflows/codeql-analysis.yml/badge.svg) [![Maintainability](https://api.codeclimate.com/v1/badges/1c8292cb6b9e937d5c53/maintainability)](https://codeclimate.com/github/lyang/puml/maintainability)
A java app for rendering [plantuml](https://github.com/plantuml/plantuml) diagrams sourced from the Internet.

## Usage

### GitHub
*Pattern*: /github/{owner}/{repo}/blob/{commit}/{path}

*Example*: https://puml-demo.herokuapp.com/github/lyang/puml/blob/main/github.md

[![demo](https://puml-demo.herokuapp.com/github/lyang/puml/blob/main/github.md)](https://puml-demo.herokuapp.com/github/lyang/puml/blob/main/github.md)

More examples can be found in [github.md](github.md)

### GitLab
*Pattern*: /gitlab/projects/{repo}/files/{commit}/{path}

*Example*: https://puml-demo.herokuapp.com/gitlab/projects/32006361/files/main/gitlab.md

[![demo](https://puml-demo.herokuapp.com/gitlab/projects/32006361/files/main/gitlab.md)](https://puml-demo.herokuapp.com/gitlab/projects/32006361/files/main/gitlab.md)

More examples can be found in [gitlab.md](gitlab.md)

### Raw
*Pattern*: /raw/{url}

*Example*: https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmain%2Fgithub.md

[![demo](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmain%2Fgithub.md)](https://puml-demo.herokuapp.com/raw/https%3A%2F%2Fraw.githubusercontent.com%2Flyang%2Fpuml%2Fmain%2Fgithub.md)

## Authenticated Resources
For resources requiring authentication (like private repos), [Credential](src/main/java/lyang/puml/configurations/Credential.java) can be configured for it. So far, only [AuthorizationHeader](src/main/java/lyang/puml/configurations/AuthorizationHeader.java) is implemented.

Credentials will only be used when the configured url pattern matches the outbound request. Examples can be found in [puml-demo.yaml](puml-demo.yaml)

## Proxy Authentication
If proxy authentication is required, it auto retries the request using `http(s).proxyUser` and `http(s).proxyPassword` system property.

## Development
Dependency: `gradle-7.3.1`, `graphviz`

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
Prebuilt images are at: `linyang1218/puml:{commit}` (Docker Hub)

## Deployment
A demo app is deployed to https://puml-demo.herokuapp.com via `.travis.yml`
