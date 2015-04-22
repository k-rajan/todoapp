(ns todoapp.controller
  (:use ring.util.response todoapp.query)
  (:require
    [clojure.string :as str]
    [todoapp.views.layout :as layout]
    [todoapp.views.contents :as contents]))


(defn parse-int [s]
  ;(Integer. (re-find  #"\d+" s ))
  (read-string s)
  )

(defn index []
  (layout/application "List" (contents/index (get-todos)) ))

(defn new []
  (layout/application "Create" (contents/new) ))

(defn edit [id]
  (layout/application "Edit" (contents/edit (get-todo (parse-int id))) ))

(defn create [title]
  (add-todo title)
  (redirect "/todos"))

(defn update [id title]
  (update-todo id title)
  (redirect "/todos"))



