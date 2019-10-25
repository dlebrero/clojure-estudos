(ns calculator.handler
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.handler.dump :refer [handle-dump]]))
(defn welcome [request]
  {:status  200
   :body    "<h1>Hello, Clojure World</h1>
            <p>Welcome to your first Clojure app, I now update automatically<p>"
   :headers {}})

(defn goodbye [request]
  {:status  200
   :body    "<h1>Walking back to happiness</h1>
          <p>Walking back to happiness with you</p>
          <p>Said, Farewell to loneliness I knew</p>
          <p>Laid aside foolish pride</p>
          <p>Learnt the truth from tears I cried</p>"
   :headers {}})

(defn about
  "Information about the website developer"
  [request]
  {:status  200
   :body    "I am an awesome Clojure developer, well getting there..."
   :headers {}})

(defn hello [request]
  (let [name (get-in request [:route-params :name])]
    {:status  200
     :body    (str "Hello " name ". I got your name from the web URL.")
     :headers {}}))

(defroutes app
           (GET "/" [] welcome)
           (GET "/goodbye" [] goodbye)
           (GET "/about" [] about)
           (GET "/request-info" [] handle-dump)
           (GET "/hello/:name" [] hello)
           (not-found "<h1>This is not the page you are looking for</h1>
                  <p>Sorry, the page you requested was not found!</p>"))

(defn -main "A very simple calculator" [port-number]
  (jetty/run-jetty app
                   {:port (Integer. port-number)}))

(defn -dev-main [port-number]
  (jetty/run-jetty (wrap-reload #'app)
                   {:port (Integer. port-number)}))
