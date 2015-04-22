(ns todoapp.views.layout
  (:use [hiccup.page :only (html5 include-css include-js)]))

(defn application [title & content]
  (html5
         [:head
          [:title title]
          (include-css "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css")
          (include-css "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css")
          (include-js "https://code.jquery.com/jquery-2.1.3.min.js")
          (include-js "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js")
          [:body
           [:div {:class "page-header"}
            [:h1 title]]
           [:div {:class "container-fluid"} content ]]]))

