(ns euler)

(defn multOf3or5 [n]
    (or
        (= 0 (mod n 3))
        (= 0 (mod n 5))))

(defn problem1 [] (reduce + (filter multOf3or5 (range 1 1000))))
