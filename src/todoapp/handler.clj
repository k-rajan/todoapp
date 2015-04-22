(ns todoapp.handler
  (:use ring.util.response todoapp.query)
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [todoapp.views.layout :as layout]
            [todoapp.controller :as todo-controller]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))


(defroutes app-routes
  ;; hello
  (GET "/hello" [] (response "Hello World"))
  ;; json
  (GET "/api/todos" []  (response (get-todos)))
  (GET "/api/todos/:id" [id] "TODO: return a single list item")
  (POST "/api/todos" [title] (response (add-todo title)))
  (PUT "/api/todos/:id" [id] "TODO: update a list item")
  (DELETE "/api/todos/:id" [id] "TODO: delete a list item")
  ;; html
  (GET "/todos" [] (todo-controller/index))
  (GET "/todos/new" [] (todoapp.controller/new))
  (GET "/todos/:id/edit" [id] (todoapp.controller/edit id))
  (POST "/todos/:id/update" [id title] (todo-controller/update id title))
  (POST "/todos" [title] (todo-controller/create title ))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))
