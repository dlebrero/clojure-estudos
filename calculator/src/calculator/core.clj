(ns calculator.core)

(defn addition [x y]
  (+ (Long/parseLong x)  (Long/parseLong y)))
