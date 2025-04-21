(ns xtrant-crawler.core
  (:require
   ["react-router-dom" :refer [BrowserRouter  Route Routes]]
   ["@clerk/clerk-react" :refer [ClerkProvider SignedIn SignedOut SignInButton UserButton]]
   [reagent.dom :as rdom]
   [xtrant-crawler.components.sidebar :as sidebar] 
   [xtrant-crawler.components.providers.app-providers :as theme-providers]
   [xtrant-crawler.routes :as routes]
   [xtrant-crawler.config :as config]
   xtrant-crawler.subs
   xtrant-crawler.events))

(defn app []
  [:div {:className "flex h-screen"}
   [sidebar/view]
   [:div {:className "flex flex-col flex-1 min-h-screen"}
    [routes/home-routes]]])

(defn themed-app []
  [:> ClerkProvider
   {:publishableKey config/VITE_CLERK_PUBLISHABLE_KEY
    :afterSignOutUrl "/sign-in"
    :signUpFallbackRedirectUrl "/"
    :signInFallbackRedirectUrl "/"}
   [theme-providers/provider
    {:default-theme "dark"
     :storage-key "vite-ui-theme"}
    [:> BrowserRouter
     [app]]]])

(defn ^:export init []
  (rdom/render [themed-app] (.getElementById js/document "root")))