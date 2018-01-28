(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn explode-to-digits [number]
  (map #(Character/digit % 10) (seq (str number))))

(defn armstrong?
  [n]
  (let [digits (explode-to-digits n)
        exponents (fn [x] ( map #(math/expt (int %) (count x)) x))]
    (= n (reduce + ( exponents digits )))))
