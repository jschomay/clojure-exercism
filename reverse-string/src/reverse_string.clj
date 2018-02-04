(ns reverse-string)

(defn reverse-string [input]
  (reduce #(str %2 %1) "" input))

