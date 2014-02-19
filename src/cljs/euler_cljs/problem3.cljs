(ns euler.problem3)

(def sqrt (.-sqrt js/Math))
(def floor (.-floor js/Math))

(defn max-prime-factor [x]
  (let [limit (floor (sqrt n))]
    "have to figure out how to iterate and create a sieve"))

(defn answer [] (max-prime-factor 600851475143))
