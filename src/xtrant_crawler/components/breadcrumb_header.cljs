(ns xtrant-crawler.components.breadcrumb-header
  (:require
   [clojure.string :as str]
   ["react-router-dom" :refer [useLocation]]
   [xtrant-crawler.components.core :as ui-core]))

(defn f-view []
  (let [location (useLocation)
        pathname (.-pathname location)
        paths    (if (= pathname "/")
                   [""]
                   (str/split pathname #"/"))]
    [:div {:className "flex items-center flex-start"}
     [:> ui-core/breadcrumb
      [:> ui-core/breadcrumb-list
       (map-indexed
        (fn [index path]
          [:> ui-core/breadcrumb-item
           {:key index}
           [:> ui-core/breadcrumb-link
            {:className "capitalize"
             :href (str "/" path)}
            (if (= path "") "home" path)]])
        paths)]]]))

(defn view
  [props]
  [:f> f-view props])