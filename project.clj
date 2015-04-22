(defproject todoapp "0.1.0-SNAPSHOT"
  :description "clojure bootcamp"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.3"]
                 [ring/ring-json "0.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [korma "0.3.3"]
                 [postgresql "9.1-901.jdbc4"]
                 [hiccup "1.0.5"]]

  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler todoapp.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
