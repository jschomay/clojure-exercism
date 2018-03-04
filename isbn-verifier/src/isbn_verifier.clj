(ns isbn-verifier)

(defn isbn?
  "ISBN structure: 1-234-56789-[0|X]
  Here's the magic formula for valid structures:
  (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0"
  [isbn]
  (letfn [(strip-dashes [s] (clojure.string/replace s #"-" ""))
          (add-by-position [i v]
            (if (= v \X)
              (* 10 (- 10 i))
              (* (Character/getNumericValue v) (- 10 i))))
          (validate-content [isbn]
            (->> isbn
                 ( strip-dashes)
                 ( map-indexed add-by-position)
                 (apply +)
                 (#(mod %1 11))
                 (= 0)))
          (validate-structure [isbn]
            (re-matches #"\d{9}[\dX]" isbn))]
    (boolean ( some->>
               (strip-dashes isbn)
               validate-structure
               validate-content))))

