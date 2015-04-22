(ns todoapp.views.contents
  (:use [hiccup.core :only (h)]
        [hiccup.page :only (html5 include-css)]
        [hiccup.form :only (form-to)]
        [hiccup.util :only (url)]))

(defn index [items]
  [:div
   [:a {:href "/todos/new"} [:p 'Add]]
   [:table {:class "table"}
    [:thead [:tr {:class "row"} [:th 'id] [:th 'todo] [:th 'action]]]
    [:tbody
     (map
       (fn [item]
         [:tr {:class "row"}
          [:td {:class "col-xs-2"} (h (:id item))]
          [:td {:class "col-xs-2"} (h (:title item))]
          [:td {:class "col-xs-2"}
           [:a {:href (url "/todos/" (:id item) "/edit")} "edit"]]])
       items)]]

   ])

(defn new []
  (form-to
    [:post "/todos"]
    [:fieldset
     [:h3 "Title"]
     [:input {:type "text" :name "title"}]
     [:input {:type "submit" :value "create" :class "btn btn-lg btn-primary"}]]))

(defn edit [item]
  (form-to
    [:post "/todos"]
    [:fieldset
     [:h3 "Title"]
     [:input {:type "text" :name "title" :value (:title item)}]
     [:input {:type "submit" :value "save" :class "btn btn-lg btn-primary"}]]))