(ns xtrant-crawler.components.logo
  (:require
   ["react-router-dom" :refer [Link]]
   ["lucide-react" :refer [SquareDashedMousePointer]]
   [clojure.string :as str]))

(defn view
  [{:keys [font-size icon-size]
    :or {font-size "text-2xl"
         icon-size 20}}]
  [:> Link {:to "/home"
            :className (str/join "font-extrabold items-center gap-2" [font-size])}
   [:div {:className "rounded-xl bg-gradient-to-r from-emarald-500 to-orange-600 p-2"}
    [:> SquareDashedMousePointer {:size icon-size
                                  :className "stroke-white"}]]])