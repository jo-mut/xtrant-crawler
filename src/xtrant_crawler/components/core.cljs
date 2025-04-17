(ns xtrant-crawler.components.core
  (:require
   [reagent.core :as reagent]
   ["../../dist/components/ui/button" :refer [Button buttonVariants]]
   ["../../dist/components/ui/breadcrumb" :refer
    [Breadcrumb BreadcrumbList BreadcrumbItem BreadcrumbLink
     BreadcrumbPage BreadcrumbSeparator BreadcrumbEllipsis]]))

(def button Button)
(def button-variants buttonVariants)
(def breadcrumb Breadcrumb)
(def breadcrumb-ellipsis BreadcrumbEllipsis)
(def breadcrumb-list BreadcrumbList)
(def breadcrumb-item BreadcrumbItem)
(def breadcrumb-link BreadcrumbLink)
(def breadcrumb-page BreadcrumbPage)
(def breadcrumb-separator BreadcrumbSeparator)