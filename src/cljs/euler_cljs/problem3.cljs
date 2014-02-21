(ns euler.problem3
  (:use [clojure.set :only [union]]))

(def sqrt (.-sqrt js/Math))
(def floor (.-floor js/Math))

; I struggled with creating a prime-sieve function.  I first implemented one using sets, but it never finished executing...
; Instead, I took this solution from 'cjnirehs' at http://clojure-euler.wikispaces.com/Problem+003 which taught me how to
; use filters to create virtual sets (i.e. lazily-evaluated sets based on condition filters).  Wow!
; (Actually, after implementing, it's still really slow and never finishes in the browser; still interesting solution though)
(defn get-primes [n]
  (loop [p 2 sieve (range 2 n)]
    (if (> (* p p) n)
      sieve
      (let [next-sieve (filter #(or (= % p) (not= 0 (mod % p))) sieve)
            next-p (first (filter #(> % p) next-sieve))]
        (recur next-p next-sieve)))))

(defn max-prime-factor-sieve [number]
  (let [primes (get-primes number)]
    (last (filter #(zero? (mod number %)) primes))))

; This solution is even better, by 'achim_p'.  It uses simple tail loop to linearly search and divide out factors from the number.
(defn max-prime-factor [number]
  (let [limit (floor (sqrt number))
        factor? (fn [n d] (zero? (mod n d)))
        factor-out (fn [n d] (if (factor? n d) (recur (/ n d) d) n))]
    (loop [result number, d 2]
      (cond
        (> d limit) result

        ; factor is prime if it divides the result (since the result has no prime factors less than factor)
        ; divide the factor out of the result, and try again
        (factor? result d)
          (let [new-result (factor-out result d)]
            (if (= 1 new-result)
              d
              (recur new-result (inc d))))

        ; try next if factor does not divide result
        :else (recur result (inc d))))))

(defn answer [] (max-prime-factor 600851475143))
