(ns euler.problem5)

(defn gcd [a b]
  (cond
    (< a b) (recur b a)
    (zero? b) a
    :else (recur b (mod a b))))

(defn lcm [a b] (/ (* a b) (gcd a b)))

(defn answer [] (reduce lcm (range 1 21)))
