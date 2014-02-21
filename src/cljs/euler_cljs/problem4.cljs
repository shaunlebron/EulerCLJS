(ns euler.problem4)

(defn get-pairs [top bot]
  (loop [i top prods []]
    (if (= i bot)
      prods
      (recur (dec i) (concat prods (map #(* i %) (range i bot -1)))))))

(defn palindrome? [n] (= (seq n) (reverse n)))

(defn answer []
  (apply max (filter #(palindrome? (str %)) (get-pairs 999 99))))
