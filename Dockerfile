FROM gradle:jdk11 AS builder
COPY . /home/gradle/puml
WORKDIR /home/gradle/puml
RUN gradle clean installDist

FROM openjdk:11-buster
RUN apt-get update && \
    apt-get install -y --no-install-recommends graphviz && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*
COPY --from=builder /home/gradle/puml/build/install/puml /app
ENTRYPOINT ["/app/bin/puml"]
CMD ["server"]
