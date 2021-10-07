FROM openjdk:11
WORKDIR /app/
COPY getsym.java ./
RUN javac getsym.java
