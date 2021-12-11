# GitLab

*Pattern*: /gitlab/projects/{repo}/files/{commit}/{path}

*Example*: https://puml-demo.herokuapp.com/gitlab/projects/32006361/files/master/gitlab.md
```
@startuml
puml->GitLab: Hello
caption Generated at %date("yyyy-MM-dd HH:mm:ss z")
@enduml
```
[![demo](https://puml-demo.herokuapp.com/gitlab/projects/32006361/files/master/gitlab.md)](https://puml-demo.herokuapp.com/gitlab/projects/32006361/files/master/gitlab.md)

*Pattern*: /gitlab/projects/{repo}/files/{commit}/{path}?pumlIndex={n}

*Example*: https://puml-demo.herokuapp.com/gitlab/projects/32006361/files/master/gitlab.md?pumlIndex=1
```
@startuml

participant browser as b
participant puml as p
participant GitLab as gl

b->p: GET /gitlab/projects/32006361/files/master/gitlab.md?pumlIndex=1
p->gl: GET https://gitlab.com/api/v4
gl->p: Plain Text
p->b: PNG

caption Generated at %date("yyyy-MM-dd HH:mm:ss z")

@enduml
```
[![demo](https://puml-demo.herokuapp.com/gitlab/projects/32006361/files/master/gitlab.md?pumlIndex=1)](https://puml-demo.herokuapp.com/gitlab/projects/32006361/files/master/gitlab.md?pumlIndex=1)

### Rendering protected sources
Protected sources can be accessed by setting up credentials in config file, for [example](puml-demo.yaml)

*Example*: https://puml-demo.herokuapp.com/gitlab/projects/32007598/files/master/gitlab.md
[![demo](https://puml-demo.herokuapp.com/gitlab/projects/32007598/files/master/gitlab.md)](https://puml-demo.herokuapp.com/gitlab/projects/32007598/files/master/gitlab.md)

### Rendering for Private GitLab Instances
Private GitLab instance, even multiple instances, are also supported, via [host mapping](puml-demo.yaml).

*Pattern*: /gitlab/{key}/projects/{repo}/files/{commit}/{path}

Host mapping for `{key}` needs to be configured in `config.yaml`, for [example](puml-demo.yaml).

*Example*: https://puml-demo.herokuapp.com/gitlab/gle/projects/32007598/files/master/gitlab.md
[![demo](https://puml-demo.herokuapp.com/gitlab/gle/projects/32007598/files/master/gitlab.md)](https://puml-demo.herokuapp.com/gitlab/gle/projects/32007598/files/master/gitlab.md)

**NOTE**: Unfortunately I don't have a private gle instance to properly demo this, so instead I'm mapping `gle` to `gitlab.com` for this case.
