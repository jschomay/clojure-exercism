(ns series)

;; non-lazy loop/recur
;; (defn slices [string n]
;;   (if (= n 0)
;;     [""]
;;     (loop [s string output []]
;;       (if (< (count s) n)
;;         output
;;         (recur (drop 1 s) (conj output (apply str (take n s))))))))


;; lazy
(defn lazy-windows [s n]
  (when (seq s)
    (lazy-seq (cons (take n s) (lazy-windows (rest s) n)))))

(defn slices [string n]
  (if (= n 0)
    [""]
    (->> (lazy-windows string n)
         (take-while #(= n (count %)))
         (map (partial apply str)))))
