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
  (let [parts (re-seq #"\d+\w|\w" s)
        is-digit (comp #(when %1 "is-digit") (partial re-matches #"\d") str)
        partitioned (partial partition-by is-digit)
        to-digit (partial reduce str)
        step (fn [acc v] (reduce str v))]
    ; (reduce step "" partitioned)))
    parts))


(run-length-decode 
  (run-length-encode "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"))
