(ns euler.problem1)

(defn multOf3or5 [n]
  (or
    (= 0 (mod n 3))
    (= 0 (mod n 5))))

(defn answer []
  (->> (range 1 1000)
       (filter multOf3or5)
       (reduce +)))
