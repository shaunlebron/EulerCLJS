(ns euler.problem2)

(defn fib [[a b]] [b (+ a b)])
(defn fib-seq [] (map first (iterate fib [1 2])))

(defn answer []
  (->> (fib-seq)
       (take-while (partial >= 4000000))
       (filter even?)
       (reduce +)))
