(ns types.types)
(require '[clojure.repl :refer :all])

'(1 2 3)
[1 2 3]
#{1 2 3}

{:a 1 :b 2}

(doc +)

(+ 123123 Integer/MAX_VALUE)

(apropos "+")

(find-doc "trim")

(dir clojure.repl)

(source dir)

(def x 7)

(println "What is this: " (+ 1 2))

(println "one\n\ttwo")

(+ 7654 1234)

;( 7 + 3 * 4 + 5 ) / 10.
 (/ (+ (+ (* 3 4) 5) 7) 10)
(rem 12 5)

(* 3 4)

(find-doc "stack trace")

(doc rem)

(pst)