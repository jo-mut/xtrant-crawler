(ns xtrant-crawler.core
  (:require
   ["react-router-dom" :refer [BrowserRouter]]
   [reagent.dom :as rdom] 
   [xtrant-crawler.components.header :as header]
   [xtrant-crawler.components.sidebar :as sidebar]
   xtrant-crawler.subs
   xtrant-crawler.events))

(defn app []
  [:> BrowserRouter
   [:div {:className "flex h-screen"}
    [sidebar/view]
    [:div {:className "flex flex-col flex-1 min-h-screen"}
     [header/view]
     [:div {:className "overflow-auto"}
      [:div {:className "flex-1 container py-4 text-accent-foreground"}]]]]])

(defn ^:export init []
  (rdom/render [app] (.getElementById js/document "root")))
