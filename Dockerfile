FROM openjdk:11
COPY ./* /app/
WORKDIR /app/
RUN javac getsym.java
WORKDIR /app/output