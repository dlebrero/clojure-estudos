(defproject calculator "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring "1.7.1"]
                 [compojure "1.6.1"]]
  :main calculator.handler
  :profiles {:dev {:main calculator.handler/-dev-main}})
