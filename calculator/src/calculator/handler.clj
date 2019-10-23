(ns calculator.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [calculator.core :refer :all]))

(defroutes app-routes
           (POST "/api/sum" {:keys [params]}
             (let [{:keys [x y]} params]
               (response {:status 200
                          :result (addition x y)})))
           (route/resources "/")
           (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))
