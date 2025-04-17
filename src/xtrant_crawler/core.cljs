(ns xtrant-crawler.core
  (:require
   ["react-router-dom" :refer [BrowserRouter]]
   [reagent.dom :as rdom]
   [xtrant-crawler.components.header :as header]
   [xtrant-crawler.components.sidebar :as sidebar]
   [xtrant-crawler.components.breadcrumb-header :as breadcrumb-header]
   [xtrant-crawler.components.providers.app-providers :as theme-providers]
   xtrant-crawler.subs
   xtrant-crawler.events))

(defn app []
  [:div {:className "flex h-screen"}
   [sidebar/view]
   [:div {:className "flex flex-col flex-1 min-h-screen"}
    [breadcrumb-header/view]
    [header/view]
    [:div {:className "overflow-auto"}
     [:div {:className "flex-1 container py-4 text-accent-foreground"}]]]])

(defn themed-app []
  [theme-providers/provider
   {:default-theme "dark"
    :storage-key "vite-ui-theme"}
   [:> BrowserRouter
    [app]]])

(defn ^:export init []
  (rdom/render [themed-app] (.getElementById js/document "root")))