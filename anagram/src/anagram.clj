(ns anagram)

(defn anagrams-for [word candidates]
  (let [lower-word (clojure.string/lower-case word)
        check #(and
                (not= lower-word %)
                (= (sort lower-word) (sort (clojure.string/lower-case %))))]
    (filter check candidates)))
