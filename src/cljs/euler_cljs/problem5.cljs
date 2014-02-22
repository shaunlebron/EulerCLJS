(ns euler.problem5)

; I was able to remember the simple formula for computing the GCD of two numbers A and B
; becuase I had sought an intuitive explanation for why it works:
;
; The euclidean algorithm hides something really beautiful and intuitive about "units".

;                 A = X units
; |-------------------------------------|
; |-----------------|
;    B = Y units    |-------------------|
;                    (A-B) = (X-Y) units
;
;              The max possible "unit" size we can use to represent both A and B
;              must be the same for (A-B).  You might have to stare above to realize this.
;             
;              So max_unit(A,B) = max_unit(B, A-B)
;
;                 (Which also means that it's equal to max_unit(B, A mod B) by extension.)
;
;              "max_unit" = "greatest common factor"  (they mean the same thing)

; 
(defn gcd [a b]
  (cond
    (< a b) (recur b a)
    (zero? b) a
    :else (recur b (mod a b))))

(defn lcm [a b] (/ (* a b) (gcd a b)))

(defn answer [] (reduce lcm (range 1 21)))
