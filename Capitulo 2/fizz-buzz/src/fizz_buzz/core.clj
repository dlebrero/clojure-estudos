(ns fizz-buzz.core
  (:gen-class))

(defn divisivel-por? [numero divisor]
  (zero? (mod numero divisor)))


(defn fizz-buzz [numero]
  (cond
    (and (divisivel-por? numero 3)
          (divisivel-por? numero 5)) "fizzbuzz"
    (divisivel-por? numero 3) "fizz"
    (divisivel-por? numero 5) "buzz"
    :else numero))

(def um-ate-15 (range 1 16))

(map fizz-buzz um-ate-15)
