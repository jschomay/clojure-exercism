(ns rna-transcription
  (:require [clojure.string :refer [join]]))

(defn to-rna [dna]
  (let [mapping {\G \C
                 \C \G
                 \T \A
                 \A \U}]
    (join "" (map #(or (get mapping %) (throw (AssertionError. "woah dude"))) dna))))
