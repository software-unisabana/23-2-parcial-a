FROM centos:latest
RUN yum install -y java-17-openjdk-devel

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk
ENV PATH=$PATH:$JAVA_HOME/bin

