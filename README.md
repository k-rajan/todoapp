# todoapp
Sample web app in clojure created using ring, compojure, hiccup, korma, lobos and postgress.

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.
[leiningen]: https://github.com/technomancy/leiningen


## Database setup

You will need to install postgress and start postgress.
Also create database with name todo using following command on terminal after installing postgress:

    createdb todo

Also update user and password in file src/todoapp/config.clj


## Running

To start a web server for the application, run:

    lein ring server


## License

Copyright © 2015
# clojure-todoapp
