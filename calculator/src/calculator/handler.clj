(ns calculator.handler
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn welcome [request]
  (if (= "/" (:uri request))
    {:status  200
     :body    "<h1>Hello, Clojure World</h1>
            <p>Welcome to your first Clojure app, I now update automatically<p>"
     :headers {}}
    {:status  404
     :body    "<h1>This is not the page you are looking for</h1>
            <p>Sorry, the page you requested was not found!</p>"
     :headers {}}))

(defn -main "A very simple calculator" [port-number]
  (jetty/run-jetty welcome
                   {:port (Integer. port-number)}))

(defn -dev-main [port-number]
  (jetty/run-jetty (wrap-reload #'welcome)
                   {:port (Integer. port-number)}))
