(ns xtrant-crawler.pages.not-found
  (:require
   ["react-router-dom" :refer [Link]]
   ["lucide-react" :refer [ArrowLeft]]))

(defn view []
  [:div {:className "flex flex-col items-center justify-center min-h-screen h-4"}
   [:div {:className "text-center"}
    [:h1 {:className "text-6xl font-bold text-primary mb-4"}
     "404"]
    [:h2 {:className "text-2xl font-semibold mb-4"}
     "Page Not Found"]
    [:p {:className "text-muted-foreground mb-8 max-w-md"}
     "Don'nt worry even the best data sometimes gets lost in the internet"]
    [:div {:className "flex flex-col sm:flex-row justify-center gap-4"}
     [:> Link {:to "/"
               :className "flex items-center justify-center px-4 py-2 bg-primary text-white rounded-md 
                           hover:bg:primary/80 transition-colors"}
      [:> ArrowLeft {:className "w-4 h-4 mr-2"}]
      "Back to Dashboard"]]
    [:footer {:className "mt-12 text-center text-sm text-muted-foreground"}
     "If you believe this is an error, please contact our support team"]]])