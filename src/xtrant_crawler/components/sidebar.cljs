(ns xtrant-crawler.components.sidebar
  (:require
   ["lucide-react" :refer [HomeIcon]]
   ["react-router-dom" :refer [Link useLocation]]
   [clojure.string :as str]
   [xtrant-crawler.components.core :as ui-core]
   [xtrant-crawler.components.logo :as logo]
   [xtrant-crawler.routes :as routes]))

(defn active-route-variant [item pathname]
  (if (and (> (count pathname) 0) (str/includes? (:href item) pathname))
    "sidebarActiveItem"
    "sidebarItem"))

;; (defn mobile-side-bar []
  ;; [:div {:className "block border-separate bg-background md:hidden"}
  ;;  [:nav {:className "container flex items-center justify-between px-8"}]])

(defn- f-view []
  (let [location     (useLocation)
        pathname     (.-pathname location)]
    [:div {:className "hidden relative md:block min-w-[200px] 
                  max-w-[280px] h-screen overflow-hidden 
                  w-full bg-primary/5 dark:bg-secondary/30
                  dark:text-foreground text-muted-foreground 
                  border-r-2 border-separate"}
     [:div {:className "flex items-center justify-center gap-2 
                        border-b-[1px border-separate p-4]"}
      [logo/view]]

     [:div {:className "flex flex-col p-2"}
      (map (fn [item]
             [:> Link
              {:key       (:href item)
               :to        (:href item)
               :className (ui-core/button-variants #js {:variant (active-route-variant item pathname)})}
              [:> HomeIcon]
              (:label item)])
           routes/sidebar-routes)]]))


(defn view []
  [:f> f-view])