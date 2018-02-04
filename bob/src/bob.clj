(ns bob)

(defn response-for [input]
  (cond
    (->> input (filter #(Character/isAlphabetic %)) (every? #(Character/isUpperCase %))) "Woah, chill out!"
    :else "Whatever"))
