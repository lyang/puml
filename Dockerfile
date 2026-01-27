FROM gradle:jdk17 AS builder
RUN mkdir /home/gradle/puml
COPY *.gradle /home/gradle/puml/
COPY src /home/gradle/puml/src
WORKDIR /home/gradle/puml
RUN gradle clean installDist

FROM eclipse-temurin:17-jre
RUN apt-get update && \
    apt-get install -y --no-install-recommends graphviz unifont && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*
COPY --from=builder /home/gradle/puml/build/install/puml /app
COPY config.yaml /app
CMD ["/app/bin/puml", "server", "/app/config.yaml"]
