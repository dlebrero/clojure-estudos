(ns clojure.learn.functions)

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

; Applying Functions

; Apply

(defn plot [shape coords]
  (apply plotxy shape coords))

; Locals and Closures

; let
(let [x 1
      y 2]
  (+ x y))

(defn capitalize-words [s]
  (->> (clojure.string/split (str s) #"\b")
       (map clojure.string/capitalize)
       clojure.string/join))

(defn messenger [msg]
  (let [a 7
        b 5
        c (capitalize-words msg)]
    (println a b c)
    )
  )

(messenger "peter admilson ramaldes")

; Closures

; The `fn` special form creates a "closure". It "closes over" the surrounding lexical scope (like `msg`, `a`, `b`, or `c` above)
; and caputes their values beyond the lexical scope.

(defn messenger-builder [greeting]
  (fn [who] (println greeting who)))                        ; closes over greeting

; greeting provided here, then goes out of scope.
(def hello-er (messenger-builder "Hello"))

; greeting value still available because hello-er is a closure
(hello-er "World!")

(defn greet []
  println "Hello 1")

(greet)

(def greet
  (fn [] println "Hello 2"))

(greet)

(def greet
  #(println "Hello 3"))

(greet)

(defn greeting []
  (str "Hello, World!"))

(assert (= "Hello, World!" (greeting)))

(defn greeting [x]
  (str "Hello, " x "!"))
(assert (= "Hello, Clojure!" (greeting "Clojure")))

(defn greeting [x y]
  (str x ", " y "!"))

(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

(defn do-nothing [x]
  identity x)

(do-nothing 3)

(source identity)

(defn always-things [& x]
  100)

(always-things 1 2 3 4 5)

(defn make-thingy [x]
  (constantly x))

(defn make-thingy [x]
  x)

(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f 123)))
  (assert (= n (apply f 123 (range)))))

(source constantly)

(defn triplicate [f]
  (f) (f) (f))

(triplicate (println 2))

(defn calculate [x]
  (= (+ (Math/pow (Math/sin x) 2) (Math/pow (Math/cos x) 2) ) 1))

(defn http-get [url]
  (slurp
    (.openStream
      (java.net.URL. url))))

(http-get "http://google.com")