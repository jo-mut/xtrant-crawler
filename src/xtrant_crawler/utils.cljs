(ns xtrant-crawler.utils
  (:require
   ["clsx" :refer [clsx]]
   ["dotenv" :as dotenv]
   ["tailwind-merge" :refer [twMerge]]))

(.config dotenv)

(defn cn [& args]
  (twMerge (clsx (clj->js args))))
