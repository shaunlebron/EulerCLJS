(ns euler.problem2)

(defn fib [[a b]] [b (+ a b)])
(defn fib-seq [] (map first (iterate fib [1 2])))

(defn answer [] (reduce + (filter even? (take-while #(<= % 4000000) (fib-seq)))))
