(ns xtrant-crawler.pages.home
  (:require
   [xtrant-crawler.components.header :as header]
   [xtrant-crawler.components.breadcrumb-header :as breadcrumb-header]))

(defn view []
  [breadcrumb-header/view]
  [header/view]
  [:div {:className "overflow-auto"}
   [:div {:className "flex-1 container py-4 text-accent-foreground"}]])