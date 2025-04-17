(ns xtrant-crawler.components.sidebar
  (:require
   ["lucide-react" :refer [HomeIcon]]
   ["react-router-dom" :refer [Link useLocation]]
   [clojure.string :as str]
   [xtrant-crawler.components.core :as ui-core]
   [xtrant-crawler.components.logo :as logo]))

(def sidebar-routes
  [{:href  ""
    :label "Home"
    :icon  HomeIcon}
   {:href  "/workflows"
    :label "Workflows"
    :icon  HomeIcon}
   {:href  "/credentials"
    :label "Credentials"
    :icon  HomeIcon}
   {:href  "/billing"
    :label "Billing"
    :icon  HomeIcon}])

(defn active-route-variant [item pathname]
  (if (and (> (count pathname) 0) (str/includes? (:href item) pathname))
    "sidebarActiveItem"
    "sidebarItem"))

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
           sidebar-routes)]]))


(defn view []
  [:f> f-view])