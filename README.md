# todoapp



## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.
[leiningen]: https://github.com/technomancy/leiningen

Install postgress and start at default port.

Create db name "todo" using "createdb todo". Also update user and password in file src/todoapp/database.clj

Create a table items: CREATE TABLE items ( id    serial PRIMARY key, title  VARCHAR(100) );

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2015 FIXME
# clojure-todoapp
