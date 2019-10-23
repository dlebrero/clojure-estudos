(ns calculator.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [calculator.handler :refer :all]))

; TODO: Corrigir teste da adição.
(deftest test-app
  (testing "Testando função de adição."
    (is (= (app (-> (mock/request :post "/api/sum")
                    (mock/json-body {:x 1 :y 2})))
           {:status 200
            :body   {:status 200 :result 3}}))))