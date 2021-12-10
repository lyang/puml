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
