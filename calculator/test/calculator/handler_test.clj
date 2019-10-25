(ns calculator.handler-test
  (:require [clojure.test :refer :all]
            [cheshire.core :as cheshire]
            [ring.mock.request :as mock]
            [calculator.handler :refer :all]))

(defn parse-body [body]
  (cheshire/parse-string body true))

(deftest test-app

  (testing "Testando função de adição."
    (let [response (app (-> (mock/request :get "/api/sum?x=2&y=3")))
          body (parse-body (:body response))]
      (is (= (:status response) 200))
      (is (= (:result body) 5)))))
