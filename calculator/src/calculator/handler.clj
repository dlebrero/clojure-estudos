(ns calculator.handler
  (:require [ring.adapter.jetty :as jetty]))

(defn -main "A very simple calculator" [port-number]
  (jetty/run-jetty
    (fn [request] {:status  200
                   :body    "<h1>Hello, Clojure World</h1>  <p>Welcome to your first Clojure app.  This message is returned regardless of the request, sorry</p>"
                   :headers {}})
    {:port (Integer. port-number)}))
