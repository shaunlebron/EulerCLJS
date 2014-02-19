(ns euler)

(defn fib [[a b]] [b (+ a b)])
(defn fib-seq [] (map first (iterate fib [1 2])))

(defn problem2 [] (reduce + (filter even? (take-while #(<= % 4000000) (fib-seq)))))
