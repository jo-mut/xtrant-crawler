(ns xtrant-crawler.utils
  (:require 
   ["clsx" :refer [clsx]]
   ["tailwind-merge" :refer [twMerge]]))

(defn cn [& inputs]
  (twMerge (clsx (clj->js inputs))))