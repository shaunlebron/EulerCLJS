(ns euler.problem1)

(defn divisible-by-any? [n factors]
  (some #(zero? (mod n %)) factors))

(defn answer []
  (->> (range 1 1000)
       (filter #(divisible-by-any? % [3 5]))
       (reduce +)))
