FROM niaquinto/gradle
Maintainer Iman Tabrizian <tabrizian@outlook.com>

# Install Packages
WORKDIR /root/ceit93bot
COPY . .

# Entry Point
ENTRYPOINT ["gradle", "run"]

