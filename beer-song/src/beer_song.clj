(ns beer-song)

(defn verse
  "Returns the nth verse of the song."
  [n]
  (cond
    (= n 0) "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    (= n 1) "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    (= n 2) "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
    :else (str n " bottles of beer on the wall, " n " bottles of beer.\nTake one down and pass it around, " (dec n) " bottles of beer on the wall.\n")))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]
   (sing start 0))

  ([start end]
   (apply str (interpose "\n" (map verse (reverse (range end (inc start))))))))
