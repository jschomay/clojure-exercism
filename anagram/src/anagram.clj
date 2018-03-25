(ns anagram
  (:require  [clojure.string :as s]))

(defn equal-with
  "Makes a comparison by first running the supplied arguments through the supplied function."
  [f & args]
  (apply = (map f args)))

(defn anagrams-for [word candidates]
  (filter #(and
            (not (equal-with s/lower-case word %))
            (equal-with (comp sort s/lower-case) word %))
          candidates))
