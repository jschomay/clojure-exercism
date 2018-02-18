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
  (let [parts (re-seq #"(\d+)(\w)|\w" s)
        clean #(map (partial filter identity) %) 
        expand (fn [acc [full n c :as part]]
                (if (= 1 (count part))
                  (str acc full)
                  ; (str acc m)))]
                  (str acc (apply str (repeat (Integer/parseInt n 10) c)))))]
    ; (clean parts)))
    (reduce expand "" (clean parts))))


(run-length-decode 
  (run-length-encode "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"))
