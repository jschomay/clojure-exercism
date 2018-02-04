(ns bob
  (:require [clojure.string :refer (trim upper-case)]))

(defn shouting [input]
  (and
   ((comp not empty? (partial filter #(Character/isLetter %))) input )
   (= input (upper-case input))))

(defn response-for [input]
  (cond
    (= "" (trim input)) "Fine. Be that way!"
    (shouting input) "Whoa, chill out!"
    (= (last input) \?) "Sure."
    :else "Whatever."))
