(ns calculator.core)

(defn addition [x y]
  (+ (Long/parseLong x)  (Long/parseLong y)))

(defn subtract [x y]
  (- (Long/parseLong x)  (Long/parseLong y)))

(defn multiply [x y]
  (* (Long/parseLong x)  (Long/parseLong y)))

(defn divide [x y]
  (/ (Long/parseLong x)  (Long/parseLong y)))
