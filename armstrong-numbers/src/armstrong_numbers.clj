(ns armstrong-numbers)

(defn armstrong?
  [n]
  (let [digits (loop [remaining n acc []]
                 (if (zero? remaining)
                   acc
                   (recur (quot remaining 10) (cons (mod remaining 10) acc))))
        length (count digits)
        exponents (map #(Math/pow % length) digits)
        summed (reduce + exponents)]
    (== n summed)))
