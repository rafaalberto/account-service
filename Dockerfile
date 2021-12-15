FROM gradle:7.2-jdk11-alpine as builder
LABEL maintainer="rafael.alberto1703@gmail.com"
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM adoptopenjdk/openjdk11:alpine
LABEL maintainer="rafael.alberto1703@gmail.com"
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/account-service.jar .
CMD ["java", "-jar", "account-service.jar"]