(ns xtrant-crawler.utils
  (:require 
   ["clsx" :refer [clsx]]
   ["tailwind-merge" :refer [twMerge]]))

(defn cn [& args]
  (twMerge (clsx (clj->js args))))