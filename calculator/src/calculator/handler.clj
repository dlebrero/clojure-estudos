(ns calculator.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [calculator.core :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
           (GET "/api/sum" [x y] (response {:result (addition x y)}))
           (GET "/api/sub" [x y] (response {:result (subtract x y)}))
           (GET "/api/mult" [x y] (response {:result (multiply x y)}))
           (GET "/api/div" [x y] (response {:result (divide x y)}))
           (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))
