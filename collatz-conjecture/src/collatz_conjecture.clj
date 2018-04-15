(ns collatz-conjecture)

(defn collatz [n]
  (loop [i 0 new-n n]
    (cond
      (= 0 new-n) (throw (IllegalArgumentException. "Can't be zero"))
      (> 0 new-n) (throw (IllegalArgumentException. "Must be positive."))
      (= 1 new-n) i
      (even? new-n) (recur (inc i) (/ new-n 2))
      :else (recur (inc i) (+ (* 3 new-n) 1)))))
