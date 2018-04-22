(ns nucleotide-count)

(def nucleotides #{\A \T \C \G})

(defn count [nucleotide strand]
  {:pre [(nucleotides  nucleotide)]}
  (clojure.core/count (filter #(= nucleotide %) strand)))

(defn nucleotide-counts [strand]
  {\A (count \A strand)
   \T (count \T strand)
   \C (count \C strand)
   \G (count \G strand)})
