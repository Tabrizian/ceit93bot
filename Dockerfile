FROM niaquinto/gradle
Maintainer Iman Tabrizian <tabrizian@outlook.com>

# Install Packages
RUN cd /root && git clone https://github.com/Tabrizian/ceit93bot
WORKDIR /root/ceit93bot

ENTRYPOINT ["gradle", "run"]

