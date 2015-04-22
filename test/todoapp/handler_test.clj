(ns todoapp.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [todoapp.handler :refer :all]))

(deftest route-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 404))
      (is (= (:body response) "Not Found"))))

  (testing "hello world"
    (let [response (app (mock/request :get "/hello"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
