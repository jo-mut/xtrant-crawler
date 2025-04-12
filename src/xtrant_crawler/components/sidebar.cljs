(ns xtrant-crawler.components.sidebar
  (:require
   ["lucide-react" :refer [HomeIcon]]
   ["react-router-dom" :refer [Link]]
   [re-frame.core :as rf]
   [xtrant-crawler.components.logo :as logo]))

(def sidebar-routes
  [{:href  ""
    :label "Home"
    :icon  HomeIcon}
   {:href  "workflows"
    :label "Workflows"
    :icon  HomeIcon}
   {:href  "credentials"
    :label "Credentials"
    :icon  HomeIcon}
   {:href  "billing"
    :label "Billing"
    :icon  HomeIcon}])

(defn view [routes]
  [:div {:className "hidden relative md:block min-w-[200px] max-w-[280px] h-screen overflow-hidden 
                     w-full bg-primary/5 dark:bg-secondary/30 dark:text-foreground text-muted-foreground 
                     border-r-2 border-separate"}
   [:div {:className "flex items-center justify-center gap-2 border-b-[1px border-separate p-4]"}
    [logo/view]]
   [:div {:className "flex flex-col p-2"}
    (map (fn [item]
           [:> Link
            {:key (:href item)
             :to (str "/" (:href item))}
            [:span (:label item)]
            [:> (:icon item) {:size 20}]])
         sidebar-routes)]])