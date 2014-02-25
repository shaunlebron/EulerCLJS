(ns euler.problem6)

; We want to solve the following equation:
;
;      (1 + 2 + 3 + ... + 10) ^ 2       <- 1st term
;    - (1^2 + 2^2 + 3^2 + ... + 10^2)   <- 2nd term
;
; The distributive property tells us that the "1st term" is equal to:
; 
;          1 * (1 + 2 + 3 + ... + 10)
;        + 2 * (1 + 2 + 3 + ... + 10)
;        + 3 * (1 + 2 + 3 + ... + 10)
;        + ...
;        +10 * (1 + 2 + 3 + ... + 10)
;
; Applying the distribution property again gives us:
;
;          1*1 + 1*2 + 1*3 ... 1*10
;        + 2*1 + 2*2 + 2*3 ... 2*10
;        + 3*1 + 3*2 + 3*3 ... 3*10
;        + ...
;        +10*1 +10*2 +10*3 ...10*10
;
; We can represent this with a table:
;
;            1 2 3 4 5 6 7 8 9 10
;          1 * * * * * * * * * *
;          2 * * * * * * * * * *
;          3 * * * * * * * * * *
;          4 * * * * * * * * * *
;          5 * * * * * * * * * *
;          6 * * * * * * * * * *
;          7 * * * * * * * * * *
;          8 * * * * * * * * * *
;          9 * * * * * * * * * *
;         10 * * * * * * * * * *
;
; Each asterisk (*) represents the product of its row and column numbers.
; We add all the products together to get our result.
;
; Looking at the original equation, we are subtracting (1^2 + 2^2 + 3^2 + ... + 10^2).
; This means we eliminate the products at the diagonals:
;
;            1 2 3 4 5 6 7 8 9 10
;          1   * * * * * * * * *
;          2 *   * * * * * * * *
;          3 * *   * * * * * * *
;          4 * * *   * * * * * *
;          5 * * * *   * * * * *
;          6 * * * * *   * * * *
;          7 * * * * * *   * * *
;          8 * * * * * * *   * *
;          9 * * * * * * * *   *
;         10 * * * * * * * * *  
;
; Notice that the sums of the two triangles split by the diagonal
; are the same, due to commutativity (i.e. 1*2 = 2*1). Thus, we can
; just calculate the products above the diagonal and multiply the sum by 2:
;
;            1 2 3 4 5 6 7 8 9 10
;          1   * * * * * * * * *
;          2     * * * * * * * *
;          3       * * * * * * *
;          4         * * * * * *
;          5           * * * * *      x 2
;          6             * * * *
;          7               * * *
;          8                 * *
;          9                   *
;         10                    
;
; This gives us a form for our equation that is easier to compute.

; Calculates the ith row of an n-sized table
(defn row-sum [i n]
  (->> (range (+ i 1) (+ n 1))
       (reduce +)
       (* i)
       (* 2)))

; Calculates the sum of an n-sized table
(defn table-sum [n]
  (->> (range 1 (+ n 1))
       (map #(row-sum % n))
       (reduce +)))

(defn answer [] (table-sum 100))

