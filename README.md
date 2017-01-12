# CEIT channel Bot
## Introduction
This telegram bot is used to help notify admins of channel about new news and homeworks.  
You can access this bot at telegram by @ceit93bot.
## Installation
For personal use there is a file in the ```src/main/resources``` named ```user-test.conf```
replace the ```hashId``` with your own bot hash id obtained from telegram bot father,
and also provide the ```username``` with your bot user name.  
The simply
```
git clone https://github.com/tabrizian/ceit93bot
docker build . -t tabrizian/ceit93bot
docker run -d tabrizian/ceit93bot
```
## TODO
- [x] Add reply
- [ ] Add question asking support
- [x] Add support for file
- [ ] Enabling sending messages to channel from bot
