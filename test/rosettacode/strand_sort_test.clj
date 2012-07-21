(ns rosettacode.strand-sort-test
  (:use clojure.test
        rosettacode.strand-sort))

(deftest merge-join-test
  (testing "Empty"
           (is (= (merge-join [] []) []))
           (are [x] (= x [1])
                (merge-join [] [1])
                (merge-join [1] [])))
  (testing "Interleaved"
           (are [x] (= x [1 2 3 4 5 6 7 8])
                (merge-join [1 3 5 7] [2 4 6 8])
                (merge-join [1 3 5 7 8] [2 4 6])
                (merge-join [1 3 4 5 6 7 8] [2])))
  (testing "Runs"
           (are [x] (= x [1 2 3 4 5 6 7 8])
                (merge-join [1 2 3 4] [5 6 7 8])
                (merge-join [1 2 6 7] [3 4 5 8]))))

(deftest unbraid-test
  (testing "Empty"
           (is (nil? (unbraid []))))
  (testing "All"
           (is (= (unbraid [1 2 3 4])
                  [[1 2 3 4] []])))
  (testing "Interleaved"
           (is (= (unbraid [1 5 2 6 3 7 4])
                  [[1 5 6 7] [2 3 4]]))))

(deftest strand-sort-test
  (testing "Sorting"
           (are [x] (= (strand-sort x)
                       (sort x))
                [1 2 3 4]
                [2 3 4 1]
                [3 4 1 2]
                [1 3 4 2]
                [2 1 4 3]
                [4 3 2 1])))



