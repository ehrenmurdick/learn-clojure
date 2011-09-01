(in-ns 'foo)
(clojure.core/refer 'clojure.core)

(defn fib [n]
  (condp = n
    0 1
    1 1
    (+
      (fib (- n 1)) (fib (- n 2)))))

