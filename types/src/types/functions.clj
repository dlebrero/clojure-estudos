(ns types.functions)

(defn greet []
  (println "Hello"))

(greet)

(def greet
  (fn [] (println "Hello.")))

(greet)

(def greet
  #(println "Hello"))

(greet)

(defn greeting
  ([] (greeting "Hello" "World"))
  ([x] (greeting "Hello" x))
  ([x y] (str x ", " y "!")))

(require '[clojure.repl :refer :all])
(doc str)

(greeting "Peter")

(defn do-nothing [x]
  x)

(do-nothing "LALA")

(defn always-things [& xs]
  100)

(always-things Integer/MAX_VALUE)

(defn make-thingy [x]
  (fn [& args] x))

(make-thingy "Peter")

(defn triplicate [f]
  (f) (f) (f))

(triplicate (make-thingy "PETER"))

(defn opposite [f]
  (fn [& args] (not (apply f args))))

(opposite (triplicate (make-thingy "PETER")))

(defn triplicate2 [f & args]
  (triplicate (fn [] (apply f args))))

(triplicate2 (println "Teste"))

(Math/cos Math/PI)

(+ (Math/pow (Math/sin 0.2) 2)
   (Math/pow (Math/cos 0.2) 2))

(defn http-get [url]
  (slurp
    (.openStream
      (java.net.URL. url))))

(defn http-get [url]
  (slurp url))

(http-get "http://google.com.br")

;(defn one-less-arg [f x]
;  (fn [& args (apply f x args)]))

(defn two-fns [f g]
  (fn [x] (f (g x))))

; Anonymous functions syntax

; Equivalent to: (fn [x] (+ 6 x))
#(+ 6 %)

; Equivalent to: (fn [x y] (+ x y))
#(+ %1 %2)

; Equivalent to: (fn [x y & zs] (println x y zs))
#(println %1 %2 %&)

