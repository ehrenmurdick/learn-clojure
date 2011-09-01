(in-ns 'stemmer)
(clojure.core/refer 'clojure.core)

;; :word = input string
;; :index = general offset into string
(defstruct stemmer :word :index)


(defn make-stemmer
  "This returns a stemmer structure for the given word."
  [word]
  (struct stemmer (vec word) (dec (count word))))


(defn reset-index
  "This returns a new stemmer with the :word vector and
  :index set to the last index."
  [word-vec]
  (struct stemmer word-vec (dec (count word-vec))))


(defn get-index
  "This returns a valid value of j."
  [stemmer]
  (if-let [j (:index stemmer)]
    (min j (dec (count (:word stemmer))))
    (dec (count (:word stemmer)))))


(defn subword
  "This returns the subword in the stemmer from 0..j."
  [stemmer]
  (let [word (:word stemmer), j (inc (get-index stemmer))]
    (subvec word 0 j)))


(def word (struct stemmer (vec "foobar")))
