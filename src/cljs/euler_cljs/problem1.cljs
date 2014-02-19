(ns euler.problem1)

(defn multOfAny [n factors] (some #(zero? (mod n %)) factors))

(defn answer []
  (->> (range 1 1000)
       (filter #(multOfAny % [3 5]))
       (reduce +)))
