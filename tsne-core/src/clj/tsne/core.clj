(ns tsne.core
  (:require [clojure.core.matrix :as m]
            [clojure.core.matrix.macros :refer [c-for]])
  (:import [com.jujutsu.tsne FastTSne]))

(defn core-mat-to-double-doubles
  ^"[[D" [matrix]
  (let [mat-shape (m/shape matrix)
        rows (m/rows matrix)
        num-rows (first mat-shape)
        num-cols (second mat-shape)
        ^"[[D" retval (make-array (Class/forName "[D") num-rows)]
    (c-for [idx 0 (< idx num-rows) (inc idx)]
           (aset retval idx (m/to-double-array (m/get-row matrix idx))))
    retval))


(defn tsne
  "Run tsne on a clojure.core.matrix.  Returns double [][]"
  ^"[[D" [matrix out-dims & {:keys [perplexity iters]
                             :or {perplexity 20.0 iters 1000}}]
  (let [tsne (FastTSne.)
        mat-shape (m/shape matrix)]
    (.tsne tsne (core-mat-to-double-doubles matrix) out-dims mat-shape perplexity iters)))
