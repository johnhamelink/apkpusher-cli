apkpusher-cli
=============

Java Client for APKPusher that can be integrated into your deployment process.

APKPusher is a small android app that sits in the background and runs a simple TCP SocketServer.
This allows you to quickly push apps over your local network or the internet.

This java application is a small, simple application that handles the relatively simple task of pushing the
file to the phone. Because it is small and self-contained, it could be deployed on a vast number of different
devices, which could lead to some exiting possibilities.

Some examples of situations where git pushing could be done:

 - As part of a git hook
 - After a successful jenkins build
 - From another android phone
 - On a cron-job attached to a [retrocabulator](http://www.youtube.com/watch?v=RXJKdh1KZ0w) in order to synchronise cardinal gram-meters effectively.
