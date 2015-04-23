(ns todoapp.migrations
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  (:use (lobos [migration :only [defmigration]] core schema))
  (:require [todoapp.config]))

;;;;wrapper methods
(defn run-migrations []
  (binding [lobos.migration/*migrations-namespace* 'todoapp.migrations]
    (migrate)))

(defn run-rollbacks []
  (binding [lobos.migration/*migrations-namespace* 'todoapp.migrations]
    (rollback)))

;;;; migrations
(defmigration create-items-schema
              (up (create
                    (table :items
                           (integer :id :auto-inc :primary-key)
                           (varchar :title 100))))
              (down (drop (table :items ))))