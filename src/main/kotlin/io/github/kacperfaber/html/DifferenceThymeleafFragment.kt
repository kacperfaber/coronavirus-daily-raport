package io.github.kacperfaber.html

class DifferenceThymeleafFragment(var title: String, var value: Int, var oldValue: Int, var daysAgo: Int) : ThymeleafFragment(
    "th-fragments/fragments",
    "diff",
    HashMap<String, Any>().apply {
        put("oldValue", oldValue)
        put("value", value)
        put("daysAgo", daysAgo)
        put("title", title)
    })