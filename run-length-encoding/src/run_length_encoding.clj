(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [s]
  (let [partitioned (partition-by identity s)
        display-count (fn [tail] (when (seq tail) (+ 1 (count tail))))
        step (fn [acc [c & tail]] (str acc (display-count tail) c))]

    (reduce step "" partitioned)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [s]
  (let [is-digit (comp #(when %1 "is-digit") (partial re-matches #"\d") str)
        ; TODO not quite right
        partitioned (partition-by is-digit s)
        to-digit (partial reduce str)
        step (fn [acc v] (reduce str v))]
    ; (reduce step "" partitioned)))
    (map to-digit partitioned)))


(run-length-decode 
  (run-length-encode "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"))
