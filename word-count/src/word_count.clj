(ns word-count)

(defn word-count [s]
  (letfn [ ( pre-process [s]
             (->
               s
               (clojure.string/lower-case)  
               (clojure.string/replace #"[^\w\s]" "")
               (clojure.string/split #"\s+")))

          ( analyze [s]
            (->> 
              s
              (sort)
              (partition-by identity)
              (map (fn [items] [(first items) (count items)]))
              (into {})))]

      ((comp analyze pre-process) s)))
