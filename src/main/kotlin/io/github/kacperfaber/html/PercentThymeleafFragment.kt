package io.github.kacperfaber.html

class PercentThymeleafFragment(
    var title: String,
    var value: Int,
    var totalValue: Int,
    var percent: Double
) :
    ThymeleafFragment("th-fragments/fragments", "percent-of", HashMap<String, Any>().apply {
        this["value"] = value
        this["title"] = title
        this["percent"] = percent
        this["totalValue"] = totalValue
    })
