FROM ubuntu
Maintainer Iman Tabrizian <tabrizian@outlook.com>

# Install Packages
RUN add-apt-repository ppa:webupd8team/java
RUN add-apt-repository ppa:cwchien/gradle
RUN apt-get update
RUN apt-get install -y oracle-java8-installer gradle-2.1 git

